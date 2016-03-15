/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Siyam
 */
public class CheckHallStatus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sendRequestToDataBase(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    void sendRequestToDataBase(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/json;charset=UTF-8");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uhms", "root", "");
            java.sql.Statement st = con.createStatement();
            StaticData.phone = request.getParameter("phone");
            StaticData.password = request.getParameter("password");
            StaticData.id = request.getParameter("id");
            ResultSet rs = st.executeQuery("SELECT gardian_password from gardian_info where id="
                    + StaticData.phone);
            if (rs.next()) {
                String pss = rs.getString(1);
                if (!StaticData.password.equals(pss)) {
                    throw new Exception("Password did not match");
                }
            } else {
                throw new Exception("No User Found by this Phone No");
            }
            rs = st.executeQuery("SELECT gardian_id FROM student_gardian_relation where student_id=" + StaticData.id);
            if (rs.next()) {
                String id = rs.getString(1);
                if (!StaticData.phone.contains(id)) {
                    throw new Exception("Gardian And Student Info Not related");
                }
            } else {
                throw new Exception("Unauthorized Access");
            }
            rs = st.executeQuery("SELECT * from check_in_out where day_time = (select MAX(day_time) from check_in_out WHERE id =" + StaticData.id + ")");
            JsonWriter gsonWriter = new JsonWriter(pw);
            ResultSetMetaData metaData = rs.getMetaData();
            if (rs.next()) {
                gsonWriter.beginObject();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    gsonWriter.name(metaData.getColumnLabel(i + 1));
                    gsonWriter.value(rs.getString(i + 1));
                }
            } else {
                throw new Exception("Student information Not Found");
            }
//currret month meal calculation
            Calendar calendar = Calendar.getInstance();
            System.out.println(calendar);
            Timestamp current = new Timestamp(calendar.getTimeInMillis());
            //  System.out.println(current);
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 0, 0, 0);
            Timestamp start = new Timestamp(calendar.getTimeInMillis());
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
            Timestamp end = new Timestamp(calendar.getTimeInMillis());

            rs = st.executeQuery("select sum(quantity) from meal_log  where id=" + StaticData.id + " AND day_time>= '" + start
                    + "' AND day_time<='" + end + "' AND type='BREAKFAST'");
            gsonWriter.name("BREAKFAST");
            if (rs.next()) {
                gsonWriter.value(rs.getInt(1) + "");
            } else {
                gsonWriter.value("0");
            }

            rs = st.executeQuery("select sum(quantity) from meal_log  where id=" + StaticData.id + " AND day_time>= '" + start
                    + "' AND day_time<='" + end + "' AND type='LUNCH'");
            gsonWriter.name("LUNCH");
            if (rs.next()) {
                gsonWriter.value(rs.getInt(1) + "");
            } else {
                gsonWriter.value("0");
            }
            rs = st.executeQuery("select sum(quantity) from meal_log  where id=" + StaticData.id + " AND day_time>= '" + start
                    + "' AND day_time<='" + end + "' AND type='DINNER'");
            gsonWriter.name("DINNER");
            if (rs.next()) {
                gsonWriter.value(rs.getInt(1) + "");
            } else {
                gsonWriter.value("0");
            }

            gsonWriter.name("status");
            gsonWriter.value("200");
            gsonWriter.endObject();
            gsonWriter.flush();
            gsonWriter.close();

        } catch (Exception ex) {
            JsonWriter gsonWriter = new JsonWriter(pw);
            gsonWriter.beginObject();
            gsonWriter.name("status");
            gsonWriter.value("400");
            gsonWriter.name("error_desc");
            gsonWriter.value(ex.getMessage());
            gsonWriter.endObject();
            gsonWriter.flush();
            gsonWriter.close();

            //  pw.println(ex);
        }
    }

}

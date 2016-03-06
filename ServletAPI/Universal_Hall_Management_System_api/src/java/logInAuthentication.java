/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.stream.JsonWriter;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Siyam
 */
public class logInAuthentication extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(logInAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(logInAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(logInAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(logInAuthentication.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            ResultSet rs = st.executeQuery("SELECT *from student_info INNER JOIN gardian_info ON( student_info.id = gardian_info.id) WHERE gardian_phone=" + StaticData.phone + "");
            StaticData.resultSet = rs;
            if(!rs.next())
                throw new Exception("User Not Found On DATABASE");
               
            JsonWriter gsonWriter = new JsonWriter(pw);
            ResultSetMetaData metaData = rs.getMetaData();
            gsonWriter.beginObject();
            gsonWriter.name("info");
            gsonWriter.beginArray();
            rs.previous();
            while (rs.next()) {
                gsonWriter.beginObject();
                for (int indx = 1; indx <= metaData.getColumnCount(); indx++) {
                    gsonWriter.name(metaData.getColumnLabel(indx));
                    gsonWriter.value(rs.getString(indx));
                }
                gsonWriter.endObject();
            }
            gsonWriter.endArray();
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
            gsonWriter.value(ex.toString());
            gsonWriter.endObject();
            gsonWriter.flush();
            gsonWriter.close();

            //  pw.println(ex);
        }
    }
}

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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Siyam
 */
public class ChangePassword extends HttpServlet {

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
    
    void sendRequestToDataBase(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/json;charset=UTF-8");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uhms", "root", "");
            java.sql.Statement st = con.createStatement();
            StaticData.phone = request.getParameter("phone");
            StaticData.password = request.getParameter("oldpassword");
            StaticData.newPassword = request.getParameter("newpassword");
            ResultSet rs = st.executeQuery("SELECT gardian_password from gardian_info where id="
                    +  StaticData.phone);
            if(rs.next()){
                String pss = rs.getString(1);
                if(!StaticData.password.equals(pss)){
                    throw new Exception("Enter Current Password Correctly.");
                }
            }
            else throw new Exception("No User Found by this Phone No");
            if(StaticData.newPassword.isEmpty())
                throw new Exception("Password can't be empty.");
                
            int executeUpdate = st.executeUpdate("UPDATE gardian_info SET gardian_password = '" + StaticData.newPassword  +"'"
                    + " WHERE id=" + StaticData.phone);
            JsonWriter gsonWriter = new JsonWriter(pw);
            gsonWriter.beginObject();
            if(executeUpdate != 1)
                throw  new Exception("Password Change failed.");
            gsonWriter.name("status");
            gsonWriter.value("200");
             gsonWriter.name("message");
            gsonWriter.value("Password Changed Successfully.");
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

}

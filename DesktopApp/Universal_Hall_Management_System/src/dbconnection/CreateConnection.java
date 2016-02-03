/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import extra.Pair;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Siyam
 */
public class CreateConnection {
    

    public static Pair<ResultSet,ResultSetMetaData> getResultFromDatabase(String query) throws ClassNotFoundException, SQLException {

        try {
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uhms","root","");
            java.sql.Statement st = con.createStatement();
            System.out.println("connection established successfully...!!\n");

            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsm = rs.getMetaData();
            Pair<ResultSet,ResultSetMetaData> result = new Pair(rs, rsm);
            return result;
        }
        catch(ClassNotFoundException | SQLException e) {
            
            System.out.println(e);
        }
        return null;

    }
     public static void insertDatatoDatabase(String query){
        try {
            System.out.println(query);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/uhms","root","");
            java.sql.Statement st = con.createStatement();
            st.execute(query);
            System.out.println("connection established successfully...!!\n");

        }
        catch(ClassNotFoundException | SQLException e) {
            
            System.out.println(e);
        }

    }
}

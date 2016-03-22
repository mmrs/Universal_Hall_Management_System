/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryPackage;

import dbconnection.CreateConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tahmid
 */
public class ViewDueTableQuery {

    public static ResultSet getMealDueResultSet(int startYear, int startMonth, int endYear, int endMonth) throws ClassNotFoundException, SQLException {
        String statrTime = BasicQuery.findYearMontyStartStringForMealQuery(startYear, startMonth);
        String endTime = BasicQuery.findYearMontyStartStringForMealQuery(endYear, endMonth);
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept," + "student_info.student_session,meal_due_table.total_meal,meal_due_table.total_due," + "meal_due_table.year_month FROM student_info JOIN meal_due_table ON student_info.id = meal_due_table.id " + "WHERE meal_due_table.year_month>='" + statrTime + "' and meal_due_table.year_month <= '" + endTime + "'";
        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }
     public static ResultSet getMealDueResultSetForAStudent(int startYear, int startMonth, int endYear, int endMonth,int id) throws ClassNotFoundException, SQLException {
        String statrTime = BasicQuery.findYearMontyStartStringForMealQuery(startYear, startMonth);
        String endTime = BasicQuery.findYearMontyStartStringForMealQuery(endYear, endMonth);
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept," 
                + "student_info.student_session,meal_due_table.total_meal,meal_due_table.total_due," 
                + "meal_due_table.year_month FROM student_info JOIN meal_due_table ON student_info.id = meal_due_table.id " 
                + "WHERE meal_due_table.year_month>='" 
                + statrTime 
                + "' and meal_due_table.year_month <= '" 
                + endTime + "' and student_info.id = "
                + id;
        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }
        public static ResultSet getMealDueResultSetForAStudent(int id) throws ClassNotFoundException, SQLException {
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,student_info.student_session," 
                + "meal_due_table.total_meal,meal_due_table.total_due,meal_due_table.year_month " 
                + "FROM student_info JOIN meal_due_table ON student_info.id = meal_due_table.id"
                + " WHERE student_info.id = "
                + id;
        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }
    public static ResultSet getMealDueResultSet() throws ClassNotFoundException, SQLException {
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,student_info.student_session," + "meal_due_table.total_meal,meal_due_table.total_due,meal_due_table.year_month " + "FROM student_info JOIN meal_due_table ON student_info.id = meal_due_table.id";
        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }

    public static ResultSet getMealDueResultSetForASession(int startYear, int startMonth, int endYear, int endMonth, int session) throws ClassNotFoundException, SQLException {
        String statrTime = BasicQuery.findYearMontyStartStringForMealQuery(startYear, startMonth);
        String endTime = BasicQuery.findYearMontyStartStringForMealQuery(endYear, endMonth);
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept," + 
                "student_info.student_session,meal_due_table.total_meal,meal_due_table.total_due," + 
                "meal_due_table.year_month FROM student_info JOIN meal_due_table ON student_info.id = meal_due_table.id " + 
                "WHERE meal_due_table.year_month>='" 
                + statrTime 
                + "' and meal_due_table.year_month <= '" 
                + endTime 
                + "' and student_info.student_session = " 
                + session;
        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }

    public static ResultSet getMealDueResultSetForASession(int session) throws ClassNotFoundException, SQLException {

        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,student_info.student_session,"
                + "meal_due_table.total_meal,meal_due_table.total_due,meal_due_table.year_month FROM student_info JOIN "
                + "meal_due_table ON student_info.id = meal_due_table.id "
                + "WHERE student_info.student_session = "
                + session;
        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }

    public static ResultSet getMealDueResultSetForADepartment(String dept) throws ClassNotFoundException, SQLException {

        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,student_info.student_session,"
                + "meal_due_table.total_meal,meal_due_table.total_due,meal_due_table.year_month FROM student_info JOIN "
                + "meal_due_table ON student_info.id = meal_due_table.id "
                + "WHERE student_info.student_dept = '"
                + dept
                + "'";

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }

    public static ResultSet getMealDueResultSetForADepartment(int startYear, int startMonth, int endYear, int endMonth, String dept) throws ClassNotFoundException, SQLException {
        String statrTime = BasicQuery.findYearMontyStartStringForMealQuery(startYear, startMonth);
        String endTime = BasicQuery.findYearMontyStartStringForMealQuery(endYear, endMonth);
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept," + 
                "student_info.student_session,meal_due_table.total_meal,meal_due_table.total_due," + 
                "meal_due_table.year_month FROM student_info JOIN meal_due_table ON student_info.id = meal_due_table.id " + 
                "WHERE meal_due_table.year_month>='" 
                + statrTime 
                + "' and meal_due_table.year_month <= '" 
                + endTime 
                + "' and student_info.student_dept = '" 
                + dept
                + "'";
        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }
    
    public static ResultSet getMealDueResultSetForADepartmentAndSession(int startYear, int startMonth, int endYear, int endMonth, String dept,int session) throws ClassNotFoundException, SQLException {
        String statrTime = BasicQuery.findYearMontyStartStringForMealQuery(startYear, startMonth);
        String endTime = BasicQuery.findYearMontyStartStringForMealQuery(endYear, endMonth);
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept," + 
                "student_info.student_session,meal_due_table.total_meal,meal_due_table.total_due," + 
                "meal_due_table.year_month FROM student_info JOIN meal_due_table ON student_info.id = meal_due_table.id " + 
                "WHERE meal_due_table.year_month>='" 
                + statrTime 
                + "' and meal_due_table.year_month <= '" 
                + endTime 
                + "' and student_info.student_dept = '" 
                + dept
                + "' and student_info.student_session = "
                + session;
        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }
      public static ResultSet getMealDueResultSetForADepartmentAndSession(String dept,int session) throws ClassNotFoundException, SQLException {

        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,student_info.student_session,"
                + "meal_due_table.total_meal,meal_due_table.total_due,meal_due_table.year_month FROM student_info JOIN "
                + "meal_due_table ON student_info.id = meal_due_table.id "
                + "WHERE student_info.student_dept = '"
                + dept
                + "' and student_info.student_session = "
                + session;

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return resultSet;
    }
}

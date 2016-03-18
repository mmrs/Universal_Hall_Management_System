/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryPackage;

import BasicPackages.Student;
import dbconnection.CreateConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Tahmid
 */
public class BasicQuery {

    public static final String CURRENT = "current";

    public static Student findStudent(String regNo) throws ClassNotFoundException, SQLException {
        String query = "SELECT student_info.id,student_info.student_name, student_info.student_dept,student_info.student_session"
                + " FROM student_info "
                + "WHERE student_info.id = "
                + regNo;

        ResultSet result = CreateConnection.getResultFromDatabase(query);

        Student student = null;
        boolean curStudent = false;
        boolean alreadyHasSeat = true;
        if (result.next()) {
            student = new Student(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
        }
        return student;
    }

    public static int isAlreadyHasSeat(String regNo) throws ClassNotFoundException, SQLException {
        String query = "SELECT allocated.room_number FROM allocated "
                + "WHERE allocated.id = "
                + regNo;
        ResultSet result = CreateConnection.getResultFromDatabase(query);

        if (result.next()) {
            return result.getInt(1);
        }

        return 0;
    }

    public static boolean isStudentCurrent(String regNo) throws ClassNotFoundException, SQLException {
        String query = "SELECT student_status.status FROM student_status "
                + "WHERE student_status.id = "
                + regNo;

        ResultSet result = CreateConnection.getResultFromDatabase(query);
        if (result.next()) {
            if (result.getString(1).equals(CURRENT) == true) {
                return true;
            }
        }
        return false;
    }

    public static boolean removeStudentFromHall(Student student) {
        String query = "DELETE FROM allocated WHERE "
                + "allocated.id = "
                + student.getId();

        CreateConnection.insertDatatoDatabase(query);

        query = "UPDATE current_rooms_info SET current_rooms_info.capacity = current_rooms_info.capacity + 1 "
                + "WHERE current_rooms_info.room_number = " + student.getRoom_number();
        CreateConnection.insertDatatoDatabase(query);

        return true;
    }

    public static boolean allocateSeat(Student student) {
        if (student.getRoom_number() == 0) {
            JOptionPane.showMessageDialog(null, "This student does not has a seat");
        }
        String query = "INSERT INTO allocated "
                + "VALUES("
                + student.getId() + "," + student.getRoom_number() + ")";

        CreateConnection.insertDatatoDatabase(query);

        query = "UPDATE current_rooms_info "
                + "set current_rooms_info.capacity = current_rooms_info.capacity - 1"
                + " WHERE current_rooms_info.room_number = " + student.getRoom_number();

        CreateConnection.insertDatatoDatabase(query);
        return true;
    }

    public static ArrayList<Student> getStudentList(String session, String dept) throws ClassNotFoundException, SQLException {
        String query = "SELECT p.id,p.student_name,p.student_dept,p.student_session,allocated.room_number "
                + "FROM (SELECT student_info.id,student_info.student_name,student_info.student_dept,student_info.student_session"
                + " FROM student_info WHERE student_info.student_session = "
                + session
                + " AND student_info.student_dept = "
                + "'"
                + dept.toUpperCase()
                + "'"
                + " ) p "
                + "INNER JOIN allocated WHERE p.id = allocated.id";

        ResultSet result = CreateConnection.getResultFromDatabase(query);

        ArrayList<Student> studentList = new ArrayList<>();
        while (result.next()) {
            Student st = new Student(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5));
            studentList.add(st);
        }

        return studentList;
    }

    public static void allocateASeatToStudent(Student st) {

        st.getId();
        String query = "INSERT INTO allocated VALUES("
                + st.getId()
                + ","
                + st.getRoom_number()
                + ")";
        CreateConnection.insertDatatoDatabase(query);
        query = "UPDATE current_rooms_info "
                + "set current_rooms_info.capacity = current_rooms_info.capacity - 1"
                + " WHERE current_rooms_info.room_number = " + st.getRoom_number();

        CreateConnection.insertDatatoDatabase(query);

        return;
    }

    public static ResultSet getUnallocatedStudentResultSet() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        result = CreateConnection.getResultFromDatabase("SELECT COUNT(id) as count FROM allocated");

        int numberOfRow = 0;
        System.out.println(result);

        if (result.next()) {
            numberOfRow = result.getInt("count");
        }

        System.out.println("number of row = " + numberOfRow);
        if (numberOfRow == 0) {
            result = CreateConnection.getResultFromDatabase("SELECT student_info.id , student_info.student_name,"
                    + "student_info.student_dept,student_info.student_session"
                    + " FROM student_info,student_status WHERE student_info.id = student_status.id "
                    + "and student_status.status = 'current'");
        } else if (numberOfRow > 0) {
            result = CreateConnection.getResultFromDatabase("SELECT t.id,t.student_name,t.student_dept,t.student_session from "
                    + "( SELECT student_info.id , student_info.student_name,student_info.student_dept,student_info.student_session FROM student_info "
                    + "INNER JOIN student_status on student_info.id = student_status.id "
                    + "WHERE student_status.status='current') t LEFT JOIN "
                    + "allocated on t.id = allocated.id WHERE allocated.id is null;");
        }
        return result;
    }

    public static void setMealRate(int rate, int year, int month) throws SQLException, ClassNotFoundException {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Timestamp current = new Timestamp(calendar.getTimeInMillis());
        calendar.set(year,month,1,0,0,0);
         
        Timestamp yearMonth = new Timestamp(calendar.getTimeInMillis());
        
        String yearMonthTime = yearMonth.toString().substring(0, 19);
        
        System.out.println(yearMonthTime);
        
        int flag = 0;
        
        String query = "SELECT meal_rate.rate FROM meal_rate WHERE meal_rate.year_month = '"
                + yearMonthTime
                + "'";
        
        ResultSet result = CreateConnection.getResultFromDatabase(query);
        if(result.next()){
            flag = 1;
            System.out.println(result);
        }
        System.out.println("Flag = "+flag);
        if(flag==1){
            query = "UPDATE meal_rate set meal_rate.rate = "
                    + rate
                    + " WHERE meal_rate.year_month = '"
                    + yearMonthTime
                    + "'";
        }else{
            query = "INSERT INTO meal_rate VALUES('"
                    + yearMonthTime
                    + "',"
                    + rate
                    + ")";
        }
        CreateConnection.insertDatatoDatabase(query);
        
        
    }

}

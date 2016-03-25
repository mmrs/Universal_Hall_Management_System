/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryPackage;

import BasicPackages.MealData;
import BasicPackages.MealDue;
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
        String query = "INSERT INTO allocated(allocated.id,allocated.room_number) "
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
        String query = "INSERT INTO allocated(allocated.id,allocated.room_number) VALUES("
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

    public static void setMealRate(double rate, int year, int month) throws SQLException, ClassNotFoundException {

        String yearMonthTime = BasicQuery.findYearMontyStartStringForMealQuery(year, month);
        System.out.println(yearMonthTime);
        BasicQuery.findYearMonthEndStringForMealQuery(year, month);
        int flag = 0;
        String query = "SELECT meal_rate.rate FROM meal_rate WHERE meal_rate.year_month = '"
                + yearMonthTime
                + "'";
        ResultSet result = CreateConnection.getResultFromDatabase(query);
        if (result.next()) {
            flag = 1;
            System.out.println(result);
        }
        System.out.println("Flag = " + flag);
        if (flag == 1) {
            query = "UPDATE meal_rate set meal_rate.rate = "
                    + rate
                    + " WHERE meal_rate.year_month = '"
                    + yearMonthTime
                    + "'";
        } else {
            query = "INSERT INTO meal_rate VALUES('"
                    + yearMonthTime
                    + "',"
                    + rate
                    + ")";
        }
        CreateConnection.insertDatatoDatabase(query);
    }

    public static int getMealRate(int year, int month) throws ClassNotFoundException, SQLException {
        String yearMonth = findYearMontyStartStringForMealQuery(year, month);
        int val = -1;

        String query = "SELECT * FROM `meal_rate` WHERE meal_rate.year_month='"
                + yearMonth
                + "';";

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        if (resultSet.next()) {
            val = resultSet.getInt(2);
        }

        return val;

    }

    public static double getCurrentMealRate(int year, int month) throws ClassNotFoundException, SQLException {
        String start = findYearMontyStartStringForMealQuery(year, month);
        String end = findYearMonthEndStringForMealQuery(year, month);

        ResultSet resultSet = CreateConnection.getResultFromDatabase("select sum(quantity) from meal_log  where day_time>= '" + start
                + "' AND day_time<='" + end + "'");
        int totalMeal = 1;
        int totalBazarAmount = 0;
        if (resultSet.next()) {
            totalMeal = resultSet.getInt(1);
        }

        resultSet = CreateConnection.getResultFromDatabase("select sum(amount) from bazar_info  where day_time>= '" + start
                + "' AND day_time<='" + end + "'");
        if (resultSet.next()) {
            totalBazarAmount = resultSet.getInt(1);
        }
        if(totalMeal==0) return 0;
        return ((double)totalBazarAmount) / totalMeal;
    }

    public static String findYearMontyStartStringForMealQuery(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Timestamp current = new Timestamp(calendar.getTimeInMillis());
        calendar.set(year, month, 1, 0, 0, 0);

        Timestamp yearMonth = new Timestamp(calendar.getTimeInMillis());

        String yearMonthTime = yearMonth.toString().substring(0, 19);
        return yearMonthTime;
    }

    public static String findYearMonthEndStringForMealQuery(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        // System.out.println(calendar);
        Timestamp current = new Timestamp(calendar.getTimeInMillis());
        calendar.set(year, month, 1, 0, 0, 0);
        calendar.set(year, month, calendar.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);

        Timestamp yearMonthEnd = new Timestamp(calendar.getTimeInMillis());

        String yearMonthEndTime = yearMonthEnd.toString().substring(0, 19);
        // System.out.println("end = "+yearMonthEndTime);
        return yearMonthEndTime;
    }

    public static ArrayList<MealDue> getTotalMealDataOfAMonth(int year, int month) throws ClassNotFoundException, SQLException {
        String start = findYearMontyStartStringForMealQuery(year, month);
        int totalBrakfast = 0;
        String startTime = findYearMontyStartStringForMealQuery(year, month);
        String endTime = findYearMonthEndStringForMealQuery(year, month);

        String query = "SELECT meal_log.id , sum(meal_log.quantity) "
                + " FROM meal_log WHERE  meal_log.day_time>='"
                + startTime
                + "' and meal_log.day_time<='"
                + endTime
                + "' GROUP BY meal_log.id";

        ResultSet result = CreateConnection.getResultFromDatabase(query);
        ArrayList<MealDue> mealDue = new ArrayList<>();
        while (result.next()) {
            mealDue.add(new MealDue(result.getInt(1), result.getInt(2)));
        }
        return mealDue;
    }

    public static void updateMealDueTable(ArrayList<MealDue> mealDues, double mealRate, int year, int month) {
        String yearMonth = findYearMontyStartStringForMealQuery(year, month);
        String query = "DELETE FROM meal_due_table WHERE meal_due_table.year_month = "
                + "'" + yearMonth + "'";
        CreateConnection.insertDatatoDatabase(query);

        for (MealDue md : mealDues) {
            query = "INSERT INTO meal_due_table VALUES("
                    + md.getId()
                    + ","
                    + md.getTotal()
                    + ","
                    + "'"
                    + yearMonth
                    + "'"
                    + ","
                    + md.getTotal() * mealRate
                    + ");";
            CreateConnection.insertDatatoDatabase(query);
        }

    }

    public static ArrayList<MealData> getStudentMealData(Calendar start, Calendar end) throws ClassNotFoundException, SQLException {
        Timestamp startTimestamp = findStartOfDayTimeStamp(start);
        Timestamp endTimestamp = findEndOfDayTimeStamp(end);

        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE meal_log.day_time>='"
                + startTimestamp
                + "' and meal_log.day_time<='"
                + endTimestamp
                + "' ";

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);

    }

    public static ArrayList<MealData> getStudentMealData() throws ClassNotFoundException, SQLException {

        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id ";

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);

    }

    public static ArrayList<MealData> getStudentMealDataForASession(Calendar start, Calendar end, int session) throws ClassNotFoundException, SQLException {
        Timestamp startTimestamp = findStartOfDayTimeStamp(start);
        Timestamp endTimestamp = findEndOfDayTimeStamp(end);

        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE meal_log.day_time>='"
                + startTimestamp
                + "' and meal_log.day_time<='"
                + endTimestamp
                + "'" + " and student_info.student_session="
                + session;

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);
    }

    public static ArrayList<MealData> getStudentMealDataForASession(int session) throws ClassNotFoundException, SQLException {
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE student_info.student_session="
                + session;

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);

    }

    public static ArrayList<MealData> getStudentMealDataForADepartment(String dept) throws ClassNotFoundException, SQLException {
        dept = dept.toUpperCase();
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE student_info.student_dept="
                + "'"
                + dept
                + "'";

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);
    }

    public static ArrayList<MealData> getStudentMealDataForADepartment(Calendar start, Calendar end, String dept) throws ClassNotFoundException, SQLException {
        Timestamp startTimestamp = findStartOfDayTimeStamp(start);
        Timestamp endTimestamp = findEndOfDayTimeStamp(end);
        dept = dept.toUpperCase();
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE meal_log.day_time>='"
                + startTimestamp
                + "' and meal_log.day_time<='"
                + endTimestamp
                + "'" + " and student_info.student_dept = "
                + "'"
                + dept
                + "'";

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);
    }

    public static ArrayList<MealData> getStudentMealDataForAStudent(Calendar start, Calendar end, int id) throws ClassNotFoundException, SQLException {
        Timestamp startTimestamp = findStartOfDayTimeStamp(start);
        Timestamp endTimestamp = findEndOfDayTimeStamp(end);

        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE meal_log.day_time>='"
                + startTimestamp
                + "' and meal_log.day_time<='"
                + endTimestamp
                + "'" + " and student_info.id="
                + id;

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);
    }

    public static ArrayList<MealData> getStudentMealDataForAStudent(int id) throws ClassNotFoundException, SQLException {
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE student_info.id="
                + id;

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);

    }

    public static ArrayList<MealData> getStudentMealDataForADepartmentAndSession(Calendar start, Calendar end, String dept, int session) throws ClassNotFoundException, SQLException {
        Timestamp startTimestamp = findStartOfDayTimeStamp(start);
        Timestamp endTimestamp = findEndOfDayTimeStamp(end);
        dept = dept.toUpperCase();
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE meal_log.day_time>='"
                + startTimestamp
                + "' and meal_log.day_time<='"
                + endTimestamp
                + "'" + " and student_info.student_dept = "
                + "'"
                + dept
                + "'"
                + "and student_info.student_session="
                + session;

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);
    }

    public static ArrayList<MealData> getStudentMealDataForADepartmentAndSession(String dept, int session) throws ClassNotFoundException, SQLException {

        dept = dept.toUpperCase();
        String query = "SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session, meal_log.type,meal_log.quantity,"
                + "meal_log.day_time FROM student_info INNER JOIN meal_log on meal_log.id = student_info.id "
                + "WHERE  student_info.student_dept = "
                + "'"
                + dept
                + "'"
                + "and student_info.student_session="
                + session;

        ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
        return getMealDataArrayListFromResultSet(resultSet);
    }

    public static ArrayList<MealData> getMealDataArrayListFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<MealData> mealData = new ArrayList<>();
        while (resultSet.next()) {
            Student st = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
            MealData md;
            md = new MealData(st, resultSet.getString(5), resultSet.getInt(6), resultSet.getTimestamp(7));
            mealData.add(md);

        }
        return mealData;
    }

    public static Timestamp findEndOfDayTimeStamp(Calendar calendar) {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY),
                calendar.get(Calendar.DATE), 23, 59, 59);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp findStartOfDayTimeStamp(Calendar calendar) {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY),
                calendar.get(Calendar.DATE), 0, 0, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static String theMonth(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    public static void addToBazar(int user, int ammount, String comment) {
        String query = "INSERT INTO bazar_info (user_id, amount, comment) VALUES("
                + user
                + ","
                + ammount
                + ",\""
                + comment
                + "\")";

        CreateConnection.insertDatatoDatabase(query);
    }

    public static ResultSet getCurrentSeatInformation() throws ClassNotFoundException, SQLException {
        String query = "SELECT p.id , p.student_name ,p.student_dept,p.student_session,"
                + "hall_info.floor_number,p.room_number FROM "
                + "(SELECT student_info.id,student_info.student_name,student_info.student_dept,"
                + "student_info.student_session,allocated.room_number FROM student_info INNER JOIN "
                + "allocated on allocated.id = student_info.id ) p INNER JOIN hall_info ON "
                + "p.room_number = hall_info.room_number;";
        return CreateConnection.getResultFromDatabase(query);
    }

    

}

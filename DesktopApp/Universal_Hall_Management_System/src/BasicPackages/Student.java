/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicPackages;

/**
 *
 * @author Tahmid
 */
public class Student {
     private int id;
    private String student_name;
   
    private String student_dept;
    private int student_session;

    public Student(int id, String student_name, String student_dept, int student_session) {
        this.id = id;
        this.student_name = student_name;
        this.student_dept = student_dept;
        this.student_session = student_session;
    }

   
    
    public Student(){
        
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getId() {
        return id;
    }

    public String getStudent_dept() {
        return student_dept;
    }

    public int getStudent_session() {
        return student_session;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_dept(String student_dept) {
        this.student_dept = student_dept;
    }

    public void setStudent_session(int student_session) {
        this.student_session = student_session;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", student_name=" + student_name + ", student_dept=" + student_dept + ", student_session=" + student_session + '}';
    }
    
}

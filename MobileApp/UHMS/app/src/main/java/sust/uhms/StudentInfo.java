package sust.uhms;

/**
 * Created by Siyam on 12-Mar-16.
 */
public class StudentInfo {

    String name,dept,session,gardianname,gardianrekation;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getGardianname() {
        return gardianname;
    }

    public void setGardianname(String gardianname) {
        this.gardianname = gardianname;
    }

    public String getGardianrekation() {
        return gardianrekation;
    }

    public void setGardianrekation(String gardianrekation) {
        this.gardianrekation = gardianrekation;
    }
}

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
public class MealDue {
    private int id;
    private int total;
    private String yearMonth;

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public MealDue(int id, int total, String yearMonth) {
        this.id = id;
        this.total = total;
        this.yearMonth = yearMonth;
    }
    public MealDue() {
    }

    public MealDue(int id, int total) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MealDue{" + "id=" + id + ", total=" + total + ", yearMonth=" + yearMonth + '}';
    }


    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicPackages;

import java.sql.Timestamp;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Tahmid
 */
public class MealData extends Student{
    
   private String type;
   private int quantity;
   private Timestamp  dateTime;

    public MealData(Student student, String type, int quantity, Timestamp dateTime) {
        super(student);
        this.type = type;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }
    
    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        super.toString();
        return "MealData{" + "type=" + type + ", quantity=" + quantity + ", dateTime=" + dateTime + '}';
    }
}

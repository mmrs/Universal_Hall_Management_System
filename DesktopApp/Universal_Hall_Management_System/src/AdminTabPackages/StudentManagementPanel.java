/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTabPackages;

import dbconnection.CreateConnection;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tahmid
 */
public class StudentManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentManagementPanel
     */
    public StudentManagementPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addStudentFromDatabaseButton = new javax.swing.JButton();
        addSingleStudentButton = new javax.swing.JButton();
        removeSingleStudentButton = new javax.swing.JButton();
        removeStudentCompletSeason = new javax.swing.JButton();

        addStudentFromDatabaseButton.setText("Add Students From Student Database");
        addStudentFromDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentFromDatabaseButtonActionPerformed(evt);
            }
        });

        addSingleStudentButton.setText("Add Single Student");
        addSingleStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSingleStudentButtonActionPerformed(evt);
            }
        });

        removeSingleStudentButton.setText("Remove Single Student");
        removeSingleStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSingleStudentButtonActionPerformed(evt);
            }
        });

        removeStudentCompletSeason.setText("Remove Student (Complete Season)");
        removeStudentCompletSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeStudentCompletSeasonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addStudentFromDatabaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addSingleStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeSingleStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeStudentCompletSeason, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(addStudentFromDatabaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addSingleStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeSingleStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeStudentCompletSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentFromDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentFromDatabaseButtonActionPerformed
        try {
            addStudentFromDataBase();
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentManagementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addStudentFromDatabaseButtonActionPerformed

    public void addStudentFromDataBase() throws SQLException, ClassNotFoundException{
         ResultSet result = null;
            result = CreateConnection.getResultFromDatabase("SELECT COUNT(id) as count FROM allocated");

            int numberOfRow = 0;
            System.out.println(result);

            if (result.next()) {
                numberOfRow = result.getInt("count");
            }

            System.out.println("number of row = " + numberOfRow);
            if (numberOfRow == 0) {
                  result = CreateConnection.getResultFromDatabase("SELECT student_info.id , student_info.student_name,student_info.student_dept,student_info.student_session"
                          + " FROM student_info,student_status WHERE student_info.id = student_status.id "
                          + "and student_status.status = 'current'" );
            } else if (numberOfRow > 0) {
                 result = CreateConnection.getResultFromDatabase("SELECT t.id,t.student_name,t.student_dept,t.student_session from "
                         + "( SELECT student_info.id , student_info.student_name,student_info.student_dept,student_info.student_session FROM student_info "
                         + "INNER JOIN student_status on student_info.id = student_status.id "
                         + "WHERE student_status.status='current') t LEFT JOIN "
                         + "allocated on t.id = allocated.id WHERE allocated.id is null;");
            }
            
            while(result.next()){
                System.out.println("id = "+result.getInt(1) + " name = "+result.getString(2)+" dept = "+result.getString(3));
            }
            
    }
    private void addSingleStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSingleStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSingleStudentButtonActionPerformed

    private void removeSingleStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSingleStudentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeSingleStudentButtonActionPerformed

    private void removeStudentCompletSeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeStudentCompletSeasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeStudentCompletSeasonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSingleStudentButton;
    private javax.swing.JButton addStudentFromDatabaseButton;
    private javax.swing.JButton removeSingleStudentButton;
    private javax.swing.JButton removeStudentCompletSeason;
    // End of variables declaration//GEN-END:variables
}
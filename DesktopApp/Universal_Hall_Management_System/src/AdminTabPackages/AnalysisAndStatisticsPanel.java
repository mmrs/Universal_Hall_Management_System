/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTabPackages;

import PieChartCreate.PieChart_AWT;
import QueryPackage.BasicQuery;
import dbconnection.CreateConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Siyam
 */
public class AnalysisAndStatisticsPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminOptionsPanel
     */
    public AnalysisAndStatisticsPanel() {
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

        mealStatistics = new javax.swing.JButton();
        startDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        endDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        mealStatistics.setText("Meal statistics");
        mealStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mealStatisticsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Start Date :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("End Date :");

        jButton2.setText("Check in Check out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Seat Allocation");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mealStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addComponent(mealStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mealStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mealStatisticsActionPerformed
        // TODO add your handling code here:
        
        String query = "SELECT p.student_dept,sum(p.quantity) from (SELECT student_info.student_dept, meal_log.quantity,meal_log.day_time FROM student_info JOIN "
                + "meal_log on student_info.id = meal_log.id  ";
        String c = ") p GROUP by p.student_dept";
        String a = "";
        String b = "";
          if (startDate.getCalendar() != null) {
            a += "AND day_time >= '"
                    + BasicQuery.findStartOfDayTimeStamp(startDate.getCalendar())
                    + "' ";
        }
        if (endDate.getCalendar() != null) {
            b += "AND day_time <= '"
                    + BasicQuery.findEndOfDayTimeStamp(endDate.getCalendar())
                    + "' ";
        }
        startDate.setCalendar(null);
        endDate.setCalendar(null);
        query = query +a+b+c;
        try {
            ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
            PieChart_AWT demo = new PieChart_AWT("Meal Statistics",resultSet);
        
        demo.setSize(560, 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnalysisAndStatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnalysisAndStatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mealStatisticsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
                String query = "select p.student_dept,count(p.type) from "
                        + "(select student_info.student_dept,check_in_out.id,check_in_out.type,check_in_out.day_time from check_in_out "
                        + "INNER JOIN student_info ON "
                        + "check_in_out.id =student_info.id AND check_in_out.type ='IN' ";
                
                
        String c = "  )  p group by p.student_dept";
        String a = "";
        String b = "";
          if (startDate.getCalendar() != null) {
            a += "AND day_time >= '"
                    + BasicQuery.findStartOfDayTimeStamp(startDate.getCalendar())
                    + "' ";
        }
        if (endDate.getCalendar() != null) {
            b += "AND day_time <= '"
                    + BasicQuery.findEndOfDayTimeStamp(endDate.getCalendar())
                    + "' ";
        }
        query = query +a+b+c;
        startDate.setCalendar(null);
        endDate.setCalendar(null);
        try {
            ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
            PieChart_AWT demo = new PieChart_AWT("Check IN/OUT Statistics",resultSet);
        
        demo.setSize(560, 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnalysisAndStatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnalysisAndStatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                        String query = "select p.student_dept,COUNT(p.id) FROM (select student_info.id,student_info.student_dept FROM student_info "
                                + "INNER JOIN allocated ON student_info.id = allocated.id ";
                
                
        String c = "  ) p GROUP BY p.student_dept";
        String a = "";
        String b = "";
          if (startDate.getCalendar() != null) {
            a += "AND day_time >= '"
                    + BasicQuery.findStartOfDayTimeStamp(startDate.getCalendar())
                    + "' ";
        }
        if (endDate.getCalendar() != null) {
            b += "AND day_time <= '"
                    + BasicQuery.findEndOfDayTimeStamp(endDate.getCalendar())
                    + "' ";
        }
        query = query +a+b+c;
        startDate.setCalendar(null);
        endDate.setCalendar(null);
        try {
            ResultSet resultSet = CreateConnection.getResultFromDatabase(query);
            PieChart_AWT demo = new PieChart_AWT("Seat Allocation",resultSet);
        
        demo.setSize(560, 367);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnalysisAndStatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnalysisAndStatisticsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton mealStatistics;
    private com.toedter.calendar.JDateChooser startDate;
    // End of variables declaration//GEN-END:variables
}

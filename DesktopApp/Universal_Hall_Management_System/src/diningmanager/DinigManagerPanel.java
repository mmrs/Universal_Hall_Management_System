/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diningmanager;

import allpanels.MainFrame;
import dbconnection.CreateConnection;
import gatekeeper.GateKeeperPanel;
import gatekeeper.TableModelGateKeeperViewEntry;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Siyam
 */
public class DinigManagerPanel extends javax.swing.JPanel {

    /**
     * Creates new form DinigManagerPanel
     */
    DefaultTableModel tablemodel;
    private MainFrame frame;

    public DinigManagerPanel() {
        initComponents();
        //  tablemodel = (DefaultTableModel) MultipleEntryTable.getModel();
    }

    public DinigManagerPanel(MainFrame aThis) {
        frame = aThis;
        initComponents();
        tablemodel = (DefaultTableModel) MultipleEntryTable.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        regNoTextField = new javax.swing.JTextField();
        mealTypeOptions = new javax.swing.JComboBox<>();
        mealQuantity = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        studentName2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        regNoTextFieldInMultipleStudentEntry = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MultipleEntryTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        searchEntryTextField = new javax.swing.JTextField();
        refreshButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        regNoTextField2 = new javax.swing.JTextField();
        type1 = new javax.swing.JLabel();
        type2 = new javax.swing.JLabel();
        type3 = new javax.swing.JLabel();
        quantity1 = new javax.swing.JLabel();
        quantity2 = new javax.swing.JLabel();
        quantity3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        studentName = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        jButton1.setText("LogOut");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Reg No :");

        jLabel3.setText("Meal Type");

        jLabel4.setText("Quantity");

        regNoTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regNoTextFieldActionPerformed(evt);
            }
        });

        mealTypeOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BREAKFAST", "LUNCH", "DINNER" }));
        mealTypeOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mealTypeOptionsActionPerformed(evt);
            }
        });

        mealQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mealQuantity.setValue(1);

        jButton2.setText("Add Meal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Name    :");

        studentName2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        studentName2.setText("                ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentName2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mealQuantity)
                                .addComponent(mealTypeOptions, 0, 126, Short.MAX_VALUE)
                                .addComponent(regNoTextField))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(regNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(studentName2))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mealTypeOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mealQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Single Student Entry", jPanel1);

        regNoTextFieldInMultipleStudentEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regNoTextFieldInMultipleStudentEntryActionPerformed(evt);
            }
        });

        jLabel8.setText("Search by Reg No :");

        MultipleEntryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "REGISTRATION NO", "BREAKFAST", "LUNCH", "DINNER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MultipleEntryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(MultipleEntryTable);

        jButton3.setText("Reload");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Add Meal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(regNoTextFieldInMultipleStudentEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(37, 37, 37))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNoTextFieldInMultipleStudentEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Multiple Student Entry", jPanel6);

        jLabel12.setText("Search by Reg No : ");

        searchEntryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEntryTextFieldActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        logTable.setModel(new javax.swing.table.DefaultTableModel(
        ));
        jScrollPane1.setViewportView(logTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchEntryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton)
                        .addGap(37, 37, 37))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchEntryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Log", jPanel4);

        jLabel5.setText("Reg No :");

        regNoTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        regNoTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regNoTextField2ActionPerformed(evt);
            }
        });

        type1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type1.setText("BREAKFAST  :");

        type2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type2.setText("LUNCH        :");

        type3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type3.setText("DINNER       :");

        quantity1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantity1.setText("00");

        quantity2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantity2.setText("00");

        quantity3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantity3.setText("00");

        jLabel6.setText("Name :");

        studentName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(type3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(type1)))
                                .addGap(63, 63, 63)
                                .addComponent(quantity1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentName)
                                    .addComponent(regNoTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(type2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantity3)
                                    .addComponent(quantity2)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(jSeparator2)))))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(regNoTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(studentName))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type1)
                    .addComponent(quantity1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(quantity2)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(type2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantity3)
                    .addComponent(type3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Single Student Current Month Report", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame.goLoginPanel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String regNo = regNoTextField.getText();
        String mealType = mealTypeOptions.getSelectedItem().toString();
        String mealQuantitySt = mealQuantity.getValue().toString();
        if (regNo.length() != 10 || Integer.parseInt(mealQuantitySt) < 1) {
            JOptionPane.showMessageDialog(this, "Enter All INfo Correctly!", "Check Input!", WIDTH);

        } else {
            CreateConnection.insertDatatoDatabase("INSERT INTO meal_log(id,type,quantity) values("
                    + regNo + ",'" + mealType + "'," + mealQuantitySt + ")");
            regNoTextField.setText("");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void regNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regNoTextFieldActionPerformed
        try {
            // TODO add your handling code here:
            jButton2.setEnabled(true);
            resultSet = CreateConnection.getResultFromDatabase("select student_name from student_info where id=" + regNoTextField.getText() + "");
            if (resultSet.next()) {
                studentName2.setText(resultSet.getString("student_name"));
            } else {
                studentName2.setText("Student Not Found On DataBase");
                jButton2.setEnabled(false);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DinigManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DinigManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_regNoTextFieldActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            resultSet = CreateConnection.getResultFromDatabase("select * from meal_log ORDER BY DAY_TIME DESC");
            logTable.setModel(TableModelGateKeeperViewEntry.resultSetToTableModel(resultSet));
        } catch (ClassNotFoundException ex) {
            //  Logger.getLogger(GateKeeperPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //  Logger.getLogger(GateKeeperPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_refreshButtonActionPerformed

    private void searchEntryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEntryTextFieldActionPerformed
        // TODO add your handling code here
        try {
            // TODO add your handling code here:
            resultSet = CreateConnection.getResultFromDatabase("select * from meal_log WHERE id = " + searchEntryTextField.getText() + " ORDER BY DAY_TIME DESC");
            logTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GateKeeperPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GateKeeperPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchEntryTextFieldActionPerformed

    private void regNoTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regNoTextField2ActionPerformed
        // TODO add your handling code here:
        String regNo = regNoTextField2.getText();
        if (regNo.length() != 10) {
            JOptionPane.showMessageDialog(this, "Incorrect Registration No Format", "Error!", WIDTH);
        } else {
            //calculating current,starting and ending timestampp of the month
            Calendar calendar = Calendar.getInstance();
            System.out.println(calendar);
            Timestamp current = new Timestamp(calendar.getTimeInMillis());
            //  System.out.println(current);
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 0, 0, 0);
            Timestamp start = new Timestamp(calendar.getTimeInMillis());
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.getMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
            Timestamp end = new Timestamp(calendar.getTimeInMillis());
            System.out.println(start + "\n" + current + "\n" + end);
            try {
                resultSet = CreateConnection.getResultFromDatabase("select student_name from student_info where id=" + regNo + "");
                if (resultSet.next()) {
                    studentName.setText(resultSet.getString("student_name"));
                } else {
                    studentName.setText("Student Not Found On DataBase");
                }

                resultSet = CreateConnection.getResultFromDatabase("select sum(quantity) from meal_log  where id=" + regNo + " AND day_time>= '" + start
                        + "' AND day_time<='" + end + "' AND type='BREAKFAST'");
                if (resultSet.next()) {
                    quantity1.setText(resultSet.getInt(1) + "");
                } else {
                    quantity1.setText("00");
                }

                resultSet = CreateConnection.getResultFromDatabase("select sum(quantity) from meal_log  where id=" + regNo + " AND day_time>= '" + start
                        + "' AND day_time<='" + end + "' AND type='LUNCH'");
                if (resultSet.next()) {
                    quantity2.setText(resultSet.getInt(1) + "");
                } else {
                    quantity2.setText("00");
                }

                resultSet = CreateConnection.getResultFromDatabase("select sum(quantity) from meal_log  where id=" + regNo + " AND day_time>= '" + start
                        + "' AND day_time<='" + end + "' AND type='DINNER'");
                if (resultSet.next()) {
                    quantity3.setText(resultSet.getInt(1) + "");
                } else {
                    quantity3.setText("00");
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DinigManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DinigManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_regNoTextField2ActionPerformed

    private void mealTypeOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mealTypeOptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mealTypeOptionsActionPerformed

    private void regNoTextFieldInMultipleStudentEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regNoTextFieldInMultipleStudentEntryActionPerformed
        try {
            // TODO add your handling code here:
            String regNo = regNoTextFieldInMultipleStudentEntry.getText();
             for(int i=0;i<tablemodel.getRowCount();i++){
                 
               //  System.out.println(tablemodel.getValueAt(i, 0));
                 if((tablemodel.getValueAt(i,0).toString()).equals(regNo)){
                //     System.out.println("matched");
                  //   MultipleEntryTable.setSelectionBackground(Color.MAGENTA);
                     MultipleEntryTable.clearSelection();
                     MultipleEntryTable.addRowSelectionInterval(i,i);
                     break;
                 }
            }

        } catch (Exception ex) {
            Logger.getLogger(DinigManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_regNoTextFieldInMultipleStudentEntryActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            resultSet = CreateConnection.getResultFromDatabase("select DISTINCT(id) from student_info");
            tablemodel.setRowCount(0);
            for (int i = 0; resultSet.next(); i++) {
                tablemodel.addRow(new Object[]{resultSet.getInt(1),false,false,false});
            }

        } catch (Exception ex) {
            Logger.getLogger(DinigManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            for(int i=0;i<tablemodel.getRowCount();i++){
                boolean flag;
                flag = (boolean) tablemodel.getValueAt(i,1);
                if(flag)
                    CreateConnection.insertDatatoDatabase("insert into meal_log (id,type,quantity ) values(" + tablemodel.getValueAt(i,0) + ",'" + tablemodel.getColumnName(1) + "',1)");
                flag = (boolean) tablemodel.getValueAt(i,2);
                if(flag)
                    CreateConnection.insertDatatoDatabase("insert into meal_log (id,type,quantity ) values(" + tablemodel.getValueAt(i,0) + ",'" + tablemodel.getColumnName(2) + "',1)");
                flag = (boolean) tablemodel.getValueAt(i,3);
                if(flag)
                    CreateConnection.insertDatatoDatabase("insert into meal_log (id,type,quantity ) values(" + tablemodel.getValueAt(i,0) + ",'" + tablemodel.getColumnName(3) + "',1)");
            }
            tablemodel.setRowCount(0);
        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MultipleEntryTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable logTable;
    private javax.swing.JSpinner mealQuantity;
    private javax.swing.JComboBox<String> mealTypeOptions;
    private javax.swing.JLabel quantity1;
    private javax.swing.JLabel quantity2;
    private javax.swing.JLabel quantity3;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField regNoTextField;
    private javax.swing.JTextField regNoTextField2;
    private javax.swing.JTextField regNoTextFieldInMultipleStudentEntry;
    private javax.swing.JTextField searchEntryTextField;
    private javax.swing.JLabel studentName;
    private javax.swing.JLabel studentName2;
    private javax.swing.JLabel type1;
    private javax.swing.JLabel type2;
    private javax.swing.JLabel type3;
    // End of variables declaration//GEN-END:variables

    static ResultSet resultSet;

    public void setUserInformationLabel(String string) {
        jLabel1.setText("Logged In As: " + string + " [DiningManager]");
    }

}

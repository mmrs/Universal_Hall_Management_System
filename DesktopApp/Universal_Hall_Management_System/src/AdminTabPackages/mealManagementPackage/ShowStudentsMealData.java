/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTabPackages.mealManagementPackage;

import BasicPackages.MealData;
import BasicPackages.Student;
import PdfCreation.PdfTableWriter;
import QueryPackage.BasicQuery;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracle.sql.TIMESTAMP;

/**
 *
 * @author Tahmid
 */
public class ShowStudentsMealData extends javax.swing.JFrame {

    /**
     * Creates new form ShowStudentsMealData
     */
    public ShowStudentsMealData() {
        super("Show Students Meal Data");
        initComponents();
        allDateCheckBox.setSelected(true);
         viewButtonPressed();
        toggleDateSelection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        deptTextField = new javax.swing.JTextField();
        sessionTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        viewButton = new javax.swing.JButton();
        logLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        startDate = new com.toedter.calendar.JDateChooser();
        endDate = new com.toedter.calendar.JDateChooser();
        allDateCheckBox = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        regNoTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Department :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Session :");

        deptTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        sessionTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sessionTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sessionTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sessionTextFieldKeyTyped(evt);
            }
        });

        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Department", "Session", "Meal Type", "Quantity", "Day Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(infoTable);
        if (infoTable.getColumnModel().getColumnCount() > 0) {
            infoTable.getColumnModel().getColumn(0).setResizable(false);
            infoTable.getColumnModel().getColumn(1).setResizable(false);
            infoTable.getColumnModel().getColumn(2).setResizable(false);
            infoTable.getColumnModel().getColumn(3).setResizable(false);
            infoTable.getColumnModel().getColumn(4).setResizable(false);
            infoTable.getColumnModel().getColumn(5).setResizable(false);
            infoTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Start Date :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("End  Date :");

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        logLabel.setText("log Label");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Leave Field Empty If You Want To View All Data");

        allDateCheckBox.setText("Check It To View All Date");
        allDateCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                allDateCheckBoxStateChanged(evt);
            }
        });
        allDateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allDateCheckBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Registration No :");

        regNoTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        regNoTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        regNoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                regNoTextFieldKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel7.setText("Leave this field empty to show all student data");

        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(157, 157, 157))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(regNoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(deptTextField)
                            .addComponent(sessionTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 17, Short.MAX_VALUE)
                                .addComponent(allDateCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)))
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allDateCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deptTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sessionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewButton)
                .addGap(17, 17, 17)
                .addComponent(logLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(printButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("All Student Data", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sessionTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sessionTextFieldKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (key < '0' || key > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_sessionTextFieldKeyTyped

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        viewButtonPressed();
        

    }//GEN-LAST:event_viewButtonActionPerformed

    public void viewButtonPressed() {
        String regNo = regNoTextField.getText().trim();
        try {
            // TODO add your handling code here:
            if (regNoTextField.getText().trim().isEmpty() == false) {
                Student st = BasicQuery.findStudent(regNo);
                if (st == null) {
                    JOptionPane.showMessageDialog(this, "Sorry, no student found with this registration number.");
                    deptTextField.setText("");
                    sessionTextField.setText("");
                } else {
                    deptTextField.setText(st.getStudent_dept());
                    sessionTextField.setText(st.getStudent_session() + "");
                    viewDataForAStudent(st.getId());
                }
            } else if (sessionTextField.getText().trim().isEmpty() && deptTextField.getText().trim().isEmpty()) {
                viewAllData();
            } else if (sessionTextField.getText().trim().isEmpty() == false && deptTextField.getText().trim().isEmpty()) {
                int session = Integer.parseInt(sessionTextField.getText().trim());
                viewDataWithASession(session);
            } else if (sessionTextField.getText().trim().isEmpty() && deptTextField.getText().trim().isEmpty() == false) {
                String dept = deptTextField.getText().trim();
                viewDataWithADepartment(dept);
            } else if (sessionTextField.getText().trim().isEmpty() == false && deptTextField.getText().trim().isEmpty() == false) {
                String dept = deptTextField.getText().trim();
                int session = Integer.parseInt(sessionTextField.getText().trim());
                viewDataWithADepartmentAndSession(dept, session);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowStudentsMealData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShowStudentsMealData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void allDateCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_allDateCheckBoxStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_allDateCheckBoxStateChanged

    private void allDateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allDateCheckBoxActionPerformed
        // TODO add your handling code here:
     toggleDateSelection();
    }//GEN-LAST:event_allDateCheckBoxActionPerformed
    public void toggleDateSelection(){
           if (allDateCheckBox.isSelected()) {
            startDate.setEnabled(false);
            endDate.setEnabled(false);
        } else {
            startDate.setEnabled(true);
            endDate.setEnabled(true);
        }
    }
    private void regNoTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regNoTextFieldKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (key < '0' || key > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_regNoTextFieldKeyTyped
    public String timeString() {
        if (allDateCheckBox.isSelected()) {
            return "";
        } else {
            Calendar start = startDate.getCalendar();
            return "From " + new Timestamp(startDate.getCalendar().getTimeInMillis()).toString() 
                    + " to " + new Timestamp(endDate.getCalendar().getTimeInMillis()).toString();
        }
    }
    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new PdfTableWriter("Student Meal Data", infoTable, "Student meal Data. " + timeString(), "The table was generated by uhms.");
        } catch (DocumentException ex) {
            Logger.getLogger(GenerateDueTableOfAMonth.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerateDueTableOfAMonth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    public void viewAllData() throws ClassNotFoundException, SQLException {
        if (allDateCheckBox.isSelected() == false) {
            Calendar start = startDate.getCalendar();
            Calendar end = endDate.getCalendar();
            if (start == null || end == null) {
                JOptionPane.showMessageDialog(this, "Please select start and end date.");
                return;
            }
            if (start.after(end)) {
                JOptionPane.showMessageDialog(this, "Start date should be befor the end date.");
                return;
            }
            readayTable(BasicQuery.getStudentMealData(start, end));

        } else {
            readayTable(BasicQuery.getStudentMealData());
        }
    }

    public void viewDataWithASession(int session) throws SQLException, ClassNotFoundException {
        if (allDateCheckBox.isSelected() == false) {
            Calendar start = startDate.getCalendar();
            Calendar end = endDate.getCalendar();
            if (start == null || end == null) {
                JOptionPane.showMessageDialog(this, "Please select start and end date.");
                return;
            }
            if (start.after(end)) {
                JOptionPane.showMessageDialog(this, "Start date should be befor the end date.");
                return;
            }

            readayTable(BasicQuery.getStudentMealDataForASession(start, end, session));

        } else {
            readayTable(BasicQuery.getStudentMealDataForASession(session));
        }
    }

    public void viewDataWithADepartment(String dept) throws SQLException, ClassNotFoundException {
        if (allDateCheckBox.isSelected() == false) {
            Calendar start = startDate.getCalendar();
            Calendar end = endDate.getCalendar();
            if (start == null || end == null) {
                JOptionPane.showMessageDialog(this, "Please select start and end date.");
                return;
            }
            if (start.after(end)) {
                JOptionPane.showMessageDialog(this, "Start date should be befor the end date.");
                return;
            }

            readayTable(BasicQuery.getStudentMealDataForADepartment(start, end, dept));

        } else {
            readayTable(BasicQuery.getStudentMealDataForADepartment(dept));
        }
    }

    public void viewDataWithADepartmentAndSession(String dept, int session) throws SQLException, ClassNotFoundException {
        if (allDateCheckBox.isSelected() == false) {
            Calendar start = startDate.getCalendar();
            Calendar end = endDate.getCalendar();
            if (start == null || end == null) {
                JOptionPane.showMessageDialog(this, "Please select start and end date.");
                return;
            }
            if (start.after(end)) {
                JOptionPane.showMessageDialog(this, "Start date should be befor the end date.");
                return;
            }

            readayTable(BasicQuery.getStudentMealDataForADepartmentAndSession(start, end, dept, session));

        } else {
            readayTable(BasicQuery.getStudentMealDataForADepartmentAndSession(dept, session));
        }
    }

    public void viewDataForAStudent(int id) throws SQLException, ClassNotFoundException {
        if (allDateCheckBox.isSelected() == false) {
            Calendar start = startDate.getCalendar();
            Calendar end = endDate.getCalendar();
            if (start == null || end == null) {
                JOptionPane.showMessageDialog(this, "Please select start and end date.");
                return;
            }
            if (start.after(end)) {
                JOptionPane.showMessageDialog(this, "Start date should be befor the end date.");
                return;
            }

            readayTable(BasicQuery.getStudentMealDataForAStudent(start, end, id));

        } else {
            readayTable(BasicQuery.getStudentMealDataForAStudent(id));
        }
    }

    public void readayTable(ArrayList<MealData> mealData) {
        DefaultTableModel model = (DefaultTableModel) infoTable.getModel();
        System.out.println(mealData.size() + " meal data size");
        model.setRowCount(0);

        for (MealData md : mealData) {
            model.addRow(new Object[]{md.getId(), md.getStudent_name(), md.getStudent_dept(), md.getStudent_session(), md.getType(), md.getQuantity(), md.getDateTime()});
        }
        return;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox allDateCheckBox;
    private javax.swing.JTextField deptTextField;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JTable infoTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logLabel;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField regNoTextField;
    private javax.swing.JTextField sessionTextField;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}

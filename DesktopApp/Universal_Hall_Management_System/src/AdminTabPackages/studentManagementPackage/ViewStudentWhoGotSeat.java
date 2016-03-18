/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTabPackages.studentManagementPackage;

import BasicPackages.Student;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tahmid
 */
public class ViewStudentWhoGotSeat extends javax.swing.JFrame {

    
    ArrayList<Student> studentList = null;
    
    /**
     * Creates new form ViewStudentWhoGotSeat
     */
    public ViewStudentWhoGotSeat() {
        super("Students Who Got Seat");
        initComponents();
    }
    
    public ViewStudentWhoGotSeat(ArrayList<Student> student) {
         initComponents();
        this.studentSeatInformationTable.setVisible(false);
        this.studentList = student;
        display_information();
        
    }
    
    private void display_information(){
        if(studentList.size() == 0 ) { 
            showSorryLabel();
            return;
        }
        studentSeatInformationTable.setVisible(true);
        informationLabel.setText("Total seat alocated : " + studentList.size());
        DefaultTableModel model =  (DefaultTableModel) studentSeatInformationTable.getModel();
        model.setRowCount(0);
        
        for(Student st : studentList){
            model.addRow(new Object[]{ st.getId(),st.getStudent_name(),st.getStudent_dept(),st.getStudent_session(),st.getRoom_number() });
        }
        return;
        
    }
    private void showSorryLabel(){
        informationLabel.setText("No Free Seat Available!!!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentSeatInformationTable = new javax.swing.JTable();
        informationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        studentSeatInformationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_Id", "Name", "Department", "Session", "Room Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentSeatInformationTable);
        if (studentSeatInformationTable.getColumnModel().getColumnCount() > 0) {
            studentSeatInformationTable.getColumnModel().getColumn(0).setResizable(false);
            studentSeatInformationTable.getColumnModel().getColumn(1).setResizable(false);
            studentSeatInformationTable.getColumnModel().getColumn(2).setResizable(false);
            studentSeatInformationTable.getColumnModel().getColumn(3).setResizable(false);
            studentSeatInformationTable.getColumnModel().getColumn(4).setResizable(false);
        }

        informationLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        informationLabel.setText("Seat Information : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(informationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(informationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel informationLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable studentSeatInformationTable;
    // End of variables declaration//GEN-END:variables
}

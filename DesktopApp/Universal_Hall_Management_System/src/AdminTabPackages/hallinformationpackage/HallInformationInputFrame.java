/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTabPackages.hallinformationpackage;

import dbconnection.CreateConnection;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author th160
 */
public class HallInformationInputFrame extends javax.swing.JFrame {
    
    
    CardLayout cardlayout = null;
    BasicHallInformationPanel basicHallInformationPanel = new BasicHallInformationPanel();
    RoomInformationPanel roomInformationPanel = new RoomInformationPanel();
    /**
     * Creates new form HallInformationInputFrame
     */
    public HallInformationInputFrame() {
        initComponents();
        confirmButton.setVisible(false);
        readyCardLayout();
        goBasicInformationPanel();
    }
    
    /**
     * this method create and init the card layout for this frame 
     */
    void readyCardLayout(){
        cardlayout = new CardLayout();
        panelContainer.setLayout(cardlayout);
        panelContainer.add("BasicHallInformationPanel",basicHallInformationPanel);
        panelContainer.add("RoomInformationPanel",roomInformationPanel );
    }
    
    void goBasicInformationPanel(){
        cardlayout.show(panelContainer, "BasicHallInformationPanel");
    }
    
    void goRoomInformationPanel(int floorInformation[][]){
       
        roomInformationPanel.setFloorInformation(floorInformation);
      
        if(roomInformationPanel.isFloorInformationValid()==0){
            JOptionPane.showMessageDialog(this, "Please Edit The Floor Information Table");
            return;
        }
        
        roomInformationPanel.showRoomInformationTable();
        cardlayout.show(panelContainer,"RoomInformationPanel");
        confirmButton.setVisible(true);
        backButton.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContainer = new javax.swing.JPanel();
        confirmButton = new javax.swing.JButton();
        editRoomButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        editRoomButton.setText("Edit Room Detail");
        editRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoomButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(confirmButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addComponent(editRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(editRoomButton)
                    .addComponent(backButton))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoomButtonActionPerformed
        // TODO add your handling code here:
        int floorInformation[][] = basicHallInformationPanel.getFloorInformationTable();
        if(floorInformation==null) {
            JOptionPane.showMessageDialog(this, "Please Enter Number of floor and Edit the Floor Information table");
            return;
        }
        goRoomInformationPanel(floorInformation);
    }//GEN-LAST:event_editRoomButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        goBasicInformationPanel();
        backButton.setVisible(false);
        confirmButton.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
       int flag =  JOptionPane.showConfirmDialog(this, "Are you sure about the information. Please check the information carefully.");
        if(flag==JOptionPane.YES_OPTION){
            updateHallInformation();
        }else {
            return;
        }
    }//GEN-LAST:event_confirmButtonActionPerformed
    
    private void updateHallInformation(){
        JTable roomInfo = roomInformationPanel.getRoomInformationTable();
        
        String query = "";
        int floor , roomNumber , capacity;
        for(int i = 0;i<roomInfo.getRowCount();i++){
            floor = (int)roomInfo.getValueAt(i, 0);
            roomNumber = (int)roomInfo.getValueAt(i, 1);
            capacity = (int) roomInfo.getValueAt(i, 2);
            
            query = "insert into hall_info values(" + floor +"," + roomNumber+ ","+capacity+")";
            
           // System.out.println(query);
            CreateConnection.insertDatatoDatabase(query); 
            
            query = "insert into current_rooms_info values(" + roomNumber + "," + capacity+")";
            CreateConnection.insertDatatoDatabase(query);
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton editRoomButton;
    private javax.swing.JPanel panelContainer;
    // End of variables declaration//GEN-END:variables
}

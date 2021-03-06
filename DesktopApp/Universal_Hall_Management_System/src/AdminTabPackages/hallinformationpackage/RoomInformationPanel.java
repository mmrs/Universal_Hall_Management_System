/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminTabPackages.hallinformationpackage;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author th160
 */
public class RoomInformationPanel extends javax.swing.JPanel {

    int floorInformation[][] = null;
    int totalRoom;
    int firstTime = 0;

    /**
     * Creates new form RoomInformationPanel
     */
    public RoomInformationPanel() {
        initComponents();
    }

    boolean checkFloorInformationIsUpdatedOrNot(int newInfo[][]) {
        if (floorInformation.length != newInfo.length) {
            return false;
        }

        for (int i = 1; i < floorInformation.length; i++) {
            for (int j = 1; j < floorInformation[i].length; j++) {
                if (floorInformation[i][j] != newInfo[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setFloorInformation(int floorInformation[][]) {
        if (this.floorInformation == null) {
            this.floorInformation = floorInformation;
        } else if (checkFloorInformationIsUpdatedOrNot(floorInformation) == false) {
            resetFirstTimeTableShown();
        }

        this.floorInformation = floorInformation;
    }

    public int isFloorInformationValid() {
        totalRoom = 0;
        for (int i = 1; i < floorInformation.length; i++) {
            for (int j = 1; j < floorInformation[i].length; j++) {
                totalRoom += floorInformation[i][j];
            }
        }
        return totalRoom;
    }

    private void showFirstTimeRoomInformationTable() {

        int currentRoomNumber = 1;
        DefaultTableModel model = (DefaultTableModel) roomInformationTable.getModel();
        model.setRowCount(totalRoom);
        int romCnt = 1;
        int row = 0, col = 0;
        for (int floorNumber = 1; floorNumber < floorInformation.length; floorNumber++) {
            for (int capacity = 1; capacity < floorInformation[floorNumber].length; capacity++) {
                for (int i = 0; i < floorInformation[floorNumber][capacity]; i++) {
                    model.setValueAt(floorNumber, row, 0);
                    model.setValueAt(romCnt++, row, 1);
                    model.setValueAt(4, row, 2);
                    row++;
                }
            }
        }
        firstTime = 1;
    }

    void showRoomInformationTable() {
        if (firstTime == 0) {
            showFirstTimeRoomInformationTable();
        }
    }

    public void setFirstTimeTableShown() {
        this.firstTime = 1;
    }

    public void resetFirstTimeTableShown() {
        this.firstTime = 0;
    }

    public int[][] getFloorInformation() {
        return floorInformation;
    }

    public JTable getRoomInformationTable() {
        return roomInformationTable;
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
        roomInformationTable = new javax.swing.JTable();

        roomInformationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Floor Number", "Room Number", "Capacity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(roomInformationTable);
        if (roomInformationTable.getColumnModel().getColumnCount() > 0) {
            roomInformationTable.getColumnModel().getColumn(0).setResizable(false);
            roomInformationTable.getColumnModel().getColumn(1).setResizable(false);
            roomInformationTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable roomInformationTable;
    // End of variables declaration//GEN-END:variables
}

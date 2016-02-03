/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardLayoutTestPac;

import CardLayoutTestPac.OleeTestPanel1;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author th160
 */
public class CardLayoutTestOlee extends javax.swing.JFrame {
    
    CardLayout cardlayout = null;
    
    OleeTestPanel1 panelOne = null;
    OleeTestPanel1 panelTwo = null;
    OleeTestPanel1 panelThree = null;
    
    /**
     * Creates new form CardLayoutTestOlee
     */
    public CardLayoutTestOlee() {
        initComponents();
        readyAllThreePanel();
        readyCardLayout();
    }
    
    public void readyAllThreePanel(){
        panelOne = new OleeTestPanel1();
        panelTwo = new OleeTestPanel1();
        panelThree = new OleeTestPanel1();
        panelOne.setBackground(Color.yellow);
        panelTwo.setBackground(Color.BLACK);
        panelThree.setBackground(Color.blue);
        
    }
    void readyCardLayout(){
        
        cardlayout = new CardLayout();
        panelContener.setLayout(cardlayout);
        panelContener.add("PanelOne",panelOne);
        panelContener.add("PanelTwo",panelTwo);
        panelContener.add("PanelThree",panelThree);
    }
    void goPanelOne(){
        cardlayout.show(panelContener, "PanelOne");
    }
    
    void goPanelTwo(){
        cardlayout.show(panelContener, "PanelTwo");
    }
    void goPanelThree(){
        cardlayout.show(panelContener, "PanelThree");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContener = new javax.swing.JPanel();
        PanelOneButton = new javax.swing.JButton();
        PanelTwoButton = new javax.swing.JButton();
        PanelThreeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContener.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout panelContenerLayout = new javax.swing.GroupLayout(panelContener);
        panelContener.setLayout(panelContenerLayout);
        panelContenerLayout.setHorizontalGroup(
            panelContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContenerLayout.setVerticalGroup(
            panelContenerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
        );

        PanelOneButton.setText("Panel 1");
        PanelOneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelOneButtonActionPerformed(evt);
            }
        });

        PanelTwoButton.setText("Panel 2");
        PanelTwoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelTwoButtonActionPerformed(evt);
            }
        });

        PanelThreeButton.setText("Panel 3");
        PanelThreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelThreeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(PanelOneButton)
                .addGap(43, 43, 43)
                .addComponent(PanelTwoButton)
                .addGap(38, 38, 38)
                .addComponent(PanelThreeButton)
                .addGap(174, 174, 174))
            .addComponent(panelContener, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PanelThreeButton)
                    .addComponent(PanelTwoButton)
                    .addComponent(PanelOneButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanelOneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelOneButtonActionPerformed
        goPanelOne();
    }//GEN-LAST:event_PanelOneButtonActionPerformed

    private void PanelTwoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelTwoButtonActionPerformed
      goPanelTwo();
    }//GEN-LAST:event_PanelTwoButtonActionPerformed

    private void PanelThreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelThreeButtonActionPerformed
        // TODO add your handling code here:
        goPanelThree();
    }//GEN-LAST:event_PanelThreeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CardLayoutTestOlee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardLayoutTestOlee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardLayoutTestOlee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardLayoutTestOlee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardLayoutTestOlee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PanelOneButton;
    private javax.swing.JButton PanelThreeButton;
    private javax.swing.JButton PanelTwoButton;
    private javax.swing.JPanel panelContener;
    // End of variables declaration//GEN-END:variables
}

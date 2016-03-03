/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allpanels;

import CardLayoutTestPac.CardLayoutTestOlee;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Properties;
import javax.swing.UIManager;

/**
 *
 * @author Siyam
 */
public class UniversalHallManagementSystem {

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
                /*if ("Metal".equals(info.getName())) {
                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
                 break;
                 }*/
                Properties props = new Properties();
                props.put("logoString", "my company");
                HiFiLookAndFeel.setCurrentTheme(props);
              //  UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
             //   UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
              //  UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
              //  UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
               // UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
               //   UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
               // UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
              //  UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
              UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
              //  UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
               // UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");

            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            
        }
        /* Create and display the form */
            
            MainFrame frame = new MainFrame();
            System.out.println("Hello Project Is starting");
            frame.setVisible(true);
            frame.setResizable(false);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dim.getWidth() - frame.getWidth()) / 2);
            int y = 100;
            frame.setLocation(x, y);
     
        }

    }

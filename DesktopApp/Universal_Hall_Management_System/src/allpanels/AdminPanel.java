/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allpanels;

import AdminTabPackages.AnalysisAndStatisticsPanel;
import AdminTabPackages.CheckInCheckOutPanel;
import AdminTabPackages.HallInformationPanel;
import AdminTabPackages.LastTwoMonthDuePanel;
import AdminTabPackages.MealManagementPanel;
import AdminTabPackages.StudentManagementPanel;
import AdminTabPackages.mealManagementPackage.GenerateDueTableOfAMonth;
import UserInformation.CurrentUserInfo;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Siyam
 */
public class AdminPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminPanel
     */
    MainFrame parentFrame = null;
    HallInformationPanel hallInformationPanel = new HallInformationPanel();
    StudentManagementPanel studentManagementPanel = new StudentManagementPanel();
    MealManagementPanel mealManagementPanel = new MealManagementPanel();
    CheckInCheckOutPanel checkInCheckOutPanel = new CheckInCheckOutPanel();
    CardLayout cardLayoutForHallInformationTab = new CardLayout();
    CardLayout cardLayoutForStudentManagementTab = new CardLayout();
    CardLayout cardLayoutForMealManagementTab = new CardLayout();
    CardLayout cardLayoutForCheckInCheckOutTab = new CardLayout();
    CardLayout cardLayoutForAnalysisTab = new CardLayout();
    CardLayout cardLayoutForMealDueTab = new CardLayout();
    LastTwoMonthDuePanel lastTwoMonthDuePanel = new LastTwoMonthDuePanel();
    
    AnalysisAndStatisticsPanel analysisAndStatisticsPanel = new AnalysisAndStatisticsPanel();
    

    public AdminPanel() {
        initComponents();
    }

    /**
     * this constructor is used to set the parentFrame reference so that after
     * log out it can show it's parent frome
     *
     * @param parent
     */
    public AdminPanel(MainFrame parent) {
        initComponents();
        this.parentFrame = parent;
        setHallInformationTab();
        setStudentManagementTab();
        setMealManagementTab();
        setCheckInCheckOutTab();
        setAnalysisTab();
        updateMealRateAndDues();
      //mainAdminTabPanel.remove(4);
      setMealDueTab();
        
    }
    void setMealDueTab() {
         mealDueTabContainer.setLayout(cardLayoutForMealDueTab);
        mealDueTabContainer.add("MealDuePanel", lastTwoMonthDuePanel);
        cardLayoutForMealDueTab.show(mealDueTabContainer, "MealDuePanel");
    }
    
void setAnalysisTab() {
         analysisContainer.setLayout(cardLayoutForAnalysisTab);
        analysisContainer.add("AnalysisPanel", analysisAndStatisticsPanel);
        cardLayoutForAnalysisTab.show(analysisContainer, "AnalysisPanel");
    }
    void setMealManagementTab() {
        jPanel1.setLayout(cardLayoutForMealManagementTab);
        jPanel1.add("MealManagementPanel", mealManagementPanel);
        cardLayoutForMealManagementTab.show(jPanel1, "MealManagementPanel");
    }

    void setStudentManagementTab() {
        studentManagementPanelContainer.setLayout(cardLayoutForStudentManagementTab);
        studentManagementPanelContainer.add("StudentManagementPanel", studentManagementPanel);
        cardLayoutForStudentManagementTab.show(studentManagementPanelContainer, "StudentManagementPanel");
    }
 void setCheckInCheckOutTab() {
        checkInCheckOutPanelContainer.setLayout(cardLayoutForCheckInCheckOutTab);
        checkInCheckOutPanelContainer.add("CheckInCheckOutPanel", checkInCheckOutPanel);
        cardLayoutForCheckInCheckOutTab.show(checkInCheckOutPanelContainer, "CheckInCheckOutPanel");
    }
    void setHallInformationTab() {
        hallInformationPanelContainer.setLayout(cardLayoutForHallInformationTab);
        hallInformationPanelContainer.add("HallInformationPanel", hallInformationPanel);
        cardLayoutForHallInformationTab.show(hallInformationPanelContainer, "HallInformationPanel");
    }
    public void setHallInfoPanelDisable(){
        //  mainAdminTabPanel.remove(4);
          mainAdminTabPanel.remove(hallInformationTabPanel);
          
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainAdminTabPanel = new javax.swing.JTabbedPane();
        studentManagementTabPanel = new javax.swing.JPanel();
        studentManagementPanelContainer = new javax.swing.JPanel();
        mealManagementTabPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        adminOptionsTabPanel = new javax.swing.JPanel();
        analysisContainer = new javax.swing.JPanel();
        checkInCheckOutTabPanel = new javax.swing.JPanel();
        checkInCheckOutPanelContainer = new javax.swing.JPanel();
        hallInformationTabPanel = new javax.swing.JPanel();
        hallInformationPanelContainer = new javax.swing.JPanel();
        mealDueTabPanel = new javax.swing.JPanel();
        mealDueTabContainer = new javax.swing.JPanel();
        adminInformationLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();

        javax.swing.GroupLayout studentManagementPanelContainerLayout = new javax.swing.GroupLayout(studentManagementPanelContainer);
        studentManagementPanelContainer.setLayout(studentManagementPanelContainerLayout);
        studentManagementPanelContainerLayout.setHorizontalGroup(
            studentManagementPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        studentManagementPanelContainerLayout.setVerticalGroup(
            studentManagementPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout studentManagementTabPanelLayout = new javax.swing.GroupLayout(studentManagementTabPanel);
        studentManagementTabPanel.setLayout(studentManagementTabPanelLayout);
        studentManagementTabPanelLayout.setHorizontalGroup(
            studentManagementTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentManagementPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        studentManagementTabPanelLayout.setVerticalGroup(
            studentManagementTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentManagementTabPanelLayout.createSequentialGroup()
                .addComponent(studentManagementPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );

        mainAdminTabPanel.addTab("Student Management", studentManagementTabPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mealManagementTabPanelLayout = new javax.swing.GroupLayout(mealManagementTabPanel);
        mealManagementTabPanel.setLayout(mealManagementTabPanelLayout);
        mealManagementTabPanelLayout.setHorizontalGroup(
            mealManagementTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mealManagementTabPanelLayout.setVerticalGroup(
            mealManagementTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainAdminTabPanel.addTab("Meal Management", mealManagementTabPanel);

        javax.swing.GroupLayout analysisContainerLayout = new javax.swing.GroupLayout(analysisContainer);
        analysisContainer.setLayout(analysisContainerLayout);
        analysisContainerLayout.setHorizontalGroup(
            analysisContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        analysisContainerLayout.setVerticalGroup(
            analysisContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout adminOptionsTabPanelLayout = new javax.swing.GroupLayout(adminOptionsTabPanel);
        adminOptionsTabPanel.setLayout(adminOptionsTabPanelLayout);
        adminOptionsTabPanelLayout.setHorizontalGroup(
            adminOptionsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(analysisContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adminOptionsTabPanelLayout.setVerticalGroup(
            adminOptionsTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(analysisContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainAdminTabPanel.addTab("Analysis And Statistics", adminOptionsTabPanel);

        javax.swing.GroupLayout checkInCheckOutPanelContainerLayout = new javax.swing.GroupLayout(checkInCheckOutPanelContainer);
        checkInCheckOutPanelContainer.setLayout(checkInCheckOutPanelContainerLayout);
        checkInCheckOutPanelContainerLayout.setHorizontalGroup(
            checkInCheckOutPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        checkInCheckOutPanelContainerLayout.setVerticalGroup(
            checkInCheckOutPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout checkInCheckOutTabPanelLayout = new javax.swing.GroupLayout(checkInCheckOutTabPanel);
        checkInCheckOutTabPanel.setLayout(checkInCheckOutTabPanelLayout);
        checkInCheckOutTabPanelLayout.setHorizontalGroup(
            checkInCheckOutTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(checkInCheckOutPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        checkInCheckOutTabPanelLayout.setVerticalGroup(
            checkInCheckOutTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(checkInCheckOutPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainAdminTabPanel.addTab("Check in Check out", checkInCheckOutTabPanel);

        javax.swing.GroupLayout hallInformationPanelContainerLayout = new javax.swing.GroupLayout(hallInformationPanelContainer);
        hallInformationPanelContainer.setLayout(hallInformationPanelContainerLayout);
        hallInformationPanelContainerLayout.setHorizontalGroup(
            hallInformationPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        hallInformationPanelContainerLayout.setVerticalGroup(
            hallInformationPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout hallInformationTabPanelLayout = new javax.swing.GroupLayout(hallInformationTabPanel);
        hallInformationTabPanel.setLayout(hallInformationTabPanelLayout);
        hallInformationTabPanelLayout.setHorizontalGroup(
            hallInformationTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hallInformationPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        hallInformationTabPanelLayout.setVerticalGroup(
            hallInformationTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hallInformationTabPanelLayout.createSequentialGroup()
                .addComponent(hallInformationPanelContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );

        mainAdminTabPanel.addTab("Hall Information", hallInformationTabPanel);

        javax.swing.GroupLayout mealDueTabContainerLayout = new javax.swing.GroupLayout(mealDueTabContainer);
        mealDueTabContainer.setLayout(mealDueTabContainerLayout);
        mealDueTabContainerLayout.setHorizontalGroup(
            mealDueTabContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        mealDueTabContainerLayout.setVerticalGroup(
            mealDueTabContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mealDueTabPanelLayout = new javax.swing.GroupLayout(mealDueTabPanel);
        mealDueTabPanel.setLayout(mealDueTabPanelLayout);
        mealDueTabPanelLayout.setHorizontalGroup(
            mealDueTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mealDueTabContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mealDueTabPanelLayout.setVerticalGroup(
            mealDueTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mealDueTabContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainAdminTabPanel.addTab("Meal Due Table", mealDueTabPanel);

        adminInformationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        adminInformationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminInformationLabel.setText("Admin Information Panel");

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainAdminTabPanel)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(adminInformationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminInformationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(logOutButton))
                .addGap(18, 18, 18)
                .addComponent(mainAdminTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        // TODO add your handling code here:
        parentFrame.goLoginPanel();
 
        mainAdminTabPanel.add("Hall Information", hallInformationTabPanel);
 
    }//GEN-LAST:event_logOutButtonActionPerformed

    public void setUserInformationLabel(String name) {
        adminInformationLabel.setText("Logged In As: " + name + " [Admin]");
    }
    public void updateMealRateAndDues(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GenerateDueTableOfAMonth.updateMealDues();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminInformationLabel;
    private javax.swing.JPanel adminOptionsTabPanel;
    private javax.swing.JPanel analysisContainer;
    private javax.swing.JPanel checkInCheckOutPanelContainer;
    private javax.swing.JPanel checkInCheckOutTabPanel;
    private javax.swing.JPanel hallInformationPanelContainer;
    private javax.swing.JPanel hallInformationTabPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JTabbedPane mainAdminTabPanel;
    private javax.swing.JPanel mealDueTabContainer;
    private javax.swing.JPanel mealDueTabPanel;
    private javax.swing.JPanel mealManagementTabPanel;
    private javax.swing.JPanel studentManagementPanelContainer;
    private javax.swing.JPanel studentManagementTabPanel;
    // End of variables declaration//GEN-END:variables
}

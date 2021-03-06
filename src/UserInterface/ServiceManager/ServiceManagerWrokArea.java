/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ServiceManager;

import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Lucy Bai
 */
public class ServiceManagerWrokArea extends javax.swing.JPanel {

    /**
     * Creates new form ServiceManagerWrokArea
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private ServiceOrganization serviceOrganization;
    private Enterprise enterprise;
    public ServiceManagerWrokArea(JPanel userProcessContainer, UserAccount account, ServiceOrganization serviceOrganization, Enterprise enterprise) {
        initComponents();
        this.account = account;
        this.enterprise = enterprise;
        this.serviceOrganization = (ServiceOrganization)serviceOrganization;
        this.userProcessContainer = userProcessContainer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        btnManageSchedules = new javax.swing.JButton();
        btnServicePrice = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1230, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1230, 50));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel4.setText("Service Manager Work Area");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel4)
                .addContainerGap(545, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(77, 77, 77))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 220));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        btnManageSchedules.setBackground(new java.awt.Color(106, 116, 145));
        btnManageSchedules.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnManageSchedules.setText("Manage Schedules");
        btnManageSchedules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageSchedulesActionPerformed(evt);
            }
        });

        btnServicePrice.setBackground(new java.awt.Color(106, 116, 145));
        btnServicePrice.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnServicePrice.setText("Manage Service Price");
        btnServicePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicePriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnManageSchedules, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnServicePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(517, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageSchedules, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(btnServicePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1230, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageSchedulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageSchedulesActionPerformed
        // TODO add your handling code here:
        ManageSchedules manageSchedules = new ManageSchedules(userProcessContainer, account, serviceOrganization, enterprise);
        userProcessContainer.add("manageSchedules",manageSchedules);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageSchedulesActionPerformed

    private void btnServicePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicePriceActionPerformed
        // TODO add your handling code here:
        ManageServicePrice manageServicePrice = new ManageServicePrice(userProcessContainer, account, serviceOrganization, enterprise);
        userProcessContainer.add("manageServicePrice",manageServicePrice);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnServicePriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageSchedules;
    private javax.swing.JButton btnServicePrice;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel loginPanel;
    // End of variables declaration//GEN-END:variables
}

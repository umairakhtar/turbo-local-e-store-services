/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BillingManagerRole;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Network.Network;
import EcoSystem.Organization.BillingOrganization;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Lucy Bai
 */
public class BillingManagerWorkArea extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount account;
    private BillingOrganization billingOrganization;
    private Enterprise enterprise;
     private EcoSystem system;
     private Network network;
    /**
     * Creates new form BillingManagerWorkArea
     */
    public BillingManagerWorkArea(JPanel userProcessContainer, UserAccount account, BillingOrganization billingOrganization, Enterprise enterprise, EcoSystem system) {
        initComponents();
          this.system = system;
        this.account=account;
        this.enterprise=enterprise;
        this.billingOrganization=(BillingOrganization)billingOrganization;
        this.userProcessContainer=userProcessContainer;
        this.network = whatNetwork();
    }
        public final Network whatNetwork() {
        Network n = null;
        for(Network network: system.getNetworkList()) {
            for( Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList() ) {
                if( enterprise == this.enterprise ) {
                    n = network;
                    break;
                }
            }
        }
        return n;
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
        btnManageBilingProcess = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("Billing Manager Work Area");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(423, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(379, 379, 379))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel4)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 220));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        btnManageBilingProcess.setBackground(new java.awt.Color(106, 116, 145));
        btnManageBilingProcess.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnManageBilingProcess.setForeground(new java.awt.Color(255, 255, 255));
        btnManageBilingProcess.setText("Manage Billing Process");
        btnManageBilingProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageBilingProcessActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(106, 116, 145));
        jButton3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Confirm Payment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageBilingProcess)
                .addContainerGap(356, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageBilingProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1230, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageBilingProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageBilingProcessActionPerformed
        // TODO add your handling code here:
        ManageBillingProcess manageBillingProcess = new ManageBillingProcess(userProcessContainer, network, enterprise, billingOrganization);
        userProcessContainer.add("manageBillingProcess", manageBillingProcess);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageBilingProcessActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ConfirmPayment confirm = new ConfirmPayment(userProcessContainer, network, enterprise, billingOrganization);
        userProcessContainer.add("orderProduct", confirm);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageBilingProcess;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel loginPanel;
    // End of variables declaration//GEN-END:variables
}

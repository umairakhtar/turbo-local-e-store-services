/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Network.Network;
import EcoSystem.Employee.Employee.SkillType;
import EcoSystem.Organization.CustomerOrganization;
import EcoSystem.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Lucy Bai
 */
public class RequestService extends javax.swing.JPanel {

    /**
     * Creates new form RequestService
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem system;
    private Enterprise enterprise;
    private Network network;
    private CustomerOrganization customerOrganization;
    RequestService(JPanel userProcessContainer, UserAccount account, EcoSystem system, Enterprise enterprise, CustomerOrganization customerOrganization) {
        initComponents();
        this.account = account;
        this.system = system;
        this.enterprise = enterprise;
        this.userProcessContainer=userProcessContainer;
        this.network = whatNetwork();
        this.customerOrganization = customerOrganization;
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
        btnBack = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        btnHandyMan = new javax.swing.JButton();
        btnPlumbing = new javax.swing.JButton();
        btnCleaning = new javax.swing.JButton();
        btnElectrical = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(545, 545, 545)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(575, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1230, 50));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Request Service");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1)
                .addContainerGap(648, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 220));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        btnHandyMan.setBackground(new java.awt.Color(106, 116, 145));
        btnHandyMan.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnHandyMan.setText("HandyMan");
        btnHandyMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHandyManActionPerformed(evt);
            }
        });

        btnPlumbing.setBackground(new java.awt.Color(106, 116, 145));
        btnPlumbing.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnPlumbing.setText("Plumbing");
        btnPlumbing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlumbingActionPerformed(evt);
            }
        });

        btnCleaning.setBackground(new java.awt.Color(106, 116, 145));
        btnCleaning.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnCleaning.setText("Cleaning");
        btnCleaning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleaningActionPerformed(evt);
            }
        });

        btnElectrical.setBackground(new java.awt.Color(106, 116, 145));
        btnElectrical.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        btnElectrical.setText("Electrical");
        btnElectrical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElectricalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(btnPlumbing, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHandyMan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(btnCleaning, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnElectrical, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(581, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlumbing, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHandyMan, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCleaning, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElectrical, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1230, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlumbingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlumbingActionPerformed
        // TODO add your handling code here:
        OrderService orderService = new OrderService(userProcessContainer, account, network, enterprise, SkillType.Plumbing.getValue(), customerOrganization);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(orderService);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPlumbingActionPerformed

    private void btnCleaningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleaningActionPerformed
        // TODO add your handling code here:
        OrderService orderService = new OrderService(userProcessContainer, account, network, enterprise, SkillType.Cleaning.getValue(), customerOrganization);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(orderService);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCleaningActionPerformed

    private void btnHandyManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHandyManActionPerformed
        // TODO add your handling code here:
        OrderService orderService = new OrderService(userProcessContainer, account, network, enterprise, SkillType.Handyman.getValue(), customerOrganization);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(orderService);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnHandyManActionPerformed

    private void btnElectricalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElectricalActionPerformed
        // TODO add your handling code here:
        OrderService orderService = new OrderService(userProcessContainer, account, network, enterprise, SkillType.Electrical.getValue(), customerOrganization);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add(orderService);
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnElectricalActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCleaning;
    private javax.swing.JButton btnElectrical;
    private javax.swing.JButton btnHandyMan;
    private javax.swing.JButton btnPlumbing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel loginPanel;
    // End of variables declaration//GEN-END:variables
}

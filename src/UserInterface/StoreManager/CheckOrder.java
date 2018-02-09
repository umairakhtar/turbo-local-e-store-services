/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.StoreManager;

import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Network.Network;
import EcoSystem.Order.Order;
import EcoSystem.Order.OrderItem;
import EcoSystem.Organization.CustomerOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.StoreOrganization;
import EcoSystem.UserAccount.UserAccount;
import EcoSystem.WorkQueue.OrderPlaceWorkRequest;
import EcoSystem.WorkQueue.ProductBillingWorkRequest;
import EcoSystem.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucy Bai
 */
public class CheckOrder extends javax.swing.JPanel {

    /**
     * Creates new form CheckOrder
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private StoreOrganization storeOrganization;
    private Enterprise enterprise;
    private Network network;

    public CheckOrder(JPanel userProcessContainer, UserAccount account, StoreOrganization storeOrganization, Enterprise enterprise, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.storeOrganization = storeOrganization;
        this.enterprise = enterprise;
        this.network = network;
        populatePendingTable();
        radioPending.setSelected(true);
        btnDelivery.setVisible(false);
    }

    public void populatePendingTable() {
        DefaultTableModel model = (DefaultTableModel) tblOrder.getModel();
        model.setRowCount(0);
        for (WorkRequest wk : storeOrganization.getWorkQueue().getWorkRequestList()) {
            if (wk instanceof OrderPlaceWorkRequest) //get all orderItem
            {
                if (((OrderPlaceWorkRequest) wk).getOrderItem() != null) {
                    if (((OrderPlaceWorkRequest) wk).getOrderItem().getStoreOrganization().getOrgName().equals(storeOrganization.getOrgName())) {
                        if (((OrderPlaceWorkRequest) wk).getStatus().equals("Pending")) {
                            Object[] row = new Object[7];
                            row[0] = ((OrderPlaceWorkRequest) wk).getOrder();
                            row[1] = ((OrderPlaceWorkRequest) wk).getOrderItem();
                            row[2] = ((OrderPlaceWorkRequest) wk).getOrderItem().getQuantity();
                            row[3] = wk;
                            row[4] = ((OrderPlaceWorkRequest) wk).getOrder().isDelivery();
                            row[6] = ((OrderPlaceWorkRequest) wk).getStatus();
                            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                if (organization instanceof CustomerOrganization) {
                                    for (UserAccount userAccount : ((CustomerOrganization) organization).getUserAccountDirectory().getUserAccountList()) {
                                        for (WorkRequest wkk : userAccount.getWorkQueue().getWorkRequestList()) {
                                            if (wkk instanceof ProductBillingWorkRequest) {
                                                if (((ProductBillingWorkRequest) wkk).getSender() == userAccount) {
                                                    row[5] = wkk.getStatus();
                                                }
                                            }
                                        }
                                    }
                                }
                                
                            }
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }

    public void populateConfirmedTable() {

        DefaultTableModel model = (DefaultTableModel) tblOrder.getModel();
        model.setRowCount(0);
        for (WorkRequest wk : storeOrganization.getWorkQueue().getWorkRequestList()) {
            if (wk instanceof OrderPlaceWorkRequest) //get all orderItem
            {
                OrderItem oi = ((OrderPlaceWorkRequest) wk).getOrderItem();
                if (((OrderPlaceWorkRequest) wk).getOrderItem() != null) {
                    if (((OrderPlaceWorkRequest) wk).getStatus().equals("Confirmed")) {
                        Object[] row = new Object[7];
                        row[0] = ((OrderPlaceWorkRequest) wk).getOrder();
                        row[1] = oi;
                        row[2] = oi.getQuantity();
                        row[3] = wk;
                        row[4] = ((OrderPlaceWorkRequest) wk).getOrder().isDelivery();
                        row[6] = ((OrderPlaceWorkRequest) wk).getStatus();
                    
                        
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                      
                                if (organization instanceof CustomerOrganization) {
                                    for (UserAccount userAccount : ((CustomerOrganization) organization).getUserAccountDirectory().getUserAccountList()) {
                                        for (WorkRequest wkk : userAccount.getWorkQueue().getWorkRequestList()) {
                                            if (wkk instanceof ProductBillingWorkRequest) {
                                              
                                            
                                                if (((ProductBillingWorkRequest) wkk).getSender() == userAccount) {
                                                  
                                                        row[5] = wkk.getStatus();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                model.addRow(row);
                            }
                       
                        }
                    }
                }

            }

            /**
             * This method is called from within the constructor to initialize
             * the form. WARNING: Do NOT modify this code. The content of this
             * method is always regenerated by the Form Editor.
             */
            @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        radioConfirmed = new javax.swing.JRadioButton();
        radioPending = new javax.swing.JRadioButton();
        loginPanel = new javax.swing.JPanel();
        JScrollPane = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        btnDelivery = new javax.swing.JButton();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(710, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(431, 431, 431))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btnBack)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1230, 50));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel6.setText("Check Order");

        buttonGroup1.add(radioConfirmed);
        radioConfirmed.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        radioConfirmed.setText("Confirmed");
        radioConfirmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioConfirmedActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioPending);
        radioPending.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        radioPending.setText("Pending");
        radioPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPendingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(radioConfirmed)
                        .addGap(78, 78, 78)
                        .addComponent(radioPending)))
                .addContainerGap(663, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioConfirmed)
                    .addComponent(radioPending))
                .addGap(60, 60, 60))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 220));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        tblOrder.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "OrderId", "Product", "Quatity", "UserID", "Delivery", "Payment", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JScrollPane.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
            tblOrder.getColumnModel().getColumn(2).setResizable(false);
            tblOrder.getColumnModel().getColumn(3).setResizable(false);
            tblOrder.getColumnModel().getColumn(4).setResizable(false);
            tblOrder.getColumnModel().getColumn(5).setResizable(false);
            tblOrder.getColumnModel().getColumn(6).setResizable(false);
        }

        btnConfirm.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnDelivery.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnDelivery.setText("Choose to delivery");
        btnDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnDelivery)))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelivery)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1230, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOrder.getSelectedRow();
        if (selectedRow >= 0) {
            Boolean con = (Boolean) tblOrder.getValueAt(selectedRow, 4);
            if (!con) {
                JOptionPane.showMessageDialog(null, "No need for delivery!");
            } else {
                OrderItem or = (OrderItem) tblOrder.getValueAt(selectedRow, 1);
                Order order = (Order) tblOrder.getValueAt(selectedRow, 0);
                ChooseDelivery cd = new ChooseDelivery(userProcessContainer, enterprise, or, network, account, order);

                userProcessContainer.add("EnsureDelivery", cd);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeliveryActionPerformed

    private void radioPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPendingActionPerformed
        // TODO add your handling code here:
        populatePendingTable();
        btnDelivery.setVisible(false);
        btnConfirm.setVisible(true);
    }//GEN-LAST:event_radioPendingActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOrder.getSelectedRow();
        if (selectedRow >= 0) {
            String con = (String) tblOrder.getValueAt(selectedRow, 5);
            if (con.equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Payment is not confirmed");
            } else {
                OrderPlaceWorkRequest op = (OrderPlaceWorkRequest) tblOrder.getValueAt(selectedRow, 3);
                op.setStatus("Confirmed");
                populatePendingTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void radioConfirmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioConfirmedActionPerformed
        // TODO add your handling code here:
        populateConfirmedTable();
        btnDelivery.setVisible(true);
        btnConfirm.setVisible(false);
    }//GEN-LAST:event_radioConfirmedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDelivery;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JRadioButton radioConfirmed;
    private javax.swing.JRadioButton radioPending;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}

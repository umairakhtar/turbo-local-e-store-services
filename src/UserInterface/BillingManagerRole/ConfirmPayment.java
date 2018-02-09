/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BillingManagerRole;

import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Network.Network;
import EcoSystem.Order.Order;
import EcoSystem.Organization.BillingOrganization;
import EcoSystem.Organization.CustomerOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.Service.Service;
import EcoSystem.UserAccount.UserAccount;
import EcoSystem.WorkQueue.ProductBillingWorkRequest;
import EcoSystem.WorkQueue.ServiceBillingWorkRequest;
import EcoSystem.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucy Bai
 */
public class ConfirmPayment extends javax.swing.JPanel {

    /**
     * Creates new form ConfirmPayment
     */
   private JPanel userProcessContainer;
   private Enterprise enterprise;
   private Network network;
   private BillingOrganization billingOrganization;
     private ServiceOrganization serviceOrganization;
    public ConfirmPayment(JPanel userProcessContainer, Network network, Enterprise enterprise, BillingOrganization billingOrganization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.network = network;
        this.billingOrganization = billingOrganization;
        this.serviceOrganization=serviceOrg();
        populateOrganization();
        populateTable();
    }
    
    public void populateOrganization() {
        
        cmbOrganization.removeAllItems();
        cmbOrganization.addItem(Organization.Type.Store);
        cmbOrganization.addItem(Organization.Type.Service);
        
    }
    public final ServiceOrganization serviceOrg() {
        ServiceOrganization org = null;
        for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (ent instanceof MarketplaceEnterprise) {
                for (Organization or : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (or instanceof ServiceOrganization) {
                        org = (ServiceOrganization) or;
                    }
                }
            }
        }
        return org;
    }
    
    public void populateTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblBilling.getModel();
        model.setRowCount(0);
        
        for( Enterprise e : network.getEnterpriseDirectory().getEnterpriseList() ) {
            if( e instanceof MarketplaceEnterprise ) {
                for(Organization organization: e.getOrganizationDirectory().getOrganizationList()) {
                    if( organization instanceof CustomerOrganization ) {
//                        JOptionPane.showMessageDialog(null, organization);
//                        JOptionPane.showMessageDialog(null, ((CustomerOrganization) organization).getUserAccountDirectory().getUserAccountList().size());
                        for(UserAccount userAccount: ((CustomerOrganization) organization).getUserAccountDirectory().getUserAccountList()) {
                            if( cmbOrganization.getSelectedItem() == Organization.Type.Store ) {
                                for(WorkRequest wk: userAccount.getWorkQueue().getWorkRequestList()) {
//                                    JOptionPane.showMessageDialog(null, wk);
                                    if(wk instanceof ProductBillingWorkRequest){
                                      //  if(wk.getStatus().equals("Processing")) {
//                                            JOptionPane.showMessageDialog(null, ((CustomerOrganization) organization).getOrderList().getOrders().size());
                                            for(Order o: ((CustomerOrganization) organization).getOrderList().getOrders()){
                                                if(((ProductBillingWorkRequest) wk).getOrder()==o){
                                                    Object[] row = new Object[4];
                                                    row[0]=wk;
                                                    row[1]=o.getDate();
                                                    row[2]=((ProductBillingWorkRequest) wk).getStatus();
                                                    row[3]=((ProductBillingWorkRequest) wk).getPayment();
                                                    model.addRow(row);
                                                }
                                            }
                                      //  }// if status processing
                                    }// if instance productbiilingworkrequest
                                }//for wk
                            }//if store
                            if( cmbOrganization.getSelectedItem() == Organization.Type.Service) {
                                for(WorkRequest wk: userAccount.getWorkQueue().getWorkRequestList()) {
                                    if(wk instanceof ServiceBillingWorkRequest){
                                            for(Service s: ((CustomerOrganization) organization).getServiceList().getServices()){
                                                if(((ServiceBillingWorkRequest) wk).getService()==s){
                                                    Object[] row = new Object[4];
                                                    row[0]=wk;
                                                    row[1]=s.getDate();
                                                    row[2]=((ServiceBillingWorkRequest) wk).getStatus();
                                                    row[3]=((ServiceBillingWorkRequest) wk).getPayment();
                                                    model.addRow(row);
                                                }
                                            }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        for(WorkRequest wk: enterprise.getWorkQueue().getWorkRequestList()) {
//            JOptionPane.showMessageDialog(null, wk);
//            if(wk instanceof ProductBillingWorkRequest){
//                 for(Order o: enterprise.getOrderList().getOrders()){
//                       JOptionPane.showMessageDialog(null,"Insider oder "+ (((OrderItemPlaceWorkRequest) wk).getOrder() == o) );
//                    if(((ProductBillingWorkRequest) wk).getOrder()==o){
//                      Object[] row = new Object[3];
//                         row[0]=o;
//                         row[1]=o.getDate();
//                         row[2]=((ProductBillingWorkRequest) wk).getStatus();
//                         model.addRow(row);
//                    }
//                }
//            }
//        }

        
    }
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cmbOrganization = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBilling = new javax.swing.JTable();
        btnUpdatePayment = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

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
                .addContainerGap(720, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1230, 50));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        cmbOrganization.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cmbOrganization.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOrganizationItemStateChanged(evt);
            }
        });
        cmbOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel6.setText("Confirm Payment");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(595, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 220));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        tblBilling.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tblBilling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderId", "RequestDate", "BillingStatus", "Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBilling);
        if (tblBilling.getColumnModel().getColumnCount() > 0) {
            tblBilling.getColumnModel().getColumn(0).setResizable(false);
            tblBilling.getColumnModel().getColumn(1).setResizable(false);
            tblBilling.getColumnModel().getColumn(2).setResizable(false);
            tblBilling.getColumnModel().getColumn(3).setResizable(false);
        }

        btnUpdatePayment.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnUpdatePayment.setText("Update Payment");
        btnUpdatePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(btnUpdatePayment)))
                .addContainerGap(400, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdatePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1230, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();

        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_cmbOrganizationActionPerformed

    private void btnUpdatePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePaymentActionPerformed
        int selectedRow = tblBilling.getSelectedRow();
        if( selectedRow >= 0 ) {
                if(cmbOrganization.getSelectedItem()== Organization.Type.Store){
                    String con =(String)tblBilling.getValueAt(selectedRow, 2);
                    if(con.equals("Confirmed")){
                     JOptionPane.showMessageDialog(null, "This order has been updated!");
                    }
                    else{
                    ProductBillingWorkRequest pbwk = (ProductBillingWorkRequest)tblBilling.getValueAt(selectedRow, 0);
                    Order order = pbwk.getOrder();
                    ManageStoreBillingProcess manageStoreBillingProcess = new ManageStoreBillingProcess(userProcessContainer, network, enterprise, billingOrganization, order, pbwk);
                    userProcessContainer.add("manageStoreBillingProcess", manageStoreBillingProcess);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);}
                }
                else if(cmbOrganization.getSelectedItem()== Organization.Type.Service){
                    String con =(String)tblBilling.getValueAt(selectedRow, 2);
                    if(con.equals("Confirmed")){
                     JOptionPane.showMessageDialog(null, "This order has been updated!");
                    }
                    else{
                    ServiceBillingWorkRequest sbwk = (ServiceBillingWorkRequest)tblBilling.getValueAt(selectedRow, 0);
                    Service service = sbwk.getService();
                    ManageServiceBillingProcess manageServiceBillingProcess = new ManageServiceBillingProcess(userProcessContainer, network, enterprise, billingOrganization, service, sbwk);
                    userProcessContainer.add("manageServiceBillingProcess", manageServiceBillingProcess);
                    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                    layout.next(userProcessContainer);}
                }
        }
        else{
             JOptionPane.showMessageDialog(null, "Please select a row!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnUpdatePaymentActionPerformed

    private void cmbOrganizationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOrganizationItemStateChanged
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_cmbOrganizationItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdatePayment;
    private javax.swing.JComboBox cmbOrganization;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTable tblBilling;
    // End of variables declaration//GEN-END:variables
}

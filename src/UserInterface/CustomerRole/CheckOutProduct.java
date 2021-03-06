/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustomerRole;

import EcoSystem.EcoSystem;
import EcoSystem.Enterprise.Billing_ShipmentEnterprise;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Network.Network;
import EcoSystem.Order.Order;
import EcoSystem.Order.OrderItem;
import EcoSystem.Organization.BillingOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.StoreOrganization;
import EcoSystem.UserAccount.UserAccount;
import EcoSystem.WorkQueue.OrderPlaceWorkRequest;
import EcoSystem.WorkQueue.ProductBillingWorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucy Bai
 */
public final class CheckOutProduct extends javax.swing.JPanel {
    
    /**
     * Creates new form CheckOutProduct
     */
 
    private JPanel userProcessContainer;
    private UserAccount account;
    private Order or;
    private Enterprise enterprise;
    private EcoSystem system;
    private Network network;
    
    public  CheckOutProduct(JPanel userProcessContainer, UserAccount account, Order or, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.or=or;
        this.system=system;
        this.enterprise=enterprise;
        this.network = whatNetwork();
        populateTable();
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
     
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblOrder.getModel();
        dtm.setRowCount(0);
        for(OrderItem oi: or.getOrderItemList()) {
            Object row[] = new Object[5];
            row[0] = oi;
            row[1] = oi.getStoreOrganization().getStoreType();
            row[2] = oi.getSalesPrice();
            row[3] = oi.getQuantity();
            row[4] = oi.getStoreOrganization();  
            dtm.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        radioPick = new javax.swing.JRadioButton();
        radioDelivery = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnCheckOut = new javax.swing.JButton();

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
                .addContainerGap(759, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(319, 319, 319))
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

        buttonGroup1.add(radioPick);
        radioPick.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        radioPick.setText("Pick Up");

        buttonGroup1.add(radioDelivery);
        radioDelivery.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        radioDelivery.setText("Delivery");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Choose your way to get products: ");

        txtAddress.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Address:");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Check Out");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(radioDelivery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioPick))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel2))))
                .addContainerGap(612, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioDelivery)
                    .addComponent(radioPick))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 220));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        tblOrder.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductName", "Type", "Price", "Quantity", "Store"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblOrder);

        btnCheckOut.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnCheckOut.setText("Check Out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCheckOut)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1230, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:
        String es=txtAddress.getText();
        if(es==""|| (!(radioDelivery.isSelected())&&!(radioPick.isSelected()))){
             JOptionPane.showMessageDialog(null, "Please fullfilled the info!");
        }
        else{
        int dialogButton=JOptionPane.YES_NO_OPTION;
        int dialogResult=JOptionPane.showConfirmDialog(null,"Would you like to check out?","Warning",dialogButton);
        if(dialogResult==JOptionPane.YES_OPTION){
              
            if(radioDelivery.isSelected()){
                or.setDelivery(true);
            } 
            else if(radioPick.isSelected()){
                or.setDelivery(false);
            }
            
            Date date =new Date();
            or.setDate(date);
            or.setAddress(txtAddress.getText());
            // or.setPaid(true);
            ProductBillingWorkRequest pb = new ProductBillingWorkRequest();
            pb.setOrder(or);
            pb.setSender(account);
            pb.setRequestDate(date);
            pb.setStatus("Processing");
            
            Organization org = null;
            for(Enterprise e: network.getEnterpriseDirectory().getEnterpriseList()) {
                if(e instanceof Billing_ShipmentEnterprise) {
                    for(Organization o: e.getOrganizationDirectory().getOrganizationList()) {
                        if( o instanceof BillingOrganization) {
                            org = o;
                            break;
                        }
                    }
                }
            }
            if( org != null ) {
                account.getWorkQueue().getWorkRequestList().add(pb);
                org.getWorkQueue().getWorkRequestList().add(pb);
                for(Organization o: enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if(o instanceof StoreOrganization) {
                        for(OrderItem oi: or.getOrderItemList()) {
                            if(oi.getStoreOrganization() == o) {
                                OrderPlaceWorkRequest opwr = new OrderPlaceWorkRequest();
                                
                                opwr.setOrder(or);
                                opwr.setOrderItem(oi);
                                opwr.setOrderId(or.getOrderId());
                                opwr.setSender(account);
                                opwr.setRequestDate(date);
                                opwr.setStatus("Pending");
                                o.getWorkQueue().getWorkRequestList().add(opwr);
                                account.getWorkQueue().getWorkRequestList().add(opwr);
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Order Placed!!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Sorry for the inconvenience \n We are setting up the Billing", "Our Fault! Bad Programmars!", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JRadioButton radioDelivery;
    private javax.swing.JRadioButton radioPick;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtAddress;
    // End of variables declaration//GEN-END:variables
}

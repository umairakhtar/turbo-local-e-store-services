/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminRole;

import EcoSystem.Enterprise.Billing_ShipmentEnterprise;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Organization.BillingOrganization;
import EcoSystem.Organization.DeliveryOrganization;
import EcoSystem.Organization.DeliveryOrganization.DeliveryType;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.Organization.Type;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.Organization.StoreOrganization;
import EcoSystem.Organization.StoreOrganization.StoreType;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abhinnankit
 */
public class ManageOrganization extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganization
     */
    private Enterprise enterprise;
    private JPanel userProcessContainer;
    public ManageOrganization(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        populateCombo();
    }
    
    private void populateCombo() {
        
        comboOrganizationType.removeAllItems();
        cmbStoreType.removeAllItems();
        if( enterprise instanceof MarketplaceEnterprise ){
            comboOrganizationType.addItem(Organization.Type.Store);
            comboOrganizationType.addItem(Organization.Type.Service);
            for( StoreType type: StoreType.values()) {
                cmbStoreType.addItem(type);
            }
        }
        else if( enterprise instanceof Billing_ShipmentEnterprise) {
            comboOrganizationType.addItem(Organization.Type.Billing);
            comboOrganizationType.addItem(Organization.Type.Delivery);
                for( DeliveryType type: DeliveryType.values()) {
                cmbDeliveryType.addItem(type);
            }
        }
        
    }
    
    private void storeFieldsVisibility(boolean state) {
        lblDelivery.setVisible(state);
        lblStoreName.setVisible(state);
        lblName.setVisible(state);
        txtName.setVisible(state);
        cmbStoreType.setVisible(state);
        cmbDeliveryType.setVisible(state);
        lblName.revalidate();
        lblStoreName.revalidate();
        cmbStoreType.revalidate();
        txtName.revalidate();
        cmbDeliveryType.revalidate();
          lblDelivery.setVisible(state);
    }
    private void cmbStoreVisibility(boolean state){
        lblStoreName.setVisible(state);
        cmbStoreType.setVisible(state);
        cmbStoreType.revalidate();
         lblStoreName.revalidate();
    }
        private void cmbDeliveryVisibility(boolean state){
        lblDelivery.setVisible(state);
        cmbDeliveryType.setVisible(state);
        cmbDeliveryType.revalidate();
        lblDelivery.setVisible(state);
       
    }
    
    private void populateTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblStoreOrg.getModel();
        model.setRowCount(0);
        Type type = (Type) comboOrganizationType.getSelectedItem();
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            Object[] row = new Object[2];
            if( organization instanceof StoreOrganization && type == Type.Store) {
                row[0] = organization.getOrganizationID();
                row[1] = organization;
                model.addRow(row);
            }
            else if( organization instanceof ServiceOrganization && type == Type.Service) {
                row[0] = organization.getOrganizationID();
                row[1] = organization;
                model.addRow(row);
            }
            else if( organization instanceof BillingOrganization && type == Type.Billing) {
                row[0] = organization.getOrganizationID();
                row[1] = organization;
                model.addRow(row);
            }
            else if( organization instanceof DeliveryOrganization && type == Type.Delivery) {
                row[0] = organization.getOrganizationID();
                row[1] = organization;
                model.addRow(row);
            }
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

        jPanel6 = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboOrganizationType = new javax.swing.JComboBox();
        loginPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStoreOrg = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        cmbStoreType = new javax.swing.JComboBox();
        txtName = new javax.swing.JTextField();
        lblDelivery = new javax.swing.JLabel();
        lblStoreName = new javax.swing.JLabel();
        cmbDeliveryType = new javax.swing.JComboBox();
        addJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        backJButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(670, Short.MAX_VALUE)
                .addComponent(backJButton)
                .addGap(471, 471, 471))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backJButton)
                .addContainerGap())
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1230, 50));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setText("Manage Organization");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Organization Type ");

        comboOrganizationType.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        comboOrganizationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrganizationTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(525, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboOrganizationType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 220));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        tblStoreOrg.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tblStoreOrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblStoreOrg);

        lblName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblName.setText("Name");

        cmbStoreType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStoreTypeActionPerformed(evt);
            }
        });

        lblDelivery.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblDelivery.setForeground(new java.awt.Color(255, 255, 255));
        lblDelivery.setText("Delivery Type");

        lblStoreName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblStoreName.setForeground(new java.awt.Color(255, 255, 255));
        lblStoreName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblStoreName.setText("Store Type ");

        cmbDeliveryType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDeliveryTypeActionPerformed(evt);
            }
        });

        addJButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStoreName)
                            .addComponent(lblName)
                            .addComponent(lblDelivery))
                        .addGap(34, 34, 34)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbStoreType, 0, 160, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(cmbDeliveryType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(addJButton)))
                .addGap(470, 470, 470))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStoreType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStoreName))
                .addGap(10, 10, 10)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelivery)
                    .addComponent(cmbDeliveryType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addJButton)
                .addContainerGap())
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1230, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        Type type = (Type) comboOrganizationType.getSelectedItem();
        if(type == Type.Service) {
            if(!((MarketplaceEnterprise)enterprise).isServiceOrgPresent()) {
                enterprise.getOrganizationDirectory().createOrganization(type, (StoreType)cmbStoreType.getSelectedItem(), Type.Service.getValue(),(DeliveryType)cmbDeliveryType.getSelectedItem(),Type.Delivery.getValue());
                ((MarketplaceEnterprise)enterprise).setServiceOrgPresent(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Service Organization already Present!!", "We have don't add more organization", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(type == Type.Billing) {
            if(!((Billing_ShipmentEnterprise)enterprise).isBillingOrgPresent()) {
                enterprise.getOrganizationDirectory().createOrganization(type, (StoreType)cmbStoreType.getSelectedItem(), Type.Billing.getValue(),(DeliveryType)cmbDeliveryType.getSelectedItem(),Type.Delivery.getValue());
                ((Billing_ShipmentEnterprise)enterprise).setBillingOrgPresent(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Billing Organization already Present!!", "We don't have to add more organizations", JOptionPane.ERROR_MESSAGE);
            }
        }
   
        else if(type == Type.Delivery) {
            enterprise.getOrganizationDirectory().createOrganization(type, (StoreType)cmbStoreType.getSelectedItem(), txtName.getText(),(DeliveryType)cmbDeliveryType.getSelectedItem(),txtName.getText());
        }
        else{
              enterprise.getOrganizationDirectory().createOrganization(type, (StoreType)cmbStoreType.getSelectedItem(), txtName.getText(),(DeliveryType)cmbDeliveryType.getSelectedItem(),txtName.getText());
        }
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void comboOrganizationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrganizationTypeActionPerformed
        // TODO add your handling code here:
        Type type = (Type) comboOrganizationType.getSelectedItem();
        if( type == Type.Service || type == Type.Billing/* || type == Type.Delivery */) {
            storeFieldsVisibility(false);
        }
        
        else if (type == Type.Store ) {
            storeFieldsVisibility(true);
            cmbDeliveryVisibility(false);
        }
        else if(type == Type.Delivery){
            storeFieldsVisibility(true);
            cmbStoreVisibility(false);
        }
        populateTable();
    }//GEN-LAST:event_comboOrganizationTypeActionPerformed

    private void cmbStoreTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStoreTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStoreTypeActionPerformed

    private void cmbDeliveryTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDeliveryTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDeliveryTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox cmbDeliveryType;
    private javax.swing.JComboBox cmbStoreType;
    private javax.swing.JComboBox comboOrganizationType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDelivery;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStoreName;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTable tblStoreOrg;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

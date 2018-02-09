/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ServiceManager;

import EcoSystem.Employee.Employee;
import EcoSystem.Employee.Employee.SkillType;
import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.UserAccount.UserAccount;
import EcoSystem.WorkQueue.ServiceAvailabilityWorkRequest;
import EcoSystem.WorkQueue.ServicePlaceWorkRequest;
import EcoSystem.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Lucy Bai
 */
public class ManageSchedules extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private ServiceOrganization serviceOrganization;
    private Enterprise enterprise;

    /**
     * Creates new form ManageSchedules
     */
    public ManageSchedules(JPanel userProcessContainer, UserAccount account, ServiceOrganization serviceOrganization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.serviceOrganization = serviceOrganization;
        this.enterprise = enterprise;
       
        groupButton();
        radioUnassigned.setSelected(true);
        populateTable();
        populateRequestComboBox();
    }

    private void populateEmployeeCmb() {
        comboEmployee.removeAllItems();
        for (UserAccount userAccount : serviceOrganization.getUserAccountDirectory().getUserAccountList()) {
            if (cmbRequest.getSelectedItem() instanceof String) {
                if (userAccount.getSkillType() != null) {
                    comboEmployee.addItem(userAccount.getEmployee());
                }
            } else if (userAccount.getSkillType() == (SkillType) cmbRequest.getSelectedItem()) {
                comboEmployee.addItem(userAccount.getEmployee());
            }
        }
    }

    private void groupButton() {
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(radioAssigned);
        bg1.add(radioUnassigned);
    }

    TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
        SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");

        public Component getTableCellRendererComponent(JTable tblSchedules,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (value instanceof Date) {
                value = f.format(value);
            }
            return super.getTableCellRendererComponent(tblSchedules, value, isSelected,
                    hasFocus, row, column);
        }
    };
    TableCellRenderer tableCellRenderert = new DefaultTableCellRenderer() {
        SimpleDateFormat f = new SimpleDateFormat("hh:mm a");

        public Component getTableCellRendererComponent(JTable tblSchedules,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (value instanceof Date) {
                value = f.format(value);
            }
            return super.getTableCellRendererComponent(tblSchedules, value, isSelected,
                    hasFocus, row, column);
        }
    };

    public void populateTable() {
        //System.out.print("sfs");
        DefaultTableModel model = (DefaultTableModel) tblSchedules.getModel();
        model.setRowCount(0);
        //JOptionPane.showMessageDialog(null, serviceOrganization.getWorkQueue().getWorkRequestList().size());
        for (WorkRequest request : serviceOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof ServicePlaceWorkRequest) {
                if (radioAssigned.isSelected()) {
                    if (cmbRequest.getSelectedItem() instanceof String && !(request.getReceiver() == null)) {
                        Object[] row = new Object[7];
                        row[0] = request;
                        row[1] = ((ServicePlaceWorkRequest) request).getService().getServiceType();
                        row[2] = ((ServicePlaceWorkRequest) request).getService().getHours();
                        row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                        row[4] = ((ServicePlaceWorkRequest) request).getService().getServiceDate();
                        row[5] = ((ServicePlaceWorkRequest) request).getService().getServiceTime();
                        row[6] = request.getStatus();
                        model.addRow(row);
                    } else if (cmbRequest.getSelectedItem() instanceof SkillType) {
                        if (((ServicePlaceWorkRequest) request).getService().getServiceType() == (SkillType) cmbRequest.getSelectedItem() && !(request.getReceiver() == null)) {
                            Object[] row = new Object[7];
                            row[0] = request;
                            row[1] = ((ServicePlaceWorkRequest) request).getService().getServiceType();
                            row[2] = ((ServicePlaceWorkRequest) request).getService().getHours();
                            row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                            row[4] = ((ServicePlaceWorkRequest) request).getService().getServiceDate();
                            row[5] = ((ServicePlaceWorkRequest) request).getService().getServiceTime();
                            row[6] = request.getStatus();
                            model.addRow(row);
                        }
                    }

                }
                if (radioUnassigned.isSelected() && request.getReceiver() == null) {
                    if (cmbRequest.getSelectedItem() instanceof String) {
                        Object[] row = new Object[7];
                        row[0] = request;
                        row[1] = ((ServicePlaceWorkRequest) request).getService().getServiceType();
                        row[2] = ((ServicePlaceWorkRequest) request).getService().getHours();
                        row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                        row[4] = ((ServicePlaceWorkRequest) request).getService().getServiceDate();
                        row[5] = ((ServicePlaceWorkRequest) request).getService().getServiceTime();
                        row[6] = request.getStatus();
                        model.addRow(row);
                    } else if (cmbRequest.getSelectedItem() instanceof SkillType) {
                        if (((ServicePlaceWorkRequest) request).getService().getServiceType() == (SkillType) cmbRequest.getSelectedItem()) {
                            Object[] row = new Object[7];
                            row[0] = request;
                            row[1] = ((ServicePlaceWorkRequest) request).getService().getServiceType();
                            row[2] = ((ServicePlaceWorkRequest) request).getService().getHours();
                            row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                            row[4] = ((ServicePlaceWorkRequest) request).getService().getServiceDate();
                            row[5] = ((ServicePlaceWorkRequest) request).getService().getServiceTime();
                            row[6] = request.getStatus();
                            model.addRow(row);
                        }
                    }

//                        row[0] = request;
//                        row[1] = request.getSender();
//                        Double hour = ((ServiceAvailabilityWorkRequest) request).getHour();
//                        row[2] = hour == null ? "Waiting" : hour;
//                        row[3] = request.getStatus();            
//                        row[4] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
//                        Double payment = ((ServiceAvailabilityWorkRequest) request).getPayment();
//                        row[5] = payment == null ? "Waiting" : payment;
                }

            }
        }
        tblSchedules.getColumnModel().getColumn(4).setCellRenderer(tableCellRenderer);
        tblSchedules.getColumnModel().getColumn(5).setCellRenderer(tableCellRenderert);
    }

    public void populateRequestComboBox() {
        cmbRequest.removeAllItems();
        cmbRequest.addItem("All");
        for (SkillType skillType : SkillType.values()) {
            cmbRequest.addItem(skillType);
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
        backjButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        radioAssigned = new javax.swing.JRadioButton();
        radioUnassigned = new javax.swing.JRadioButton();
        cmbRequest = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        btnAssign = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSchedules = new javax.swing.JTable();
        comboEmployee = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        backjButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(672, Short.MAX_VALUE)
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backjButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1230, 50));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setText("Manage Schedules");

        radioAssigned.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        radioAssigned.setText("Assigned");
        radioAssigned.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioAssignedItemStateChanged(evt);
            }
        });

        radioUnassigned.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        radioUnassigned.setText("Unassigned");
        radioUnassigned.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioUnassignedItemStateChanged(evt);
            }
        });
        radioUnassigned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioUnassignedActionPerformed(evt);
            }
        });

        cmbRequest.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRequestActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Check Request For:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(cmbRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(radioAssigned)
                                .addGap(76, 76, 76)
                                .addComponent(radioUnassigned)))))
                .addContainerGap(636, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioAssigned)
                    .addComponent(radioUnassigned))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(cmbRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 220));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        btnAssign.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        tblSchedules.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblSchedules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer", "Type", "Hour", "Assigned to", "Date", "Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSchedules);
        if (tblSchedules.getColumnModel().getColumnCount() > 0) {
            tblSchedules.getColumnModel().getColumn(0).setResizable(false);
            tblSchedules.getColumnModel().getColumn(1).setResizable(false);
            tblSchedules.getColumnModel().getColumn(2).setResizable(false);
        }

        comboEmployee.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employees:");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(comboEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1230, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        int selectedRow = tblSchedules.getSelectedRow();
        if (selectedRow >= 0) {

            ServicePlaceWorkRequest request = (ServicePlaceWorkRequest) tblSchedules.getValueAt(selectedRow, 0);
            Employee employee = (Employee) comboEmployee.getSelectedItem();

            for (UserAccount ua : serviceOrganization.getUserAccountDirectory().getUserAccountList()) {
                if (ua.getEmployee().equals(employee)) {
                    request.setReceiver(ua);
                }
            }
            request.setEmployee(employee);
            request.setStatus("Assigned");
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void cmbRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRequestActionPerformed
        // TODO add your handling code here:
        populateEmployeeCmb();
        populateTable();

    }//GEN-LAST:event_cmbRequestActionPerformed

    private void radioUnassignedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioUnassignedItemStateChanged
        populateTable();
    }//GEN-LAST:event_radioUnassignedItemStateChanged

    private void radioAssignedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioAssignedItemStateChanged
        populateTable();
    }//GEN-LAST:event_radioAssignedItemStateChanged

    private void radioUnassignedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioUnassignedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioUnassignedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton btnAssign;
    private javax.swing.JComboBox cmbRequest;
    private javax.swing.JComboBox comboEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JRadioButton radioAssigned;
    private javax.swing.JRadioButton radioUnassigned;
    private javax.swing.JTable tblSchedules;
    // End of variables declaration//GEN-END:variables
}

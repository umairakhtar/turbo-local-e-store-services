/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BillingManagerRole;

import EcoSystem.Enterprise.Enterprise;
import EcoSystem.Enterprise.MarketplaceEnterprise;
import EcoSystem.Network.Network;
import EcoSystem.Organization.BillingOrganization;
import EcoSystem.Organization.Organization;
import EcoSystem.Organization.ServiceOrganization;
import EcoSystem.Service.Service;
import EcoSystem.ServicePrice.ServicePrice;
import EcoSystem.WorkQueue.ServiceBillingWorkRequest;
import EcoSystem.WorkQueue.ServicePlaceWorkRequest;
import EcoSystem.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author UmairAkhtar
 */
public class ManageServiceBillingProcess extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Network network;
    private BillingOrganization billingOrganization;
    private Enterprise enterprise;
    private Service service;
    private ServiceBillingWorkRequest sbwk;
    private ServiceOrganization serviceOrganization;
    double firstnum;
    double secondnum;
    double result;
    static double h = 0, plu = 0, han = 0, cle = 0, ele = 0;
    String answer;
    String operations;
//    double Plumbing = 45.0;
//    double HandyMan = 5.5;
//    double Cleaning = 25.75;
//    double Electrical = 50.0;
    // double Equipment = 6.6;
    double iTax = 7.5;

    /**
     * Creates new form ManageBillingProcessJPanel
     */
    ManageServiceBillingProcess(JPanel userProcessContainer, Network network, Enterprise enterprise, BillingOrganization billingOrganization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.network = network;
        this.billingOrganization = billingOrganization;
        this.enterprise = enterprise;
        disabletextfields();
    }

    ManageServiceBillingProcess(JPanel userProcessContainer, Network network, Enterprise enterprise, BillingOrganization billingOrganization, Service service, ServiceBillingWorkRequest sbwk) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.network = network;
        this.billingOrganization = billingOrganization;
        this.enterprise = enterprise;
        this.service = service;
        this.sbwk = sbwk;
        this.serviceOrganization = serviceOrg();
        disabletextfields();
        updateServiceParameters();
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

    void disabletextfields() {
        txtHours.setEnabled(false);
        txtPlumbing.setEnabled(false);
        txtHandyman.setEnabled(false);
        txtCleaning.setEnabled(false);
        txtElectrical.setEnabled(false);
        h = plu + han + cle + ele;
        txtHours.setText(String.format("%.2f", h));
    }

    void updateServiceParameters() {
        int hours = service.getHours();
        //   txtEquipments.setText(String.valueOf(Equipment));
        if (service.getServiceType().getValue().equals("Plumbing")) {
            checkPlumbing.setSelected(true);
            txtPlumbing.setText(String.valueOf(hours));

            for (ServicePrice ser : serviceOrganization.getServicePrices().getServicePrices()) {
                if (ser.getType().equals("Plumbing")) {
               
                    for (WorkRequest wk : serviceOrganization.getWorkQueue().getWorkRequestList()) {
                        if (wk instanceof ServicePlaceWorkRequest) {
                            if (((ServicePlaceWorkRequest) wk).getService() == service) {
                                if ((((ServicePlaceWorkRequest) wk).getEquipmentQty()) <= 0) {
                                    txtEquipments.setText(String.valueOf(ser.getEquipmentPrice()));
                                } else {
                                    txtEquipments.setText(String.valueOf(ser.getEquipmentPrice() * (((ServicePlaceWorkRequest) wk).getEquipmentQty())));
                                }
                            }
                        }
                    }
                }
            }
        }
        if (service.getServiceType().getValue().equals("Handyman")) {
            checkHandyman.setSelected(true);
            txtHandyman.setText(String.valueOf(hours));

            for (ServicePrice ser : serviceOrganization.getServicePrices().getServicePrices()) {
                if (ser.getType().equals("Handyman")) {
                    for (WorkRequest wk : serviceOrganization.getWorkQueue().getWorkRequestList()) {
                        if (wk instanceof ServicePlaceWorkRequest) {
                            if (((ServicePlaceWorkRequest) wk).getService() == service) {
                                if ((((ServicePlaceWorkRequest) wk).getEquipmentQty()) <= 0) {
                                    txtEquipments.setText(String.valueOf(ser.getEquipmentPrice()));
                                } else {
                                    txtEquipments.setText(String.valueOf(ser.getEquipmentPrice() * (((ServicePlaceWorkRequest) wk).getEquipmentQty())));
                                }
                            }
                        }
                    }
                }
            }

        }
        if (service.getServiceType().getValue().equals("Cleaning")) {
            checkCleaning.setSelected(true);
            txtCleaning.setText(String.valueOf(hours));

            for (ServicePrice ser : serviceOrganization.getServicePrices().getServicePrices()) {
                if (ser.getType().equals("Cleaning")) {
                    for (WorkRequest wk : serviceOrganization.getWorkQueue().getWorkRequestList()) {
                        if (wk instanceof ServicePlaceWorkRequest) {
                            if (((ServicePlaceWorkRequest) wk).getService() == service) {
                                if ((((ServicePlaceWorkRequest) wk).getEquipmentQty()) <= 0) {
                                    txtEquipments.setText(String.valueOf(ser.getEquipmentPrice()));
                                } else {
                                    txtEquipments.setText(String.valueOf(ser.getEquipmentPrice() * (((ServicePlaceWorkRequest) wk).getEquipmentQty())));
                                }
                            }
                        }
                    }
                }
            }

        }
        if (service.getServiceType().getValue().equals("Electrical")) {
            checkElectrical.setSelected(true);
            txtElectrical.setText(String.valueOf(hours));

            for (ServicePrice ser : serviceOrganization.getServicePrices().getServicePrices()) {
                if (ser.getType().equals("Electrical")) {
                    for (WorkRequest wk : serviceOrganization.getWorkQueue().getWorkRequestList()) {
                        if (wk instanceof ServicePlaceWorkRequest) {
                            if (((ServicePlaceWorkRequest) wk).getService() == service) {
                                if ((((ServicePlaceWorkRequest) wk).getEquipmentQty()) <= 0) {
                                    txtEquipments.setText(String.valueOf(ser.getEquipmentPrice()));
                                } else {
                                    txtEquipments.setText(String.valueOf(ser.getEquipmentPrice() * (((ServicePlaceWorkRequest) wk).getEquipmentQty())));
                                }
                            }
                        }
                    }
                }
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

        lblTitle = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        CalculatorjPanel = new javax.swing.JPanel();
        txtCalculator = new javax.swing.JTextField();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnDivide = new javax.swing.JButton();
        btnMultiply = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btnMinus = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        btnDecimal = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnEqual = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        checkPlumbing = new javax.swing.JCheckBox();
        checkHandyman = new javax.swing.JCheckBox();
        checkCleaning = new javax.swing.JCheckBox();
        txtPlumbing = new javax.swing.JTextField();
        checkElectrical = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        lblTotalItems = new javax.swing.JLabel();
        txtTotalCostLabour = new javax.swing.JTextField();
        lblTotalDelivery = new javax.swing.JLabel();
        lblTotalMileage = new javax.swing.JLabel();
        checkTax = new javax.swing.JCheckBox();
        checkVAT = new javax.swing.JCheckBox();
        txtCostDelivery = new javax.swing.JTextField();
        txtTotalCostEquipment = new javax.swing.JTextField();
        txtTax1 = new javax.swing.JTextField();
        txtVAT = new javax.swing.JTextField();
        txtHandyman = new javax.swing.JTextField();
        txtCleaning = new javax.swing.JTextField();
        txtElectrical = new javax.swing.JTextField();
        txtHours = new javax.swing.JTextField();
        txtEquipments = new javax.swing.JTextField();
        lblTotalItems1 = new javax.swing.JLabel();
        lblTotalItems2 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblSubTotal = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtTax2 = new javax.swing.JTextField();
        lblTax = new javax.swing.JLabel();
        btnCalculate = new javax.swing.JButton();
        txtAmount = new javax.swing.JTextField();
        lblTotalAmount = new javax.swing.JLabel();
        btnProceed = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        lblTitle.setText("Manage Service Billing Process");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 11, -1, -1));

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
                .addContainerGap(856, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1230, 50));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        CalculatorjPanel.setBackground(new java.awt.Color(255, 255, 255));
        CalculatorjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtCalculator.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        btn7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn7.setText("7");
        btn7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn8.setText("8");
        btn8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn9.setText("9");
        btn9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btnDivide.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnDivide.setText("/");
        btnDivide.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivideActionPerformed(evt);
            }
        });

        btnMultiply.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnMultiply.setText("x");
        btnMultiply.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplyActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn6.setText("6");
        btn6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn5.setText("5");
        btn5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn4.setText("4");
        btn4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btnMinus.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnMinus.setText("-");
        btnMinus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn3.setText("3");
        btn3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn2.setText("2");
        btn2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn1.setText("1");
        btn1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btnPlus.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnPlus.setText("+");
        btnPlus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        btnDecimal.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnDecimal.setText(".");
        btnDecimal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDecimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecimalActionPerformed(evt);
            }
        });

        btn0.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn0.setText("0");
        btn0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnC.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnC.setText("C");
        btnC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        btnEqual.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnEqual.setText("=");
        btnEqual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CalculatorjPanelLayout = new javax.swing.GroupLayout(CalculatorjPanel);
        CalculatorjPanel.setLayout(CalculatorjPanelLayout);
        CalculatorjPanelLayout.setHorizontalGroup(
            CalculatorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalculatorjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalculatorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CalculatorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(CalculatorjPanelLayout.createSequentialGroup()
                            .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(CalculatorjPanelLayout.createSequentialGroup()
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(CalculatorjPanelLayout.createSequentialGroup()
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(CalculatorjPanelLayout.createSequentialGroup()
                            .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnEqual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CalculatorjPanelLayout.setVerticalGroup(
            CalculatorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalculatorjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CalculatorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDivide, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CalculatorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CalculatorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CalculatorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEqual, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        checkPlumbing.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        checkPlumbing.setText("Plumbing");
        checkPlumbing.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkPlumbingItemStateChanged(evt);
            }
        });

        checkHandyman.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        checkHandyman.setText("HandyMan");
        checkHandyman.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkHandymanItemStateChanged(evt);
            }
        });

        checkCleaning.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        checkCleaning.setText("Cleaning");
        checkCleaning.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkCleaningItemStateChanged(evt);
            }
        });

        txtPlumbing.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtPlumbing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPlumbingKeyReleased(evt);
            }
        });

        checkElectrical.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        checkElectrical.setText("Electrical");
        checkElectrical.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkElectricalItemStateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTotalItems.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTotalItems.setText("Total Cost of Labour");

        txtTotalCostLabour.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtTotalCostLabour.setEnabled(false);
        txtTotalCostLabour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCostLabourActionPerformed(evt);
            }
        });

        lblTotalDelivery.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTotalDelivery.setText("Total Cost of Delivery");

        lblTotalMileage.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTotalMileage.setText("Total Cost of Equipment");

        checkTax.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        checkTax.setText("Tax");

        checkVAT.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        checkVAT.setText("VAT");

        txtCostDelivery.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtCostDelivery.setEnabled(false);

        txtTotalCostEquipment.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtTotalCostEquipment.setEnabled(false);

        txtTax1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtTax1.setEnabled(false);

        txtVAT.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtVAT.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblTotalMileage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTotalCostEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalDelivery)
                                    .addComponent(lblTotalItems))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotalCostLabour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCostDelivery, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(checkVAT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(checkTax)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTax1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalItems)
                    .addComponent(txtTotalCostLabour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalDelivery)
                    .addComponent(txtCostDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalMileage)
                    .addComponent(txtTotalCostEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkTax)
                    .addComponent(txtTax1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkVAT)
                    .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        txtHandyman.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtHandyman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHandymanKeyReleased(evt);
            }
        });

        txtCleaning.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtCleaning.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCleaningKeyReleased(evt);
            }
        });

        txtElectrical.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtElectrical.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtElectricalKeyReleased(evt);
            }
        });

        txtHours.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        txtEquipments.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        lblTotalItems1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTotalItems1.setText("Total Hours");

        lblTotalItems2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTotalItems2.setText("Equipments");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTotalItems1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTotalItems2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEquipments, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkPlumbing)
                            .addComponent(checkHandyman)
                            .addComponent(checkCleaning)
                            .addComponent(checkElectrical))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPlumbing, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHandyman, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCleaning, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtElectrical, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEquipments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalItems2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalItems1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkPlumbing)
                            .addComponent(txtPlumbing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkHandyman)
                            .addComponent(txtHandyman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkCleaning)
                            .addComponent(txtCleaning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkElectrical)
                            .addComponent(txtElectrical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(CalculatorjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(CalculatorjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 1230, 380));

        loginPanel.setBackground(new java.awt.Color(32, 47, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblSubTotal.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblSubTotal.setText("Sub Total");

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        btnClear.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        txtTax2.setEditable(false);
        txtTax2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        lblTax.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTax.setText("Tax");

        btnCalculate.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        txtAmount.setEditable(false);
        txtAmount.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        lblTotalAmount.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblTotalAmount.setText("Total Amount");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubTotal)
                    .addComponent(lblTax)
                    .addComponent(lblTotalAmount))
                .addGap(157, 157, 157)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTax2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubTotal)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTax)
                    .addComponent(txtTax2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalAmount)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalculate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnProceed.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 1230, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        String entervalue = txtCalculator.getText() + btn1.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        String entervalue = txtCalculator.getText() + btn2.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        String entervalue = txtCalculator.getText() + btn3.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        String entervalue = txtCalculator.getText() + btn4.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        String entervalue = txtCalculator.getText() + btn5.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        String entervalue = txtCalculator.getText() + btn6.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        String entervalue = txtCalculator.getText() + btn7.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        String entervalue = txtCalculator.getText() + btn8.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        String entervalue = txtCalculator.getText() + btn9.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        String entervalue = txtCalculator.getText() + btn0.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnDecimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecimalActionPerformed
        String entervalue = txtCalculator.getText() + btnDecimal.getText();
        txtCalculator.setText(entervalue);
    }//GEN-LAST:event_btnDecimalActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        txtCalculator.setText("");
    }//GEN-LAST:event_btnCActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        firstnum = Double.parseDouble(txtCalculator.getText());
        txtCalculator.setText("");
        operations = "+";
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        firstnum = Double.parseDouble(txtCalculator.getText());
        txtCalculator.setText("");
        operations = "-";
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnMultiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplyActionPerformed
        firstnum = Double.parseDouble(txtCalculator.getText());
        txtCalculator.setText("");
        operations = "*";
    }//GEN-LAST:event_btnMultiplyActionPerformed

    private void btnDivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivideActionPerformed
        firstnum = Double.parseDouble(txtCalculator.getText());
        txtCalculator.setText("");
        operations = "/";
    }//GEN-LAST:event_btnDivideActionPerformed

    private void btnEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEqualActionPerformed
        secondnum = Double.parseDouble(txtCalculator.getText());
        if (operations == "+") {
            result = firstnum + secondnum;
            answer = String.format("%.2f", result);
            txtCalculator.setText(answer);
        } else if (operations == "-") {
            result = firstnum - secondnum;
            answer = String.format("%.2f", result);
            txtCalculator.setText(answer);
        } else if (operations == "*") {
            result = firstnum * secondnum;
            answer = String.format("%.2f", result);
            txtCalculator.setText(answer);
        } else if (operations == "/") {
            result = firstnum / secondnum;
            answer = String.format("%.2f", result);
            txtCalculator.setText(answer);
        }
    }//GEN-LAST:event_btnEqualActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtAmount.setText("");
        txtCleaning.setText("");
        txtCostDelivery.setText("");
        txtElectrical.setText("");
        txtHandyman.setText("");
        txtPlumbing.setText("");
        txtSubTotal.setText("");
        txtTax1.setText("");
        txtTax2.setText("");
        txtTotalCostLabour.setText("");
        txtTotalCostEquipment.setText("");
        txtVAT.setText("");
        txtHours.setText("");
        txtEquipments.setText("");
        h = 0;
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
       if(txtEquipments.getText().trim().isEmpty())
       {
            JOptionPane.showMessageDialog(null, "Sorry you need to contanct serviceManager to update their price!");
       }
       else{
        try {
            double e = 0, l = 0, d = 4.5, r = 0;
            double x, s, total;

            if (!(checkPlumbing.isSelected()) && !(checkHandyman.isSelected()) && !(checkCleaning.isSelected()) && !(checkElectrical.isSelected())) {
                txtAmount.setText("");
                txtCleaning.setText("");
                txtCostDelivery.setText("");
                txtElectrical.setText("");
                txtHandyman.setText("");
                txtPlumbing.setText("");
                txtSubTotal.setText("");
                txtTax1.setText("");
                txtTax2.setText("");
                txtTotalCostLabour.setText("");
                txtTotalCostEquipment.setText("");
                txtVAT.setText("");
                txtEquipments.setText("");
                txtHours.setText("");
                txtCalculator.setText("Make a Selection Now!");
            }
            if (checkPlumbing.isSelected()) {
                Double pl = Double.parseDouble(txtPlumbing.getText());
                for (ServicePrice sp : serviceOrganization.getServicePrices().getServicePrices()) {
                    if (sp.getType().equals("Plumbing")) {
                        Double Plumbing = sp.getPrice();
                        l = l + Plumbing * pl;
                        String labour = String.format("%.2f", l);
                        txtTotalCostLabour.setText(labour);
                        h = h + pl;
                    }
                }

            }
            if (checkHandyman.isSelected()) {
                Double ha = Double.parseDouble(txtHandyman.getText());
                for (ServicePrice sp : serviceOrganization.getServicePrices().getServicePrices()) {
                    if (sp.getType().equals("HandyMan")) {
                        Double HandyMan = sp.getPrice();
                        l = l + HandyMan * ha;
                        String labour = String.format("%.2f", l);
                        txtTotalCostLabour.setText(labour);
                        h = h + ha;
                    }
                }
            }
            if (checkCleaning.isSelected()) {
                Double cl = Double.parseDouble(txtCleaning.getText());
                for (ServicePrice sp : serviceOrganization.getServicePrices().getServicePrices()) {
                    if (sp.getType().equals("Cleaning")) {
                        Double Cleaning = sp.getPrice();
                        l = l + Cleaning * cl;
                        String labour = String.format("%.2f", l);
                        txtTotalCostLabour.setText(labour);
                        h = h + cl;
                    }
                }
            }
            if (checkElectrical.isSelected()) {
                Double el = Double.parseDouble(txtElectrical.getText());
                for (ServicePrice sp : serviceOrganization.getServicePrices().getServicePrices()) {
                    if (sp.getType().equals("Electrical")) {
                        Double Electrical = sp.getPrice();
                        l = l + Electrical * el;
                        String labour = String.format("%.2f", l);
                        txtTotalCostLabour.setText(labour);
                        h = h + el;
                    }
                }
            }
            if ((checkTax.isSelected()) || (checkVAT.isSelected())) {
                e = e + Double.parseDouble(txtEquipments.getText());
                String equipment = String.format("%.2f", e);
                txtTotalCostEquipment.setText(equipment);
                String delivery = String.format("%.2f", d);
                txtCostDelivery.setText(delivery);
                s = l + e + d;
                txtSubTotal.setText(String.format("%.2f", s));
                //double tax = Double.parseDouble(txtTax1.getText());
                x = ((l * iTax) / 100);
                total = (s + x);
                String VATTax = String.format("%.2f", x);
                String TotalCost = String.format("%.2f", total);
                txtTax1.setText(VATTax);
                txtTax2.setText(VATTax);
                txtVAT.setText(VATTax);
                txtAmount.setText(TotalCost);
                txtHours.setText(String.format("%.2f", h));
            } else {
                e = e + Double.parseDouble(txtEquipments.getText());
                String equipment = String.format("%.2f", e);
                txtTotalCostEquipment.setText(equipment);
                String delivery = String.format("%.2f", d);
                txtCostDelivery.setText(delivery);
                s = l + e + d;
                txtSubTotal.setText(String.format("%.2f", s));
                txtTax1.setText("0");
                txtTax2.setText("0");
                txtVAT.setText("0");
                txtAmount.setText(String.format("%.2f", s));
            }

        } catch (NumberFormatException e) {
            txtCalculator.setText("Enter a Number Now!");
        }}
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtAmount.setText("");
        txtCleaning.setText("");
        txtCostDelivery.setText("");
        txtElectrical.setText("");
        txtHandyman.setText("");
        txtPlumbing.setText("");
        txtSubTotal.setText("");
        txtTax1.setText("");
        txtTax2.setText("");
        txtTotalCostLabour.setText("");
        txtTotalCostEquipment.setText("");
        txtVAT.setText("");
        txtHours.setText("");
        txtEquipments.setText("");
        checkPlumbing.setSelected(false);
        checkHandyman.setSelected(false);
        checkCleaning.setSelected(false);
        checkElectrical.setSelected(false);
        checkTax.setSelected(false);
        checkVAT.setSelected(false);
        h = 0;
    }//GEN-LAST:event_btnResetActionPerformed

    private void checkPlumbingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkPlumbingItemStateChanged
        if (checkPlumbing.isSelected()) {
            txtPlumbing.setEnabled(true);
        } else {
            txtPlumbing.setEnabled(false);
            txtPlumbing.setText("");
            plu = 0;
            h = plu + han + cle + ele;
            txtHours.setText(String.format("%.2f", h));
        }
    }//GEN-LAST:event_checkPlumbingItemStateChanged

    private void checkHandymanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkHandymanItemStateChanged
        if (checkHandyman.isSelected()) {
            txtHandyman.setEnabled(true);
        } else {
            txtHandyman.setEnabled(false);
            txtHandyman.setText("");
            han = 0;
            h = plu + han + cle + ele;
            txtHours.setText(String.format("%.2f", h));
        }
    }//GEN-LAST:event_checkHandymanItemStateChanged

    private void checkCleaningItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkCleaningItemStateChanged
        if (checkCleaning.isSelected()) {
            txtCleaning.setEnabled(true);
        } else {
            txtCleaning.setEnabled(false);
            txtCleaning.setText("");
            cle = 0;
            h = plu + han + cle + ele;
            txtHours.setText(String.format("%.2f", h));
        }
    }//GEN-LAST:event_checkCleaningItemStateChanged

    private void checkElectricalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkElectricalItemStateChanged
        if (checkElectrical.isSelected()) {
            txtElectrical.setEnabled(true);
        } else {
            txtElectrical.setEnabled(false);
            txtElectrical.setText("");
            ele = 0;
            h = plu + han + cle + ele;
            txtHours.setText(String.format("%.2f", h));
        }
    }//GEN-LAST:event_checkElectricalItemStateChanged

    private void txtPlumbingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlumbingKeyReleased
        try {
            plu = Double.parseDouble(txtPlumbing.getText());
        } catch (NumberFormatException e) {
            txtCalculator.setText("Enter a Number Now!");
        }
        h = plu + han + cle + ele;
        txtHours.setText(String.format("%.2f", h));
    }//GEN-LAST:event_txtPlumbingKeyReleased

    private void txtHandymanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHandymanKeyReleased
        try {
            han = Double.parseDouble(txtHandyman.getText());
        } catch (NumberFormatException e) {
            txtCalculator.setText("Enter a Number Now!");
        }
        h = plu + han + cle + ele;
        txtHours.setText(String.format("%.2f", h));
    }//GEN-LAST:event_txtHandymanKeyReleased

    private void txtCleaningKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCleaningKeyReleased
        try {
            cle = Double.parseDouble(txtCleaning.getText());
        } catch (NumberFormatException e) {
            txtCalculator.setText("Enter a Number Now!");
        }
        h = plu + han + cle + ele;
        txtHours.setText(String.format("%.2f", h));
    }//GEN-LAST:event_txtCleaningKeyReleased

    private void txtElectricalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtElectricalKeyReleased
        try {
            ele = Double.parseDouble(txtElectrical.getText());
        } catch (NumberFormatException e) {
            txtCalculator.setText("Enter a Number Now!");
        }
        h = plu + han + cle + ele;
        txtHours.setText(String.format("%.2f", h));
    }//GEN-LAST:event_txtElectricalKeyReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        // TODO add your handling code here:      
       if(txtSubTotal.getText().trim().isEmpty()||txtTax2.getText().trim().isEmpty()||txtAmount.getText().trim().isEmpty()){
             JOptionPane.showMessageDialog(null, "Please do calculate first !");
        }
        else{
        sbwk.setStatus("Confirmed");
        sbwk.setPayment(Double.parseDouble(txtAmount.getText()));
        JOptionPane.showMessageDialog(null, "Billing generate successfully!");
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ConfirmPayment cp = (ConfirmPayment) component;
        cp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);}
    }//GEN-LAST:event_btnProceedActionPerformed

    private void txtTotalCostLabourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCostLabourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalCostLabourActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CalculatorjPanel;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDecimal;
    private javax.swing.JButton btnDivide;
    private javax.swing.JButton btnEqual;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnMultiply;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnProceed;
    private javax.swing.JButton btnReset;
    private javax.swing.JCheckBox checkCleaning;
    private javax.swing.JCheckBox checkElectrical;
    private javax.swing.JCheckBox checkHandyman;
    private javax.swing.JCheckBox checkPlumbing;
    private javax.swing.JCheckBox checkTax;
    private javax.swing.JCheckBox checkVAT;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTax;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblTotalDelivery;
    private javax.swing.JLabel lblTotalItems;
    private javax.swing.JLabel lblTotalItems1;
    private javax.swing.JLabel lblTotalItems2;
    private javax.swing.JLabel lblTotalMileage;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCalculator;
    private javax.swing.JTextField txtCleaning;
    private javax.swing.JTextField txtCostDelivery;
    private javax.swing.JTextField txtElectrical;
    private javax.swing.JTextField txtEquipments;
    private javax.swing.JTextField txtHandyman;
    private javax.swing.JTextField txtHours;
    private javax.swing.JTextField txtPlumbing;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTax1;
    private javax.swing.JTextField txtTax2;
    private javax.swing.JTextField txtTotalCostEquipment;
    private javax.swing.JTextField txtTotalCostLabour;
    private javax.swing.JTextField txtVAT;
    // End of variables declaration//GEN-END:variables
}

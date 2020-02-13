/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemManager;

import Business.Customer.Customer;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.Model;
import Business.Enterprise.TravelCompany.TravelCompany;
import Business.Network.Network;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.CustomerAccount;
import Business.UserAccount.EmployeeAccount;
import Business.UserAccount.UserAccount;
import UserInterface.LoginJFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author quanhaonan
 */
public class SystemManagerMainJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemManagerMainJPanel
     */
    
    private EcoSystem system;
    
    private JPanel container;
    private EmployeeAccount account;
    private JFrame frame;
    private List<Network>networklist;
    private List<Enterprise>enterpriselist;
    private List<Customer>customerlist;
    private ManagerOrganization m;
    public SystemManagerMainJPanel(EcoSystem system, JPanel container, UserAccount userAccount, JFrame frame) {
        initComponents();
        this.system=system;
        this.container=container;
        this.account=(EmployeeAccount)userAccount;
        this.frame=frame;
        this.networklist=system.getNetworkList();
        this.customerlist=system.getCustomers().getCustdir();
        this.enterpriselist=new ArrayList<>();
        for(Network net: networklist){
            for(Enterprise e:net.getEnterpriseDirectory().getEnterpriseList()){
                enterpriselist.add(e);
            }
        }
       // this.m = new ManagerOrganization();
        populatenetwork();
        populateenterprise();
        populatecustomer();
        populateinfo();
        populateTree();
        firstname.setEnabled(true);
        lastname.setEnabled(true);
        usernameTextField.setEnabled(true);
        phone.setEnabled(true);
        email.setEnabled(true);
        
        firstname.setEditable(false);
        lastname.setEditable(false);
        usernameTextField.setEditable(false);
        phone.setEditable(false);
        email.setEditable(false);
    }
    public void populatenetwork() {
        DefaultTableModel dtm = (DefaultTableModel) networktable.getModel();
        dtm.setRowCount(0);
        for(Network net:networklist){
            Object []row=new Object[2];
            row[0]=net;
            dtm.addRow(row);
        }
    }

    public void populateenterprise() {
        DefaultTableModel dtm = (DefaultTableModel) enterprisetable.getModel();
        dtm.setRowCount(0);
        for(Network net:networklist){
            for(Enterprise e:net.getEnterpriseDirectory().getEnterpriseList()){
             if(e instanceof Hotel ){
                Object []row=new Object[5];
                
                row[0]=e;
                row[1]=((Hotel) e).getAddress();
                row[2]=((Hotel) e).getPhonenumber();
                row[3]=net.getCity();
                dtm.addRow(row);
             }
             else if(e instanceof TravelCompany ){
                Object []row=new Object[5];
                row[0]=e;
                row[1]=((TravelCompany) e).getAddress();
                row[2]=((TravelCompany) e).getPhonenumber();
                row[3]=net.getCity();
                dtm.addRow(row);
             }
            }
        }
    }
        public void populateTree(){
        DefaultTreeModel model=(DefaultTreeModel)jTree1.getModel();
        ArrayList<Network> networkList=system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        
        Network network;
        Enterprise enterprise;
        Organization organization;
        
        DefaultMutableTreeNode networks=new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            networkNode=new DefaultMutableTreeNode(network.getCity());
            networks.insert(networkNode, i);
            
            enterpriseList=network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<enterpriseList.size();j++){
                enterprise=enterpriseList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
                
                organizationList=enterprise.getOrganizationDirectory().getOrganizationList();
                for(int k=0;k<organizationList.size();k++){
                    organization=organizationList.get(k);
                    organizationNode=new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        model.reload();
    }

    public void populatecustomer() {
         DefaultTableModel dtm = (DefaultTableModel) customertable.getModel();
        dtm.setRowCount(0);
        for(UserAccount ca:system.getUserAccountDirectory().getUserAccountList()){
            if(ca instanceof CustomerAccount){
                CustomerAccount c=(CustomerAccount) ca;
                Object []row=new Object[5];
                row[0]=c;
                row[1]=c.getCustomer().getPhonenumber();
                row[2]=c.getCustomer().getEmail();
                dtm.addRow(row);
            }
        }
    }
    public void populateinfo() {
        EmployeeAccount ea=(EmployeeAccount)account;
        usernameTextField.setText(ea.getUsername());
        firstname.setText(ea.getEmployee().getFirstname());
        lastname.setText(ea.getEmployee().getLastname());
        phone.setText(ea.getEmployee().getPhonenumber());
        email.setText(ea.getEmployee().getEmail());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        addnetwork = new javax.swing.JButton();
        editnetwork = new javax.swing.JButton();
        deletenetwork = new javax.swing.JButton();
        workarea = new javax.swing.JPanel();
        Addenterprise = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane1 = new javax.swing.JScrollPane();
        networktable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        enterprisetable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        enterpriseworkarea = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        customertable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        customerworkarea = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        password = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        addnetwork.setText("AddNetwork");
        addnetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnetworkActionPerformed(evt);
            }
        });

        editnetwork.setText("EditNetwork");
        editnetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editnetworkActionPerformed(evt);
            }
        });

        deletenetwork.setText("DeleteNetwork");
        deletenetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletenetworkActionPerformed(evt);
            }
        });

        workarea.setLayout(new java.awt.CardLayout());

        Addenterprise.setText("Addenterprise");
        Addenterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddenterpriseActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(jTree1);

        networktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Network"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(networktable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(editnetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addnetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deletenetwork)
                                .addComponent(Addenterprise)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(workarea, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(addnetwork)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editnetwork)
                .addGap(18, 18, 18)
                .addComponent(deletenetwork)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Addenterprise)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(workarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Network", jPanel1);

        enterprisetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Address", "Phonenumer", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(enterprisetable);
        if (enterprisetable.getColumnModel().getColumnCount() > 0) {
            enterprisetable.getColumnModel().getColumn(0).setResizable(false);
            enterprisetable.getColumnModel().getColumn(1).setResizable(false);
            enterprisetable.getColumnModel().getColumn(2).setResizable(false);
            enterprisetable.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        enterpriseworkarea.setLayout(new java.awt.CardLayout());

        jButton4.setText("Create Manager");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(121, 121, 121)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(enterpriseworkarea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterpriseworkarea, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Enterprise", jPanel2);

        customertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Phone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(customertable);
        if (customertable.getColumnModel().getColumnCount() > 0) {
            customertable.getColumnModel().getColumn(0).setResizable(false);
            customertable.getColumnModel().getColumn(1).setResizable(false);
            customertable.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton5.setText("DeleteCustomer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("EditCustomer");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        customerworkarea.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerworkarea, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(54, 54, 54))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerworkarea, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customer", jPanel3);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Username: ");

        usernameTextField.setEnabled(false);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel12.setText("First Name: ");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel16.setText("Last Name: ");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Phone:");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Email:");

        jButton7.setText("Edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Confirm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("ChangePassword");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        password.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(69, 69, 69))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Profile", jPanel4);

        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index=enterprisetable.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(null, "select an enterprise");
            return ;
            }
        if(index>=0){
            Enterprise e=(Enterprise) enterprisetable.getValueAt(index, 0);
             Model m=(Model)e;
             Editenterprise e1=new Editenterprise(system,m,enterpriseworkarea,this);
             enterpriseworkarea.add(e1);
        }
                  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index=enterprisetable.getSelectedRow();
                if(index<0){
            JOptionPane.showMessageDialog(null, "select an enterprise");
            return ;
            }
        if(index>=0){
            Enterprise e=(Enterprise)enterprisetable.getValueAt(index, 0);
            List<Enterprise> en=new ArrayList<>();
            for(Network network:networklist){
                //en=network.getEnterpriseDirectory().getEnterpriseList();
                network.getEnterpriseDirectory().getEnterpriseList().remove(e);
            }
            this.populateTree();
            populateenterprise();
            DB4OUtil.getInstance().storeSystem(system);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.frame.dispose();
        LoginJFrame lf = new LoginJFrame();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int index=customertable.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(null, "select a customer");
            return ;
        }
        if(index>=0){
                CustomerAccount ca=(CustomerAccount)customertable.getValueAt(index, 0);
                EditCustomer editCustomer=new EditCustomer(system,customerworkarea,ca,this);
                customerworkarea.add(editCustomer);
                
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int index=customertable.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(null, "select a customer");
            return ;
        }
        if(index>=0){
            UserAccount ua=(UserAccount)customertable.getValueAt(index, 0);
            system.getUserAccountDirectory().getUserAccountList().remove(ua);
            DB4OUtil.getInstance().storeSystem(system);
            populatecustomer();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        firstname.setEditable(true);
        lastname.setEditable(true);
        usernameTextField.setEditable(true);
        phone.setEditable(true);
        email.setEditable(true);
        String usernameString=usernameTextField.getText();
        String firstnameString=firstname.getText();
        String lastnameString=lastname.getText();
        String phoneString=phone.getText();
        String emString=email.getText();
        
        if(usernameString.equals("")){
            JOptionPane.showMessageDialog(null, "username can not be empty");
            return ;
        }if(firstnameString.equals("")){
            JOptionPane.showMessageDialog(null, "firstname can not be empty");
            return ;
        }if(lastnameString.equals("")){
            JOptionPane.showMessageDialog(null, "lastname can not be empty");
            return ;
        }if(phoneString.equals("")){
            JOptionPane.showMessageDialog(null, "phone can not be empty");
            return ;
        }if(emString.equals("")){
            JOptionPane.showMessageDialog(null, "email can not be empty");
            return ;
        }
        account.setUsername(usernameTextField.getText());
        account.getEmployee().setFirstname(firstname.getText());
        account.getEmployee().setLastname(lastname.getText());
        account.getEmployee().setPhonenumber(phone.getText());
        account.getEmployee().setEmail(email.getText());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        changepassword ch=new changepassword(system,account,this,password,this.frame);
        password.add(ch);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void AddenterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddenterpriseActionPerformed
        // TODO add your handling code here:
        int index=networktable.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(null, "select a city please");
            return ;
        }
        Network net=(Network)networktable.getValueAt(index, 0);
        Addenterprise add=new Addenterprise(system,workarea,this,net);
        workarea.add(add);

    }//GEN-LAST:event_AddenterpriseActionPerformed

    private void deletenetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletenetworkActionPerformed
        // TODO add your handling code here:
        int index=networktable.getSelectedRow();
        if(index<0)JOptionPane.showMessageDialog(null, "select a city");
        else{
            Network network=(Network)networktable.getValueAt(index, 0);
            system.getNetworkList().remove(network);
        }
        populatenetwork();
        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_deletenetworkActionPerformed

    private void editnetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editnetworkActionPerformed
        // TODO add your handling code here:
        int index =networktable.getSelectedRow();
        if(index<0){JOptionPane.showMessageDialog(null, "select a city");return;}
        else {
            Network net=(Network)networktable.getValueAt(index, 0);
            Editnetwork edit=new Editnetwork(system,workarea,this,net);
            workarea.add(edit);
        }

    }//GEN-LAST:event_editnetworkActionPerformed

    private void addnetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnetworkActionPerformed
        // TODO add your handling code here:

        Addnetwork add=new Addnetwork(system,workarea,this);
        // workarea.remove(this);
        workarea.add(add);

    }//GEN-LAST:event_addnetworkActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(firstname.getText().equals("")){ JOptionPane.showMessageDialog(null, "firstname can not be empty"); return ;}
        if(lastname.getText().equals("")) {JOptionPane.showMessageDialog(null, "lastname can not be empty");return ;}
        if(phone.getText().equals("")) {JOptionPane.showMessageDialog(null, "phonenumber can not be empty");return ;}
        else{
            char[]tem=phone.getText().toCharArray();
            for(int i=0;i<tem.length;i++){
                if(tem[i]<'0'||tem[i]>'9'){
                    JOptionPane.showMessageDialog(null,"phone number can only contains number");
                    return ;
                }
            }
        }
        if(email.getText().equals("")) {JOptionPane.showMessageDialog(null, "email can not be empty");return;}
        else {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
        Pattern regex = Pattern.compile(check);  
        Matcher matcher = regex.matcher(email.getText());  
        boolean isMatched = matcher.matches(); 
        if(!isMatched){
            JOptionPane.showMessageDialog(null,"Please Follow xxx@xxx.com format");
            return ;
        }
        }
        account.setUsername(usernameTextField.getText());
       account.getEmployee().setEmail(email.getText());
       account.getEmployee().setPhonenumber(phone.getText());
       account.getEmployee().setFirstname(firstname.getText());
       account.getEmployee().setLastname(lastname.getText());
       usernameTextField.setEnabled(true);
       firstname.setEnabled(true);
       lastname.setEnabled(true);
       phone.setEnabled(true);
       email.setEnabled(true);
       
       usernameTextField.setEditable(false);
       firstname.setEditable(false);
       lastname.setEditable(false);
       phone.setEditable(false);
       email.setEditable(false);
       DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int index=enterprisetable.getSelectedRow();
        Model e=(Model)enterprisetable.getValueAt(index, 0);
        for(Organization o: e.getOrganizationDirectory().getOrganizationList()){
            if(o instanceof ManagerOrganization){
                m = (ManagerOrganization) o;
            }
        }
        if(m.getUserAccountDirectory().getEmployeeAccount().size()>0){
            JOptionPane.showMessageDialog(null, "this enterprise has an manager");
            return ;
        }
        
        Addmanager am =new Addmanager(system,this,e,enterpriseworkarea);
        enterpriseworkarea.add(am);
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addenterprise;
    private javax.swing.JButton addnetwork;
    private javax.swing.JTable customertable;
    private javax.swing.JPanel customerworkarea;
    private javax.swing.JButton deletenetwork;
    private javax.swing.JButton editnetwork;
    private javax.swing.JTextField email;
    private javax.swing.JTable enterprisetable;
    private javax.swing.JPanel enterpriseworkarea;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTable networktable;
    private javax.swing.JPanel password;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JPanel workarea;
    // End of variables declaration//GEN-END:variables








}

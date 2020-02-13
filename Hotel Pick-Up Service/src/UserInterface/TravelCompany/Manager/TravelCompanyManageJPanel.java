/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.TravelCompany.Manager;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.Hotel.Room;
import Business.Enterprise.TravelCompany.TravelCompany;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.StaffOrganization;
import Business.Role.ManagerRole;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.UserAccount.EmployeeAccount;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.TransportRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.Hotel.Manager.PasswordJPanel;
import UserInterface.Hotel.Manager.SelectTCJFrame;
import UserInterface.LoginJFrame;
import java.awt.Image;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quanhaonan
 */
public class TravelCompanyManageJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TravelCompanyManagerMainJPanel
     */
    private EcoSystem system;
    private JPanel container;
    private Network net;
    private Enterprise enterprise;
    private EmployeeAccount account;
    private JFrame frame;
    private Role role;
    private TravelCompany tc;
    private String path;
    private String newpath;
    private ArrayList<TransportRequest> tp;
    private Employee employee;
    private StaffOrganization o1;
    public TravelCompanyManageJPanel(EcoSystem system, JPanel container, Network net, Enterprise enterprise, UserAccount userAccount, JFrame frame, Role role) {
        initComponents();
        this.system=system;
        this.container=container;
        this.net=net;
        this.enterprise=enterprise;
        this.account=(EmployeeAccount) userAccount;
        this.frame=frame;
        this.role=role;
        this.employee=account.getEmployee();
        tc=(TravelCompany) enterprise;
        this.path=tc.getPhotoPath();
        cbtn.setEnabled(false);
        for(Organization o:enterprise.getOrganizationDirectory().getOrganizationList()){
            if(o instanceof StaffOrganization){
                o1=(StaffOrganization)o;
            }
        }
        
        populateemployee();
        populateorder();
        setProfileInfo();
        setcompanyinfo();
//      confirmbtn1.setEnabled(false);
//      cadd.setEnabled(false);
//          nametext.setEnabled(false);
//             pricetext.setEnabled(false);   ////setEditable
             firstname.setEnabled(true);
             email.setEnabled(true);
             lastname.setEnabled(true);
             phone.setEnabled(true);
             
             firstname.setEditable(false);
             email.setEditable(false);
             lastname.setEditable(false);
             phone.setEditable(false);

    }
    private void setProfileFieldsEditable(boolean b) {
        email.setEditable(b);
        firstname.setEditable(b);
        lastname.setEditable(b);
        phone.setEditable(b);
        
        email.setEnabled(true);
        firstname.setEnabled(true);
        lastname.setEnabled(true);
        phone.setEnabled(true);
    }
        private void setProfileInfo() {
        email.setText(employee.getEmail());
        firstname.setText(employee.getFirstname());
        lastname.setText(employee.getLastname());
        phone.setText(employee.getPhonenumber());
        usernameTextField.setText(this.account.getUsername());
    }
    public void populateemployee() {
        DefaultTableModel dtm = (DefaultTableModel) tabledriver.getModel();
        dtm.setRowCount(0);
        
        //Hotel h=(Hotel)en;
        for(EmployeeAccount e:o1.getUserAccountDirectory().getEmployeeAccount()){
            if(e.getRole().getRoletype()==RoleType.Driver){
            Object []row=new Object [5];
            row[0]=e;
            row[1]=e.getEmployee().getPhonenumber();
            row[2]=e.getEmployee().getEmail();
            dtm.addRow(row);
            }
            
        }
    }

    public void setcompanyinfo() {
        hotelname.setText(tc.getName());
        hoteladdress.setText(tc.getAddress());
        hotelphone.setText(tc.getPhonenumber());
        ImageIcon image = new ImageIcon(path);
        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        photo.setIcon(image);
    }
    private void populateorder() {
        DefaultTableModel dtm = (DefaultTableModel) tableorder.getModel();
        dtm.setRowCount(0);
        //ArrayList<OrderRequest> work=new ArrayList<>();
        tp=new ArrayList<>();
            for(WorkRequest wr: net.getWorkqueue().getWorkRequestList()){
            if(wr.getEnterprise()==enterprise){
             tp.add((TransportRequest)wr);
            }
        }
       // System.out.println(net.getWorkqueue().getWorkRequestList());
        System.out.println(tp);
        //DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        //dtm.setRowCount(0);
        //System.out.println(system.getUserAccountDirectory().getEmployeeAccount());
        for(TransportRequest wr:tp){
           // System.out.print(e);
            Object []row=new Object [5];
            row[0]=wr;
            row[1]=wr.getCustomername();
            row[2]=wr.getCustomerphone();
            row[3]=wr.getStatus();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableorder = new javax.swing.JTable();
        confirmbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledriver = new javax.swing.JTable();
        deletebtn = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        workarea = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        hotelname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hoteladdress = new javax.swing.JTextField();
        hotelphone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        cbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        passwordarea = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        saveButton1 = new javax.swing.JButton();
        cancelButton2 = new javax.swing.JButton();
        editButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        tableorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Name", "Phone", "Status"
            }
        ));
        jScrollPane2.setViewportView(tableorder);

        confirmbtn.setText("Confirm");
        confirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbtnActionPerformed(evt);
            }
        });

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(confirmbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelbtn)
                .addGap(176, 176, 176))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmbtn)
                    .addComponent(cancelbtn))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Order", jPanel4);

        tabledriver.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabledriver);
        if (tabledriver.getColumnModel().getColumnCount() > 0) {
            tabledriver.getColumnModel().getColumn(0).setResizable(false);
            tabledriver.getColumnModel().getColumn(1).setResizable(false);
            tabledriver.getColumnModel().getColumn(2).setResizable(false);
        }

        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        workarea.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(addbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletebtn)))
                .addGap(38, 38, 38)
                .addComponent(workarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addbtn)
                            .addComponent(deletebtn)))
                    .addComponent(workarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Driver", jPanel6);

        hotelname.setEditable(false);

        jLabel4.setText("Name:");

        jLabel5.setText("Address:");

        hoteladdress.setEditable(false);

        hotelphone.setEditable(false);

        jLabel6.setText("Phone:");

        jButton3.setText("UpdatePhoto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbtn.setText("Confirm");
        cbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(38, 38, 38)
                                .addComponent(hotelname, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hoteladdress)
                                    .addComponent(hotelphone, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hotelname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(hoteladdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(hotelphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbtn)
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addComponent(photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("CompanyInfo", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage", jPanel1);

        passwordarea.setLayout(new java.awt.CardLayout());

        usernameTextField.setEnabled(false);
        usernameTextField.setEditable(false);
        usernameTextField.setEnabled(false);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Username: ");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel12.setText("First Name: ");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel16.setText("Last Name: ");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Phone:");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Email:");

        saveButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton1.setText("Save");
        saveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton1ActionPerformed(evt);
            }
        });

        cancelButton2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton2.setText("Cancel");
        cancelButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton2ActionPerformed(evt);
            }
        });

        editButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton1.setText("Edit");
        editButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ChangePassword");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(69, 69, 69))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cancelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordarea, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editButton1)
                            .addComponent(saveButton1)
                            .addComponent(cancelButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(0, 131, Short.MAX_VALUE))
                    .addComponent(passwordarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Profile", jPanel3);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Transportation Manager");

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.frame.dispose();
        LoginJFrame lf = new LoginJFrame();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        int index=tabledriver.getSelectedRow();
        //TableModel model = table.getModel();
        if(index<0){
            JOptionPane.showMessageDialog(null, "select an driver");
            return ;
            }
        if (index >= 0) {

            EmployeeAccount account=(EmployeeAccount)tabledriver.getValueAt(index,0);
            //system.getUserAccountDirectory().removeAccount(account);
            StaffOrganization o1=(StaffOrganization)enterprise.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Staff);
            o1.getUserAccountDirectory().removeAccount(account);
            DB4OUtil.getInstance().storeSystem(system);
            populateemployee();

            //            CardLayout layout = (CardLayout) this.detailJPanel.getLayout();
            //            layout.next(detailJPanel);
        }
    }//GEN-LAST:event_deletebtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
        Adddriver add=new Adddriver(system,net,tc,workarea,this);
//        workarea.remove(this);
        workarea.add(add);
        DB4OUtil.getInstance().storeSystem(system);
        this.populateemployee();
    }//GEN-LAST:event_addbtnActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void saveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton1ActionPerformed
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
        if (!email.getText().equals("") && !firstname.getText().equals("")
            && !lastname.getText().equals("") && !phone.getText().equals("")) {
            this.employee.setEmail(email.getText());
            this.employee.setFirstname(firstname.getText());
            this.employee.setLastname(lastname.getText());
            this.employee.setPhonenumber(phone.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        }
        setProfileFieldsEditable(false);
        saveButton1.setEnabled(false);
        cancelButton2.setEnabled(false);
        editButton1.setEnabled(true);

        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_saveButton1ActionPerformed

    private void cancelButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton2ActionPerformed
        setProfileFieldsEditable(false);
        setProfileInfo();
        saveButton1.setEnabled(false);
        cancelButton2.setEnabled(false);
        editButton1.setEnabled(true);
    }//GEN-LAST:event_cancelButton2ActionPerformed

    private void editButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton1ActionPerformed
        saveButton1.setEnabled(true);
        cancelButton2.setEnabled(true);
        editButton1.setEnabled(false);

        setProfileFieldsEditable(true);
    }//GEN-LAST:event_editButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PasswordJPanel pass=new PasswordJPanel(system,net,enterprise,account,passwordarea);
        //passwordarea.remove(this);
        passwordarea.add(pass);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void confirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtnActionPerformed
        // TODO add your handling code here:
        int index=tableorder.getSelectedRow();
                if(index<0){
            JOptionPane.showMessageDialog(null, "select an order");
            return ;
            }
        if(index>=0){
            TransportRequest or=(TransportRequest)tableorder.getValueAt(index,0);
            if(or.getStatus().equals(WorkRequest.StatusEnum.WaitForCheckin)){
                or.setStatus(WorkRequest.StatusEnum.pickupcustomer);
                DB4OUtil.getInstance().storeSystem(system);
                populateorder();
            }
        }
    }//GEN-LAST:event_confirmbtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        // TODO add your handling code here:
        int index=tableorder.getSelectedRow();
                if(index<0){
            JOptionPane.showMessageDialog(null, "select an order");
            return ;
            }
        if(index>=0){
            TransportRequest or=(TransportRequest)tableorder.getValueAt(index,0);
            if(or.getStatus().equals(WorkRequest.StatusEnum.WaitForCheckin)){
            net.getWorkqueue().getWorkRequestList().remove(or);
            or.getOr().setStatus(WorkRequest.StatusEnum.Cancelled);
            DB4OUtil.getInstance().storeSystem(system);
            populateorder();
            }
        }
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int i = chooser.showOpenDialog(null);
        if (i == chooser.APPROVE_OPTION) {
            newpath = chooser.getSelectedFile().getAbsolutePath();
            tc.setPhotoPath(newpath);
        } else {
            JOptionPane.showMessageDialog(null, "You didn't choose a photo");
            return ;
        }
        ImageIcon image = new ImageIcon(newpath);
        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        photo.setIcon(image);
        JOptionPane.showMessageDialog(null, "photo update successfully");
        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        hotelname.setEditable(true);
        hoteladdress.setEditable(true);
        hotelphone.setEditable(true);
        cbtn.setEnabled(true);

        // 

    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtnActionPerformed
        // TODO add your handling code here:
        String name=hotelname.getText();
        String address=hoteladdress.getText();
        String phone=hotelphone.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "name can not be empty");
            return ;
        }if(address.equals("")){
            JOptionPane.showMessageDialog(null, "address can not be empty");
            return ;
        }if(phone.equals("")){
            JOptionPane.showMessageDialog(null, "phone can not be empty");
            return ;
        }
        tc.setAddress(address);
       tc.setPhonenumber(phone);
        tc.setName(name);
        JOptionPane.showMessageDialog(null, "information update successfully");
        DB4OUtil.getInstance().storeSystem(system);
                hotelname.setEnabled(true); //setEditable
        hoteladdress.setEnabled(true);
        hotelphone.setEnabled(true);
        
        hotelname.setEditable(false); //setEditable
        hoteladdress.setEditable(false);
        hotelphone.setEditable(false);
        
        cbtn.setEnabled(false);
    }//GEN-LAST:event_cbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton cancelButton2;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton cbtn;
    private javax.swing.JButton confirmbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editButton1;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField hoteladdress;
    private javax.swing.JTextField hotelname;
    private javax.swing.JTextField hotelphone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField lastname;
    private javax.swing.JPanel passwordarea;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel photo;
    private javax.swing.JButton saveButton1;
    private javax.swing.JTable tabledriver;
    private javax.swing.JTable tableorder;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JPanel workarea;
    // End of variables declaration//GEN-END:variables



}

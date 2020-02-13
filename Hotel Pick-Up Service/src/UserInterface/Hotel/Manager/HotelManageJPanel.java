/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Hotel.Manager;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.Hotel.Room;
import static Business.Enterprise.Model.EnterpriseType.Hotel;
import Business.Network.Network;
import Business.Role.ManagerRole;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.UserAccount.EmployeeAccount;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.ReviewRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
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
public class HotelManageJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HotelManagerMainJPanel
     */
    private EcoSystem system;
    private Network net;
    private Enterprise en;
    private JPanel container;
    private EmployeeAccount account;
    private String newpath;
    private Hotel hotel;
    private JFrame frame;
    private Role role;
    private String path;
    private String originPath;
    private OrderRequest selectedOrder = null;
    private Employee employee;
    private Hotel h;
    private ArrayList<Room>roomlist;
    private ArrayList<OrderRequest>orderlist;
    private double totalrate;
    

    public HotelManageJPanel(EcoSystem system, JPanel container, Network net, Enterprise enterprise, UserAccount userAccount, JFrame frame, Role role) {
             initComponents();
             this.system=system;
             this.container=container;
             this.net=net;
             this.en=enterprise;
             this.account=(EmployeeAccount) userAccount;
             this.frame=frame;
             this.role=role;
             this.employee=account.getEmployee();
             cbtn.setEnabled(false);
             orderlist=new ArrayList<>();
             h=(Hotel)enterprise;
             roomlist=h.getRoomList();
             confirmbtn1.setEnabled(false);
             cadd.setEnabled(false);
             nametext.setEnabled(true);
             pricetext.setEnabled(true);
             firstname.setEnabled(true);
             email.setEnabled(true);
             lastname.setEnabled(true);
             phone.setEnabled(true);
             
             nametext.setEditable(false);
             pricetext.setEditable(false);
             firstname.setEditable(false);
             email.setEditable(false);
             lastname.setEditable(false);
             phone.setEditable(false);
             
             this.path=h.getPhotopath();
             populateemployeetable();
             populateordertable();
             populateroomtable();
             setProfileInfo();
             populateReviewTable();
             setTotalRate();
             populatehotelinfo();
    }
    private void setProfileFieldsEditable(boolean b) {
        email.setEnabled(true);
        firstname.setEnabled(true);
        lastname.setEnabled(true);
        phone.setEnabled(true);
        
        email.setEditable(b);
        firstname.setEditable(b);
        lastname.setEditable(b);
        phone.setEditable(b);
    }
    private void populateroomtable() {
        
        DefaultTableModel dtm = (DefaultTableModel) table2.getModel();
        dtm.setRowCount(0);
        Hotel h=(Hotel)en;
        for(Room r:roomlist){
            Object []row=new Object [5];
            row[0]=r;
            row[1]=r.getPrice();
            dtm.addRow(row);
        
        }
    }

    public void populateemployeetable() {
//        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
//        dtm.setRowCount(0);
//        //System.out.println(system.getUserAccountDirectory().getEmployeeAccount());
//        for(EmployeeAccount e:system.getUserAccountDirectory().getEmployeeAccount()){
//           // System.out.print(e);
//           if(e.getRole().getRoletype()==RoleType.Staff) {
//            Object []row=new Object [3];
//            System.out.println(e.getEmployee());
//            row[0]=e;
//            row[1]=e.getEmployee().getPhonenumber();
//            row[2]=e.getEmployee().getEmail();
//            dtm.addRow(row);
//           }
//        }
    }
    public void populatehotelinfo() {
        hotelname.setText(h.getName());
        hoteladdress.setText(h.getAddress());
        hotelphone.setText(h.getPhonenumber());
        ImageIcon image = new ImageIcon(path);
        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        photo.setIcon(image);
        
        
    }
    private void populateordertable() {
        ArrayList<OrderRequest> work=new ArrayList<>();
        for(WorkRequest wr: net.getWorkqueue().getWorkRequestList()){
            if(wr.getEnterprise()==en&&wr instanceof OrderRequest){
                work.add((OrderRequest)wr);
            }
        }
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        //System.out.println(system.getUserAccountDirectory().getEmployeeAccount());
        for(OrderRequest wr:work){
           // System.out.print(e);
            Object []row=new Object [5];
            row[0]=wr;
            row[1]=wr.getCustomername();
            row[2]=wr.getCustomerphone();
            row[3]=wr.getAmount();
            row[4]=wr.getStatus();
            dtm.addRow(row);
        }
    }
    private void setProfileInfo() {
        email.setText(employee.getEmail());
        firstname.setText(employee.getFirstname());
        lastname.setText(employee.getLastname());
        phone.setText(employee.getPhonenumber());
        usernameTextField.setText(this.account.getUsername());
        usernameTextField.setEnabled(true);
        usernameTextField.setEditable(false);
    }
    public void populateReviewTable() {
        DefaultTableModel dtm = (DefaultTableModel) reviewTable.getModel();
        dtm.setRowCount(0);
        for (WorkRequest wr : net.getWorkqueue().getWorkRequestList()) {
            if(wr.getEnterprise()==h&&wr instanceof OrderRequest){
                orderlist.add((OrderRequest)wr);
            }
        }
        for(OrderRequest or:orderlist){
            if (or.isReviewed()) {
                Object row[] = new Object[4];
                row[0] = or.getReview();
                row[1] = or.getAccount().getUsername();
                row[2] = or.getReview().getRate();
                row[3] = or.getReview().getMessage();
                dtm.addRow(row);
            }
        }
    }
    private void setTotalRate() {
        WorkQueue wq=new WorkQueue();
        for(OrderRequest or:orderlist){
            wq.getWorkRequestList().add(or);
        }
        totalratetext.setText(String.valueOf(h.getRate(wq)));
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
        ManageJPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        orderwork = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        confirmbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        roomwork = new javax.swing.JPanel();
        cadd = new javax.swing.JButton();
        confirmbtn1 = new javax.swing.JButton();
        nametext = new javax.swing.JTextField();
        pricetext = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        addbtn1 = new javax.swing.JButton();
        deletebtn1 = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        hotelname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hoteladdress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        hotelphone = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbtn = new javax.swing.JButton();
        reviewJPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        reviewTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        totalratetext = new javax.swing.JTextField();
        ProfileJPanel = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        editButton1 = new javax.swing.JButton();
        saveButton1 = new javax.swing.JButton();
        cancelButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        passwordarea = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        logoutbtn = new javax.swing.JButton();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Name", "Phone", "Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);

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

        javax.swing.GroupLayout orderworkLayout = new javax.swing.GroupLayout(orderwork);
        orderwork.setLayout(orderworkLayout);
        orderworkLayout.setHorizontalGroup(
            orderworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderworkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addGap(7, 7, 7))
            .addGroup(orderworkLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(confirmbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelbtn)
                .addGap(116, 116, 116))
        );
        orderworkLayout.setVerticalGroup(
            orderworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderworkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(orderworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmbtn)
                    .addComponent(cancelbtn))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Order", orderwork);

        cadd.setText("Confirmadd");
        cadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddActionPerformed(evt);
            }
        });

        confirmbtn1.setText("Confirmedit");
        confirmbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbtn1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Price:");

        jLabel1.setText("RoomType:");

        addbtn1.setText("add");
        addbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtn1ActionPerformed(evt);
            }
        });

        deletebtn1.setText("delete");
        deletebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn1ActionPerformed(evt);
            }
        });

        editbtn.setText("edit");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "RoomType", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table2);

        javax.swing.GroupLayout roomworkLayout = new javax.swing.GroupLayout(roomwork);
        roomwork.setLayout(roomworkLayout);
        roomworkLayout.setHorizontalGroup(
            roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomworkLayout.createSequentialGroup()
                .addGroup(roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roomworkLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roomworkLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roomworkLayout.createSequentialGroup()
                                .addComponent(editbtn)
                                .addGap(31, 31, 31)
                                .addComponent(deletebtn1))
                            .addGroup(roomworkLayout.createSequentialGroup()
                                .addComponent(confirmbtn1)
                                .addGap(18, 18, 18)
                                .addGroup(roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nametext)))
                            .addComponent(cadd))
                        .addGap(37, 37, 37)
                        .addGroup(roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addbtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(roomworkLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(pricetext))))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        roomworkLayout.setVerticalGroup(
            roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomworkLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editbtn)
                    .addComponent(deletebtn1)
                    .addComponent(addbtn1))
                .addGap(7, 7, 7)
                .addGroup(roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roomworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmbtn1)
                    .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pricetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadd)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("RoomInfo", roomwork);

        jLabel4.setText("Name:");

        hotelname.setEditable(false);

        jLabel5.setText("Address:");

        jLabel6.setText("Phone:");

        jButton2.setText("UpdatePhoto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbtn.setText("Confirm");
        cbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(38, 38, 38)
                                .addComponent(hotelname, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hoteladdress)
                                    .addComponent(hotelphone, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(hotelname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(hoteladdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(hotelphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbtn)
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addComponent(photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("HotelInfo", jPanel1);

        javax.swing.GroupLayout ManageJPanelLayout = new javax.swing.GroupLayout(ManageJPanel);
        ManageJPanel.setLayout(ManageJPanelLayout);
        ManageJPanelLayout.setHorizontalGroup(
            ManageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        ManageJPanelLayout.setVerticalGroup(
            ManageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("Mange", ManageJPanel);

        reviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Customer", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reviewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reviewTableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(reviewTable);

        jLabel3.setText("TotalRate:");

        javax.swing.GroupLayout reviewJPanelLayout = new javax.swing.GroupLayout(reviewJPanel);
        reviewJPanel.setLayout(reviewJPanelLayout);
        reviewJPanelLayout.setHorizontalGroup(
            reviewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(reviewJPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(totalratetext, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reviewJPanelLayout.setVerticalGroup(
            reviewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(reviewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totalratetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Review", reviewJPanel);

        usernameTextField.setEnabled(false);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        editButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton1.setText("Edit");
        editButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButton1ActionPerformed(evt);
            }
        });

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

        passwordarea.setLayout(new java.awt.CardLayout());

        jButton1.setText("ChangePassword");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProfileJPanelLayout = new javax.swing.GroupLayout(ProfileJPanel);
        ProfileJPanel.setLayout(ProfileJPanelLayout);
        ProfileJPanelLayout.setHorizontalGroup(
            ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileJPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileJPanelLayout.createSequentialGroup()
                            .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(69, 69, 69))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileJPanelLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileJPanelLayout.createSequentialGroup()
                            .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(saveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cancelButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProfileJPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordarea, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        ProfileJPanelLayout.setVerticalGroup(
            ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileJPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProfileJPanelLayout.createSequentialGroup()
                        .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(12, 12, 12)
                        .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(ProfileJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editButton1)
                            .addComponent(saveButton1)
                            .addComponent(cancelButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 92, Short.MAX_VALUE))
                    .addComponent(passwordarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Profile", ProfileJPanel);

        logoutbtn.setText("Logout");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
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
                        .addComponent(logoutbtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        // TODO add your handling code here:
        this.frame.dispose();
        LoginJFrame lf = new LoginJFrame();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PasswordJPanel pass=new PasswordJPanel(system,net,en,account,passwordarea);
        //passwordarea.remove(this);
        passwordarea.add(pass);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton2ActionPerformed
        setProfileFieldsEditable(false);
        setProfileInfo();
        saveButton1.setEnabled(false);
        cancelButton2.setEnabled(false);
        editButton1.setEnabled(true);
    }//GEN-LAST:event_cancelButton2ActionPerformed

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
//if (!emailTextField.getText().equals("") && !firstNameTextField.getText().equals("")
//            && !lastNameTextField.getText().equals("") && !phoneTextField1.getText().equals("")) {
//            this.employee.setEmail(emailTextField.getText());
//            this.employee.setFirstname(firstNameTextField.getText());
//            this.employee.setLastname(lastNameTextField.getText());
//            this.employee.setPhonenumber(phoneTextField1.getText());
//        } else {
//            JOptionPane.showMessageDialog(null, "Information can't be empty");
//            return;
//        }
        setProfileFieldsEditable(false);
        saveButton1.setEnabled(false);
        cancelButton2.setEnabled(false);
        editButton1.setEnabled(true);

        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_saveButton1ActionPerformed

    private void editButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButton1ActionPerformed
        saveButton1.setEnabled(true);
        cancelButton2.setEnabled(true);
        editButton1.setEnabled(false);

        setProfileFieldsEditable(true);
    }//GEN-LAST:event_editButton1ActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        // TODO add your handling code here:
        //table.setEnabled(true);
        int index=table2.getSelectedRow();
        if(index<0){
                 
            JOptionPane.showMessageDialog(null, "select a room");
             return ;
        }
        Room r=(Room)table2.getValueAt(index, 0);
        nametext.setEnabled(true);
        pricetext.setEnabled(true);
        nametext.setEditable(true);
        pricetext.setEditable(true);

        nametext.setText(r.getName());
        pricetext.setText(String.valueOf(r.getPrice()));
        confirmbtn1.setEnabled(true);
    }//GEN-LAST:event_editbtnActionPerformed

    private void deletebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn1ActionPerformed
        // TODO add your handling code here:
        int index=table2.getSelectedRow();
        if(index>=0){

            Room r=(Room)table2.getValueAt(index, 0);
            roomlist.remove(r);
            h.getRoomList().remove(r);
            
            DB4OUtil.getInstance().storeSystem(system);
            populateroomtable();

        }
    }//GEN-LAST:event_deletebtn1ActionPerformed

    private void addbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn1ActionPerformed
        // TODO add your handling code here:
        //confirmbtn.setEnabled(true);
        nametext.setEditable(true);
        pricetext.setEditable(true);
        cadd.setEnabled(true);
        //int index=table.getSelectedRow();
    }//GEN-LAST:event_addbtn1ActionPerformed

    private void confirmbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtn1ActionPerformed
        // TODO add your handling code here:
        if(!nametext.getText().equals("")){
            
        int index=table2.getSelectedRow();
               if(nametext.getText().equals("")){
            JOptionPane.showMessageDialog(null, "name can not be empty");
            return ;
        }
        if(pricetext.getText().equals("")){
            JOptionPane.showMessageDialog(null, "price can not be empty");
            return ;
        }
        try{
            Double.parseDouble(pricetext.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "You have to input a number");
            return ;
        }
        Room r=(Room)table2.getValueAt(index, 0);
        r.setName(nametext.getText());
        r.setPrice(Double.parseDouble(pricetext.getText()));
        DB4OUtil.getInstance().storeSystem(system);
        nametext.setEditable(false);
        
        populateroomtable();
        
        }
    }//GEN-LAST:event_confirmbtn1ActionPerformed

    private void caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddActionPerformed
        // TODO add your handling code here:
        if(nametext.getText().equals("")){
            JOptionPane.showMessageDialog(null, "name can not be empty");
            return ;
        }
        if(pricetext.getText().equals("")){
            JOptionPane.showMessageDialog(null, "price can not be empty");
            return ;
        }
        try{
            Double.parseDouble(pricetext.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "You have to input a number");
            return ;
        }
        Room r=new Room(nametext.getText(),Double.parseDouble(pricetext.getText()),h);
        h.addRoom(r);
        roomlist.add(r);
        DB4OUtil.getInstance().storeSystem(system);

        populateroomtable();
        cadd.setEnabled(false);
    }//GEN-LAST:event_caddActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        // TODO add your handling code here:
        int index=table1.getSelectedRow();
             if(index<0){
            JOptionPane.showMessageDialog(null, "select an order");
        }
        if(index>=0){
            OrderRequest or=(OrderRequest)table1.getValueAt(index,0);
            if(or.getStatus().equals(WorkRequest.StatusEnum.Processing)){
            net.getWorkqueue().getWorkRequestList().remove(or);
            DB4OUtil.getInstance().storeSystem(system);
            populateordertable();
            }
        }
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void confirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtnActionPerformed
        // TODO add your handling code here:
        int index=table1.getSelectedRow();
        if(index<0){
            JOptionPane.showMessageDialog(null, "select an order");
        }
        if(index>=0){
            OrderRequest or=(OrderRequest)table1.getValueAt(index,0);
            if(or.getStatus().equals(WorkRequest.StatusEnum.Processing)){
                or.setStatus(WorkRequest.StatusEnum.WaitForCheckin);
                DB4OUtil.getInstance().storeSystem(system);
                populateordertable();
                SelectTCJFrame tc=new SelectTCJFrame(system,net,or,this,this.h);
                tc.setLocationRelativeTo(null);
                tc.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_confirmbtnActionPerformed

    private void reviewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reviewTableMouseClicked
        int index = reviewTable.getSelectedRow();

        if (index >= 0) {
            ReviewRequest rr = (ReviewRequest) reviewTable.getValueAt(index, 0);
//            customerTextField.setText(rr.getAccount().getUsername());
//            rateTextField.setText(rr.getRate() + "");
//            reviewTextArea.setText(rr.getMessage());
        }
    }//GEN-LAST:event_reviewTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        hotelname.setEditable(true);
        hotelname.setEnabled(true);
        
        hoteladdress.setEditable(true);
        hotelphone.setEditable(true);
        cbtn.setEnabled(true);

       // DB4OUtil.getInstance().storeSystem(system);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = chooser.showOpenDialog(null);
        if (i == chooser.APPROVE_OPTION) {
            newpath = chooser.getSelectedFile().getAbsolutePath();
            h.setPhotoPath(newpath);
        } else {
            JOptionPane.showMessageDialog(null, "You didn't choose a photo");
        }
                ImageIcon image = new ImageIcon(newpath);
        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        photo.setIcon(image);
        JOptionPane.showMessageDialog(null, "photo update successfully");
        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_jButton2ActionPerformed

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
        h.setAddress(address);
        h.setPhonenumber(phone);
        h.setName(name);
        JOptionPane.showMessageDialog(null, "information update successfully");
        DB4OUtil.getInstance().storeSystem(system);
        hotelname.setEnabled(true);
        hoteladdress.setEnabled(true);
        hotelphone.setEnabled(true);
        
        hotelname.setEditable(false);
        hoteladdress.setEditable(false);
        hotelphone.setEditable(false);
        
        cbtn.setEnabled(false);
    }//GEN-LAST:event_cbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ManageJPanel;
    private javax.swing.JPanel ProfileJPanel;
    private javax.swing.JButton addbtn1;
    private javax.swing.JButton cadd;
    private javax.swing.JButton cancelButton2;
    private javax.swing.JButton cancelbtn;
    private javax.swing.JButton cbtn;
    private javax.swing.JButton confirmbtn;
    private javax.swing.JButton confirmbtn1;
    private javax.swing.JButton deletebtn1;
    private javax.swing.JButton editButton1;
    private javax.swing.JButton editbtn;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField hoteladdress;
    private javax.swing.JTextField hotelname;
    private javax.swing.JTextField hotelphone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField lastname;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextField nametext;
    private javax.swing.JPanel orderwork;
    private javax.swing.JPanel passwordarea;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField pricetext;
    private javax.swing.JPanel reviewJPanel;
    private javax.swing.JTable reviewTable;
    private javax.swing.JPanel roomwork;
    private javax.swing.JButton saveButton1;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTextField totalratetext;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables



 



}

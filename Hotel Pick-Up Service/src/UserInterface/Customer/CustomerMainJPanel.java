/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Customer.Customer;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.Model;
import Business.Enterprise.Model.EnterpriseType;
import Business.Network.Network;
import Business.Role.CustomerRole;
import Business.Role.Role;
import Business.UserAccount.CustomerAccount;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.Customer.CartJFrame;
import UserInterface.Customer.HotelDetailsJPanel;
import UserInterface.Customer.RoomDetailsJPanel;
import UserInterface.Hotel.Manager.PasswordJPanel;
import UserInterface.LoginJFrame;
import com.sun.awt.AWTUtilities;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author roc
 */
public class CustomerMainJPanel extends javax.swing.JPanel {
    
    
    public EcoSystem system;
    private JPanel container;
    private CustomerAccount account;
    private Customer customer;
    private JFrame frame;
    private Role accessRole;
    public Network net;
    private SelectCityJPanel CityPanel;
    //-------------------------------------------
 
    private Model.EnterpriseType type;
    private ArrayList<Hotel> hotellist;
    
    public String city;
    public CustomerMainJPanel cbj = this;

    /**
     * Creates new form CustomerBoardJPanel
     */
    public CustomerMainJPanel(EcoSystem system, JPanel container, UserAccount userAccount, JFrame frame) {
        initComponents();
        this.system = system;
        this.container = container;
        //this.account = account;
        this.account=(CustomerAccount)userAccount;
        this.customer = account.getCustomer();
        this.frame = frame;
        this.accessRole = accessRole;
        namelabel.setText(customer.getName());
        btnDetail.setEnabled(false);
        
       // jComboBox1.addItem("Serif");
        
        //populateshoplistTable();
        
    }
    

    
    
    public void populateshoplistTable() {
        DefaultTableModel dtm = (DefaultTableModel) HotelTable1.getModel();
        dtm.setRowCount(0);
            for (Hotel b : net.getHotellist()) {
                Object row[] = new Object[3];
                row[0] = b;
                row[1] = b.getType();
                row[2] = b.getAddress();
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

        jLabel4 = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        logoutbtn = new javax.swing.JButton();
        cartbtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        SearchJPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        citysearchfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        HotelTable1 = new javax.swing.JTable();
        SelectCityBtn = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        reviewJPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        detailJPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        detailJPanel1 = new javax.swing.JPanel();
        hotelnamelabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel4.setText("Welcome:");

        namelabel.setFont(new java.awt.Font("宋体", 3, 18)); // NOI18N
        namelabel.setText("<Name>");
        namelabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        namelabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                namelabelMouseClicked(evt);
            }
        });

        logoutbtn.setText("Logout");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        cartbtn.setText("Cart");
        cartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartbtnActionPerformed(evt);
            }
        });

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("City:");

        HotelTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hotel", "Type", "Adress"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(HotelTable1);

        SelectCityBtn.setText("...");
        SelectCityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectCityBtnActionPerformed(evt);
            }
        });

        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchJPanelLayout = new javax.swing.GroupLayout(SearchJPanel);
        SearchJPanel.setLayout(SearchJPanelLayout);
        SearchJPanelLayout.setHorizontalGroup(
            SearchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchJPanelLayout.createSequentialGroup()
                .addGap(780, 780, 780)
                .addComponent(btnDetail)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(SearchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SearchJPanelLayout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(SearchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addGroup(SearchJPanelLayout.createSequentialGroup()
                            .addGroup(SearchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(SearchJPanelLayout.createSequentialGroup()
                                    .addComponent(citysearchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SelectCityBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5))
                            .addGap(607, 607, 607)))
                    .addGap(53, 53, 53)))
        );
        SearchJPanelLayout.setVerticalGroup(
            SearchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchJPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnDetail)
                .addContainerGap(440, Short.MAX_VALUE))
            .addGroup(SearchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(SearchJPanelLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(SearchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(citysearchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SelectCityBtn))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Search", SearchJPanel);

        detailJPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        detailJPanel.setLayout(new java.awt.CardLayout());

        detailJPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        detailJPanel1.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(detailJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(515, 515, 515))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(detailJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(detailJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 202, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        hotelnamelabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        hotelnamelabel.setText("<Type>");

        javax.swing.GroupLayout reviewJPanelLayout = new javax.swing.GroupLayout(reviewJPanel);
        reviewJPanel.setLayout(reviewJPanelLayout);
        reviewJPanelLayout.setHorizontalGroup(
            reviewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewJPanelLayout.createSequentialGroup()
                .addGroup(reviewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reviewJPanelLayout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(hotelnamelabel))
                    .addGroup(reviewJPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1023, 1023, 1023))
        );
        reviewJPanelLayout.setVerticalGroup(
            reviewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewJPanelLayout.createSequentialGroup()
                .addComponent(hotelnamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("View ", reviewJPanel);

        jLabel1.setText("VIew Your Profile By Click Your name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addComponent(namelabel)
                        .addGap(29, 29, 29)
                        .addComponent(logoutbtn)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(namelabel)
                    .addComponent(cartbtn)
                    .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        // TODO add your handling code here:
        this.frame.dispose();
        LoginJFrame lf = new LoginJFrame();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void cartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartbtnActionPerformed
        // TODO add your handling code here:
        CartJFrame frame = new CartJFrame(this.system, this.account, net);
        frame.setSize(500, 620);
        frame.setLocationRelativeTo(null);
        //        frame.setUndecorated(true);
        //        AWTUtilities.setWindowOpaque(frame, false);
        //        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.setVisible(true);
    }//GEN-LAST:event_cartbtnActionPerformed

    private void namelabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namelabelMouseClicked
        // TODO add your handling code here:
        CustomerProfileJPanel panel = new CustomerProfileJPanel(this.system, this.container, this.account, this.frame, new CustomerRole(),this.net);
        this.container.add(panel);
        CardLayout layout = (CardLayout) this.container.getLayout();
        layout.next(this.container);
    }//GEN-LAST:event_namelabelMouseClicked

    private void SelectCityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectCityBtnActionPerformed
        // TODO add your handling code here:
        // citypanel = new SelectCityJPanel(this.city);
        SelectCityJPanel sj = new SelectCityJPanel(cbj,container);
//        
        btnDetail.setEnabled(true);
        CityJFrame frame = new CityJFrame(cbj);
        frame.setSize(500, 620);
        frame.setLocationRelativeTo(null);
        //        frame.setUndecorated(true);
        //        AWTUtilities.setWindowOpaque(frame, false);
        //        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.setVisible(true);
        //sj.setSize(500, 620);
        // sj.setLocationRelativeTo(null);

        //sj.setVisible(true);

    }//GEN-LAST:event_SelectCityBtnActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
            
            
            int index = HotelTable1.getSelectedRow();
            TableModel model = HotelTable1.getModel();
//            if(!citysearchfield.equals("")){}
            if(index<0){
                JOptionPane.showMessageDialog(null, "select a enterprise please");
                return ;
            }
            if (index >= 0) {
                
              //  type = (EnterpriseType) ;

            //if (type.equals(EnterpriseType.Hotel)) {
                Hotel hotel = (Hotel) model.getValueAt(index, 0);
                jTabbedPane1.setSelectedIndex(1);
                hotelnamelabel.setText(hotel.getName());
                HotelDetailsJPanel panel = new HotelDetailsJPanel(this.system, hotel, this.account, net, type);
                detailJPanel.remove(this);
                detailJPanel.add(panel);
                
                RoomDetailsJPanel panelr = new RoomDetailsJPanel(this.system, hotel, this.account, net, type);
                detailJPanel1.remove(this);
                detailJPanel1.add(panelr);
                
            //}

            CardLayout layout = (CardLayout) this.detailJPanel.getLayout();
            layout.next(detailJPanel);
            
            CardLayout layout2 = (CardLayout) this.detailJPanel1.getLayout();
            layout2.next(detailJPanel1);
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HotelTable1;
    private javax.swing.JPanel SearchJPanel;
    private javax.swing.JButton SelectCityBtn;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton cartbtn;
    public javax.swing.JTextField citysearchfield;
    private javax.swing.JPanel detailJPanel;
    private javax.swing.JPanel detailJPanel1;
    private javax.swing.JLabel hotelnamelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JLabel namelabel;
    private javax.swing.JPanel reviewJPanel;
    // End of variables declaration//GEN-END:variables
}

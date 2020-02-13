/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Customer.Customer;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import UserInterface.MainJFrame;
import UserInterface.RegisterJPanel;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author roc
 */
public class CustomerRegistrationInfoJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerRegistrationInfoJPanel
     */
    private EcoSystem system;
    private JPanel leftPanel;
    private JFrame frame;
    private String username;
    private String password;
    public CustomerRegistrationInfoJPanel(EcoSystem system, JPanel leftPanel, JFrame frame, String username, String password1) {
        initComponents();
        this.system=system;
        this.leftPanel=leftPanel;
        this.frame=frame;
        this.username=username;
        this.password=password1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstnametext = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lastnametext = new javax.swing.JTextField();
        phonetext = new javax.swing.JTextField();
        emailtext = new javax.swing.JTextField();
        submitbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("*FirstName:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("*LastName:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("*PhoneNumber:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("*Email Address:");

        submitbtn.setText("Submit");
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Please Prvoide Your Information To Finish Your Registration");

        jLabel6.setText("*Gender:");

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gender", "Male", "Famale" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submitbtn)
                                .addGap(100, 100, 100)
                                .addComponent(cancelbtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(firstnametext, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addComponent(lastnametext)
                                        .addComponent(phonetext)
                                        .addComponent(emailtext))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstnametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lastnametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phonetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitbtn)
                    .addComponent(cancelbtn))
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtnActionPerformed
        // TODO add your handling code here:
        if(firstnametext.getText().equals("")){
            JOptionPane.showMessageDialog(null, "firstname can not be empty");
            return ;
        }
        if(lastnametext.getText().equals("")){
             JOptionPane.showMessageDialog(null, "lastname can not be empty");
             return ;
        }
        if(phonetext.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "phonenumber can not be empty");
            return ;
        }
        else{
            char[]tem=phonetext.getText().toCharArray();
            for(int i=0;i<tem.length;i++){
                if(tem[i]<'0'||tem[i]>'9'){
                    JOptionPane.showMessageDialog(null,"phone number can only contains number");
                    return ;
                }
            }
        }
        if(emailtext.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "email can not be empty");
            return ;
        }
        else {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
        Pattern regex = Pattern.compile(check);  
        Matcher matcher = regex.matcher(emailtext.getText());  
        boolean isMatched = matcher.matches(); 
        if(!isMatched){
            JOptionPane.showMessageDialog(null,"Please Follow xxx@xxx.com format");
            return ;
        }
        }
        if(gender.getSelectedItem().equals("Gender")){
             JOptionPane.showMessageDialog(null, "please select your gender");
             return ;
        }
        
        Customer customer = new Customer(firstnametext.getText(), lastnametext.getText(),
        phonetext.getText(),emailtext.getText(),gender.getSelectedItem().toString());
        UserAccount ua = system.getUserAccountDirectory().CreateCustomerAccount(username, password, customer);
        //system.getUserAccountDirectory().getUserAccountList().add(ua);
        DB4OUtil.getInstance().storeSystem(system);

        this.frame.dispose();
        MainJFrame mFrame = new MainJFrame(this.system, ua, null, null);
        this.frame.dispose();
        mFrame.setVisible(true);
        mFrame.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_submitbtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        // TODO add your handling code here:
        this.frame.setSize(250, 460);
        RegisterJPanel rp = new RegisterJPanel(this.system, this.leftPanel, this.frame);
        this.leftPanel.add("RegisterJPanel", rp);
        CardLayout layout = (CardLayout) this.leftPanel.getLayout();
        leftPanel.remove(this);
        layout.next(this.leftPanel);
    }//GEN-LAST:event_cancelbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JTextField emailtext;
    private javax.swing.JTextField firstnametext;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lastnametext;
    private javax.swing.JTextField phonetext;
    private javax.swing.JButton submitbtn;
    // End of variables declaration//GEN-END:variables
}

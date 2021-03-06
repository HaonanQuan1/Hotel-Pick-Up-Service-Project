/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemManager;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.UserAccount.CustomerAccount;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author quanhaonan
 */
public class EditCustomer extends javax.swing.JPanel {

    /**
     * Creates new form EditCustomer
     */

    private EcoSystem system;
    private JPanel customerworkarea;
    private CustomerAccount ca;
    private SystemManagerMainJPanel mng;
    public EditCustomer(EcoSystem system, JPanel customerworkarea, CustomerAccount ca, SystemManagerMainJPanel mng) {
        initComponents();
        this.system=system;
        this.ca=ca;
        this.customerworkarea=customerworkarea;
        this.mng=mng;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernametext = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        password2 = new javax.swing.JPasswordField();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel7.setText("email:");

        jLabel6.setText("Phone:");

        jLabel5.setText("Lastname:");

        jLabel4.setText("Firstname:");

        jLabel3.setText("Confirmpassword:");

        jLabel2.setText("Password:");

        jLabel1.setText("Username:");

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(530, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(30, 30, 30))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(180, 180, 180)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addGap(80, 80, 80)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(firstname)
                        .addComponent(usernametext)
                        .addComponent(lastname)
                        .addComponent(phone)
                        .addComponent(email)
                        .addComponent(password1)
                        .addComponent(password2))
                    .addGap(183, 183, 183)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(usernametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(password2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String username=usernametext.getText();
        char[] p=password1.getPassword();
        String password1=String.valueOf(p);
        char[]p1=password2.getPassword();
        String password2=String.valueOf(p1);
        String firstname=this.firstname.getText();
        String last=lastname.getText();
        String phoneString=phone.getText();
        String emailString=email.getText();
        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "username can not be empty");
            return ;
        }else{
            for(UserAccount ua:system.getUserAccountDirectory().getUserAccountList()){
                if(ua instanceof CustomerAccount){
                    CustomerAccount da=(CustomerAccount)ua;
                    if(ca.getUsername().equals(ua.getUsername())){
                        JOptionPane.showMessageDialog(null, "Username already existed");
                    }
                }
            }
            
        }
        if(password1.equals("")||password2.equals("")){
            JOptionPane.showMessageDialog(null, "password can not be empty");
            return ;
        }if(this.firstname.getText().equals("")){ JOptionPane.showMessageDialog(null, "firstname can not be empty"); return ;}
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
        if(username.equals(ca.getUsername())&&password1.equals(ca.getPassword())&&firstname.equals(ca.getCustomer().getFirstname())&&lastname.equals(ca.getCustomer().getLastname())&&phoneString.equals(ca.getCustomer().getPhonenumber())&&emailString.equals(ca.getCustomer().getEmail()))
        {
            JOptionPane.showMessageDialog(null, "You didn't change anything");
            return ;   
        }
        }
        ca.setUsername(username);
        ca.setPassword(password2);
        ca.getCustomer().setFirstname(firstname);
        ca.getCustomer().setLastname(last);
        ca.getCustomer().setPhonenumber(phoneString);
        ca.getCustomer().setEmail(emailString);
        DB4OUtil.getInstance().storeSystem(system);
        customerworkarea.remove(this);
        mng.populatecustomer();
        CardLayout layout=(CardLayout)customerworkarea.getLayout();
        layout.previous(customerworkarea);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                customerworkarea.remove(this);
        mng.populatecustomer();
        CardLayout layout=(CardLayout)customerworkarea.getLayout();
        layout.previous(customerworkarea);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lastname;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField usernametext;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public class CustomerDir {
    private ArrayList<Customer> custdir;
    
    public CustomerDir(){
        custdir=new ArrayList<>();
        
    }

    public ArrayList<Customer> getCustdir() {
        return custdir;
    }
    public void addCustomer(String firstname,String lastname, String phonenumber, String email, String gender){
        Customer cu=new Customer(firstname,lastname,phonenumber,email,gender);
        cu.setName(firstname,lastname);
//        cu.setEmail(email);
//        cu.setPhone(phonenumer);
//        customer.setAddress(address);
        custdir.add(cu);
    }
    public Customer createCustomer(String firstname,String lastname, String phonenumber, String email, String gender){
        Customer cu=new Customer(firstname,lastname,phonenumber,email,gender);
        custdir.add(cu);
        return cu;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Customer.Cart;
import Business.Customer.Customer;
import Business.Role.CustomerRole;
import Business.Role.Role;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import java.math.BigDecimal;

/**
 *
 * @author quanhaonan
 */
public class CustomerAccount extends UserAccount{
    private Customer customer;
    private Cart cart;
    public CustomerAccount(String username, String password, Customer customer) {
        super(username, password, new CustomerRole());
        this.customer=customer;
        this.cart=new Cart();
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart getCart() {
        return cart;
    }
    @Override
    public String toString(){
    return this.getCustomer().getName();
}
    
//     public double getTotalPurchased() {
//        double result = 0;
//        if (!this.getWorkQueue().getWorkRequestList().isEmpty()) {
//            for (WorkRequest wr : this.getWorkQueue().getWorkRequestList()) {
//                OrderRequest or = (OrderRequest) wr;
//                if (or.getStatus().equals(WorkRequest.StatusEnum.Completed)) {
//                    result = result + or.getAmount();
//                }
//            }
//        }
//        BigDecimal bd = new BigDecimal(result);
//        return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//    }
    
    
}

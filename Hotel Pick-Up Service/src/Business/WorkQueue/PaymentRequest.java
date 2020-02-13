/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author quanhaonan
 */
public class PaymentRequest extends WorkRequest{
    private StatusEnum status;
    private OrderRequest order;
    private UserAccount user;
    public PaymentRequest(Enterprise enterprise, UserAccount account, OrderRequest order) {
        super(enterprise, account);
        this.order=order;
        this.user=account;
    }
    
    public void ReduceMoney(){
        for(int i=0;i<order.getRoomlist().size();i++){
            user.setMoney(user.getMoney()-(order.getRoomlist().get(i).getPrice()*order.getRoomlist().get(i).getQuantatity()));
        }
    }
    
    
    
}

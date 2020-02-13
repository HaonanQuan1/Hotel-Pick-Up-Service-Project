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
public class TransportRequest extends WorkRequest{
    private OrderRequest or;
    private StatusEnum status;
    private Date pickupTime;
    private Date checkinTime;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String customername;
    private String customerphone;
    private Enterprise location;
    
    public TransportRequest(Enterprise enterprise, UserAccount account,OrderRequest or) {
        super(enterprise, account);
        this.or=or;
    }

    public OrderRequest getOr() {
        return or;
    }
    public String getOrId(){
        return this.or.getId();
    }
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getPickupTime() {
         return this.format.format(pickupTime);
    }

    public void setPickupTime(String pickupTime) {
        this.format.format(pickupTime);
    }

    public String getCheckinTime() {
         return this.format.format(checkinTime);
    }

    public void setCheckinTime(String checkinTime) {
        this.format.format(checkinTime);
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public Enterprise getLocation() {
        return location;
    }

    public void setLocation(Enterprise location) {
        this.location = location;
    }
    
    
    @Override
    public String toString() {
        return this.or.getRequestDate();
    }
}

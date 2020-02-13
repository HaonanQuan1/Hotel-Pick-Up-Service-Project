/*
 * To change this template, choose Tools | Templates
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
public abstract class WorkRequest {

    private String message;
    private Enterprise enterprise;
    private UserAccount account;
    private Enum status;
    private Date requestDate;
    private Date resolveDate;
    
    public WorkRequest(Enterprise enterprise, UserAccount account){
        this.enterprise=enterprise;
        this.account=account;
       // this.requestDate=new Date();
        this.requestDate = new Date();
    }
       public enum StatusEnum {

        Processing("Processing"),
        WaitForCheckin("Waiting for checkin"),
        pickupcustomer("go to pick up customer"),
        //OnTheWay("On the way"),
        Cancelled("Cancelled"),
        Completed("Completed");

        private String value;

        private StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise, UserAccount account) {
        this.enterprise = enterprise;

    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }



    public String getRequestDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(this.requestDate);
        return dateString;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
}

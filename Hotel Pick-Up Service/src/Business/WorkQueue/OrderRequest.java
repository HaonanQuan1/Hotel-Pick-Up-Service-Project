/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.ItemOrder;
import Business.Enterprise.Enterprise;
import Business.Enterprise.TravelCompany.TravelCompany;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author quanhaonan
 */
public class OrderRequest extends WorkRequest{
    private String id;
    private String customername;
    private String customerphone;
    // private String customeremail;
    private int peoplein;
    private StatusEnum Statusenum;
    private String Identitynumber;
    private ArrayList<ItemOrder> roomlist;
    private ReviewRequest review;
    private int roomnumber;
    private PaymentRequest payment;
    private int rate;
    private String pickup;

    private double amount;
    private StatusEnum status;
    private TravelCompany tc;
    
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String genId(){
         String orderId
                = (System.currentTimeMillis() + "").substring(1)
                + (System.nanoTime() + "").substring(7, 10);
        return orderId;
    }
    
    public OrderRequest(Enterprise enterprise, UserAccount user,ArrayList<ItemOrder> roomlist ){
        super(enterprise,user);
        this.roomlist=roomlist;
        this.id=this.genId();
        this.review=null;
        this.payment=null;
        this.rate=-1;
        
    }
        public enum ReviewStatus {

        NA("N/A"),
        reviewed("Reviewed"),
        not("Not Reviewed");

        private String value;

        private ReviewStatus(String value) {
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

    public String getIdentitynumber() {
        return Identitynumber;
    }

    public void setIdentitynumber(String Identitynumber) {
        this.Identitynumber = Identitynumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public int getPeoplein() {
        return peoplein;
    }

    public void setPeoplein(int peoplein) {
        this.peoplein = peoplein;
    }

    public ArrayList<ItemOrder> getRoomlist() {
        return roomlist;
    }

    public void setRoomlist(ArrayList<ItemOrder> roomlist) {
        this.roomlist = roomlist;
    }

    public StatusEnum getStatusenum() {
        return Statusenum;
    }

    public void setStatusenum(StatusEnum Statusenum) {
        this.Statusenum = Statusenum;
    }
    
    public ReviewRequest getReview(){
        return this.review;
    }
    public void setReview(ReviewRequest review){
        this.review=review;
    }
    
    public boolean isReviewed() {
        if (this.review == null) {
            return false;
        } else {
            if (this.review.getRate() == -1) {
                return false;
            }
        }
        return true;
    }

    public TravelCompany getTc() {
        return tc;
    }

    public void setTc(TravelCompany tc) {
        this.tc = tc;
    }
    
    public boolean isReadyToReview(){
        if(this.review==null){
            return false;
        }else{
            if(this.review.getRate()==-1){
                return true;
            }
        }
        return false;
    }
    public ReviewStatus getReviewStatus() {
        if(isReadyToReview()) {
            return ReviewStatus.not;
        }
        if (isReviewed()) {
            return ReviewStatus.reviewed;
        } else {
            return ReviewStatus.NA;
        }
    }
public StatusEnum getStatus(){
    return status;
}
public void setStatus(StatusEnum status){
    this.status=status;
}
//    public boolean isPaid(){
//        if(this.payment!=null){
//            if(payment.getStatus().equals("completed")) return true;
//        }
//        return false;
//    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return this.getRequestDate();
    }
    public int getRate() {
        return this.rate;
    }
    public void setRate(int rate){
        this.rate=rate;
    }
}

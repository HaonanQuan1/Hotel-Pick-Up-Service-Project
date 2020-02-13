/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.TransportRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public abstract class Model extends Enterprise{
    private String name;
    private String address;
    private String description;
    private EnterpriseType type;
    private String phonenumber;
    private ArrayList<Item> itemlist;
    
    public enum EnterpriseType{
        
        Hotel("Hotel")
       ;
      

        private String value;

        private EnterpriseType(String value) {
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
    public Model(String name, String address, String phonenumber){
        super(name);
        this.name=name;
        this.address=address;
        this.phonenumber=phonenumber;
        this.itemlist=new ArrayList<>();
        
    }
        public double getRate(WorkQueue wq){
        double rate=0;
        int num=0;
        for(WorkRequest wr:wq.getWorkRequestList()){
            if(wr instanceof TransportRequest)continue;
            if(wr.getEnterprise()!=this)continue;
            OrderRequest or=(OrderRequest) wr;
            if(or.isReviewed()){
                rate+=or.getReview().getRate();
                num++;
            }
        }
        if(num==0) return -1;
        BigDecimal bd = new BigDecimal(rate / num);
        return bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract EnterpriseType getType();

    public void setType(EnterpriseType type) {
        this.type = type;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public ArrayList<Item> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<Item> itemlist) {
        this.itemlist = itemlist;
    }
    
    public abstract String getCategoryString();
    
    @Override
    public String toString() {
        return this.name;
    }


    
}

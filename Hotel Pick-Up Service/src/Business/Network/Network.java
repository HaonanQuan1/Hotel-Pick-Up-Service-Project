/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.TravelCompany.TravelCompany;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author quanhaonan
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private WorkQueue workqueue;
    private String city;
    private String id;
    private static  int counter=0;

    public Network(String city) {
        enterpriseDirectory=new EnterpriseDirectory();
        workqueue=new WorkQueue();
       // this.workqueulist=new HashMap<>();
       this.city=city;
       this.id="network"+counter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
    public WorkQueue getWorkqueue() {
        return workqueue;
    }

    public void setWorkqueue(WorkQueue workqueue) {
        this.workqueue = workqueue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Network.counter = counter;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    @Override
    public String toString(){
        return this.city;
    }

    public Hotel createHotel(String name, String address, String phone) {
        Hotel enter = new Hotel(name,address, phone);
        enter.creatOrganization();
        this.enterpriseDirectory.getEnterpriseList().add(enter);
        return enter;
    }
    
    public TravelCompany createTravelCompany(String name, String address, String phone) {
        TravelCompany res = new TravelCompany(name,phone,address);
        res.creatOrganization();
        this.enterpriseDirectory.getEnterpriseList().add(res);
        return res;
    }
    
//    public Store createStore(String name, String address, String phone) {
//        Store store = new Store(name, address, phone);
//        store.createOrganizations();
//        this.enterpriseDir.getEnterpriseList().add(store);
//        return store;
    //}
    public ArrayList<Hotel> getHotellist(){
        ArrayList<Hotel> result=new ArrayList<>();
        for (Enterprise en:this.enterpriseDirectory.getEnterpriseList()) {
            if (en instanceof Hotel) {
                Hotel store = (Hotel) en;
                result.add(store);
            }
        }
        return result;
    }
    public ArrayList<TravelCompany> getTravelCompanylist(){
        ArrayList<TravelCompany> result=new ArrayList<>();
        for (Enterprise en:this.enterpriseDirectory.getEnterpriseList()) {
            if (en instanceof TravelCompany) {
                TravelCompany store = (TravelCompany) en;
                result.add(store);
            }
        }
        return result;
    }
}

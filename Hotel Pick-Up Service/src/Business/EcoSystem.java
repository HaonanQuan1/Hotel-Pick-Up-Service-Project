/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.CustomerDir;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private CustomerDir customers;
    public static EcoSystem getInstance(){
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }
    private EcoSystem(){
        super(null);
        this.networkList=new ArrayList<Network>();
        this.customers=new CustomerDir();
    }
    //public UserAccountDirectory getUserAccount
    public Network createAndAddNetwork(String name){
        Network network=new Network(name);
        networkList.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }


//    public static EcoSystem getBusiness() {
//        return business;
//    }
//
//    public static void setBusiness(EcoSystem business) {
//        EcoSystem.business = business;
//    }

    public CustomerDir getCustomers() {
        return customers;
    }

    public void setCustomers(CustomerDir customers) {
        this.customers = customers;
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    public void removeNetwork(Network net) {
        Network result = null;
        if (!this.networkList.isEmpty()) {
            for (Network n : networkList) {
                if (net.getId().equalsIgnoreCase(n.getId())) {
                    result = n;
                }
            }
            networkList.remove(result);
        }
    }
    public Network getNetworkByCity(String city) {
        for (Network net : this.networkList) {
            if (net.getCity().equals(city)) {
                return net;
            }
        }
        return null;
    }
        public Enterprise getEnterpriseById(String id) {
        for (Network net : this.networkList) {
            for (Enterprise en : net.getEnterpriseDirectory().getEnterpriseList()) {
                if(en.getId().equals(id)) {
                    return en;
                }
            }
        }
        return null;
    }
    public boolean isCityAvabliable(String city) {
        for (Network net : this.networkList) {
            if (net.getCity().equalsIgnoreCase(city)) {
                return false;
            }
        }
        return true;
    }
        public UserAccount getCustomerAccountByUsername(String username) {
        for(UserAccount account:this.getUserAccountDirectory().getUserAccountList()) {
            if(account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }
    public boolean checkIfUserIsUnique(String username){
        if (this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            for (Network net : this.networkList) {
                for (Enterprise en : net.getEnterpriseDirectory().getEnterpriseList()) {
                    if (en.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
                        for (Organization or : en.getOrganizationDirectory().getOrganizationList()) {
                            if (!or.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
                                return false;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
}

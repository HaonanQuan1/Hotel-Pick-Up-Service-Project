/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        this.userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equalsIgnoreCase(username)&& ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
//    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
//        UserAccount userAccount = new UserAccount();
//        userAccount.setUsername(username);
//        userAccount.setPassword(password);
//        userAccount.setEmployee(employee);
//        userAccount.setRole(role);
//        userAccountList.add(userAccount);
//        return userAccount;
//    }
    
    
    
    public boolean checkIfUsernameIsUnique(String username){
        if (userAccountList.isEmpty()) {
            return true;
        }
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equalsIgnoreCase(username))
                return false;
        }
        return true;
    }
    
    public EmployeeAccount CreateEmployeeAccount(String username, String password, Role role, Employee ee){
        EmployeeAccount ua=new EmployeeAccount(username,password,role,ee);
        userAccountList.add(ua);
        return ua;
        
    }
    public CustomerAccount CreateCustomerAccount(String username, String password, Customer customer){
        CustomerAccount ca=new CustomerAccount(username,password,customer);
        userAccountList.add(ca);
        return ca;
    }
       public void addAccount(UserAccount account) {
        userAccountList.add(account);
    }

    public ArrayList<EmployeeAccount> getEmployeeAccount() {
        ArrayList<EmployeeAccount> result = new ArrayList<>();
        for (UserAccount ua : this.userAccountList) {
            if(ua instanceof CustomerAccount) continue;
//            if(ua.getRole().equals(RoleType.SystemManager)) continue;
            EmployeeAccount ea = (EmployeeAccount) ua;
            result.add(ea);
        }
        return result;
    }

    public ArrayList<UserAccount> searchCustomerByOverall(String key) {
        ArrayList<UserAccount> result = new ArrayList<>();
        if (!userAccountList.isEmpty()) {
            for (UserAccount u : this.userAccountList) {
                if (u instanceof CustomerAccount) {
                    CustomerAccount c = (CustomerAccount) u;
                    if (c.getUsername().toLowerCase().contains(key.toLowerCase())) {
                        if(!result.contains(c)) {
                            result.add(c);
                        }
                    }
                    if (c.getCustomer().getName().toLowerCase().contains(key.toLowerCase())) {
                        if(!result.contains(c)) {
                            result.add(c);
                        }
                    }
                    if (c.getCustomer().getPhonenumber().toLowerCase().contains(key.toLowerCase())) {
                        if(!result.contains(c)) {
                            result.add(c);
                        }
                    }
                    if (c.getCustomer().getEmail().toLowerCase().contains(key.toLowerCase())) {
                        if(!result.contains(c)) {
                            result.add(c);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public void removeAccount(UserAccount account) {
        if (this.userAccountList.contains(account)) {
            this.userAccountList.remove(account);
        }
    }


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author quanhaonan
 */
public abstract class UserAccount {
    
    private int id;
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private static int count=0;
    private double money;
//    public UserAccount() {
//        workQueue = new WorkQueue();
//    }
    public UserAccount(String username, String password, Role role){
        this.id=count;
        this.username=username;
        this.password=password;
        this.role=role;
        this.money=0;
        workQueue=new WorkQueue();
        count++;
    }

    public double getMoney() {
        return money;
    }
        public WorkQueue getWorkQueue() {
        return this.workQueue;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }



    public void setRole(Role role) {
        this.role = role;
    }



    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}
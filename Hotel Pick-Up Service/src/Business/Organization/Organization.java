/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public abstract class Organization {

    private String name;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    //private WorkQueue wq;


    public Organization(String name) {
        counter++;
        this.organizationID = counter;
        this.name = name;    
        this.employeeDirectory = new EmployeeDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
     //   this.wq=new WorkQueue();
        //System.out.print("a");
        //if(userAccountDirectory==null) System.out.print("null");
    }
    public enum Type{
        Manager("Manager Organization"),
        Staff("Driver Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
//    public WorkQueue getWorkQueue() {
//        return wq;
//    }
//
//    public void setWorkQueue(WorkQueue workQueue) {
//        this.wq= workQueue;
//    }
}

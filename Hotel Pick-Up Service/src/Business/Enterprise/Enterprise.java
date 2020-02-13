 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.Employee;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.EmployeeAccount;
import Business.UserAccount.UserAccount;

/**
 *
 * @author quanhaonan
 */
public abstract class Enterprise extends Organization{
    

    private OrganizationDirectory organizationDirectory;
    private static int idCount=0;

    public Enterprise(String name) {
        super(name);
        this.organizationDirectory=new OrganizationDirectory();
        
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    public void removeEmployeeAccount(UserAccount account){
        EmployeeAccount ac=(EmployeeAccount) account;
        Employee em=ac.getEmployee();
        
        UserAccount ac1=null;
        for(UserAccount uc : this.getUserAccountDirectory().getUserAccountList()){
            if(uc.getUsername().equalsIgnoreCase(ac.getUsername())){
                ac1=uc;
            }
        }
        if(ac1!=null) {
        this.getUserAccountDirectory().getUserAccountList().remove(ac1);
        return ;
        }
        for (Organization or : organizationDirectory.getOrganizationList()) {
            for (UserAccount ua : or.getUserAccountDirectory().getUserAccountList()) {
                if (ua.getUsername().equalsIgnoreCase(ac.getUsername())) {
                    ac1 = ua;
                }
            }
            if (ac1 != null) {
                or.getUserAccountDirectory().getUserAccountList().remove(ac1);
                return;
            }
        }
        
        
    }
        public void removeEmployee(Employee employee) {

        Employee em = null;
        for (Employee e : this.getEmployeeDirectory().getEmployeeList()) {
            if (e.getId() == employee.getId()) {
                em = e;
            }
        }
        if (em != null) {
            this.getEmployeeDirectory().getEmployeeList().remove(em);
            return;
        }
        for (Organization or : organizationDirectory.getOrganizationList()) {
            for (Employee e : or.getEmployeeDirectory().getEmployeeList()) {
                if (e.getId() == employee.getId()) {
                    em = e;
                }
            }
            if (em != null) {
                or.getEmployeeDirectory().getEmployeeList().remove(em);
                return;
            }
        }
    }
        
        public abstract String getId();
        
        public abstract void setId(String id);
        
        public abstract void creatOrganization();
        
        @Override
        public String toString() {
            return this.getName();
        }
        
        


}

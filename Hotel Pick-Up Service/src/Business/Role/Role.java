/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author quanhaonan
 */
public abstract class Role {
    private RoleType roletype;
    public enum RoleType{
        Boss("Boss"),
        Manager("Manager"),
        Customer("Customer"),
        Staff("Staff"),
        Driver("Driver"),
        SystemManager("System Manager");
       
        
        private String value;
        private RoleType(String value){
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
    
    public abstract void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise enterprise, JFrame frame);

    public RoleType getRoletype() {
        return roletype;
    }

    public Role(RoleType type){
        this.roletype=type;
    }

    @Override
    public abstract String toString();
    
    
}
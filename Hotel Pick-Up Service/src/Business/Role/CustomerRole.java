/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Customer.CustomerMainJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author quanhaonan
 */
public class CustomerRole extends Role{
    //private String role;
    public CustomerRole(){
        super(RoleType.Customer);
        
    }


    @Override
    public String toString() {
        return RoleType.Customer.getValue();
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise enterprise, JFrame frame) {
        CustomerMainJPanel cp = new CustomerMainJPanel(system, container, userAccount, frame);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
    
}

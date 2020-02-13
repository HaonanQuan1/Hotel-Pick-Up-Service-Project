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
import UserInterface.TravelCompany.driver.StaffMainJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author quanhaonan
 */
public class DriverRole extends Role{

    public DriverRole() {
        super(Role.RoleType.Driver);
    }
    


    @Override
    public String toString() {
        return Role.RoleType.Staff.getValue();
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise enterprise, JFrame frame) {
        StaffMainJPanel cp = new StaffMainJPanel(system, container, enterprise, net,userAccount, frame, this);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
    
}

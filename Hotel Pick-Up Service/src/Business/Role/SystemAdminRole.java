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
import UserInterface.SystemManager.SystemManagerMainJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
//import UserInterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author quanhaonan
 */
public class SystemAdminRole extends Role{

     public SystemAdminRole() {
        super(RoleType.SystemManager);
    }


    @Override
    public String toString() {
        return RoleType.SystemManager.getValue();
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise enterprise, JFrame frame) {
        SystemManagerMainJPanel cp = new SystemManagerMainJPanel(system, container, userAccount, frame);
        container.add(cp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }
    
}

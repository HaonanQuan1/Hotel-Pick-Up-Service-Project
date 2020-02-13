/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.TravelCompany.TravelCompany;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Hotel.Manager.HotelManageJPanel;
import UserInterface.TravelCompany.Manager.TravelCompanyManageJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author quanhaonan
 */
public class ManagerRole extends Role{

    public ManagerRole(){
        super(RoleType.Manager);
    }


    @Override
    public String toString() {
        return RoleType.Manager.getValue();
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise enterprise, JFrame frame) {
        if (enterprise instanceof Hotel) {
            HotelManageJPanel hm = new HotelManageJPanel(system, container, net, enterprise, userAccount, frame, this);
            container.add(hm);
        }
//        if (enterprise instanceof Payment) {
//            PaymentManageJPanel pm = new PaymentManageJPanel(system, container, net, enterprise, userAccount, frame, this);
//            container.add(pm);
//        }
        if (enterprise instanceof TravelCompany) {
            TravelCompanyManageJPanel tc = new TravelCompanyManageJPanel(system, container, net, enterprise, userAccount, frame, this);
            container.add(tc);
        }
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
        
    }
    
}

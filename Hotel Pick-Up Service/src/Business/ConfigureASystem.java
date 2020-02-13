package Business;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.Hotel.Room;
import Business.Enterprise.TravelCompany.TravelCompany;
import Business.Network.Network;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.Organization.StaffOrganization;
import Business.Role.BossRole;
import Business.Role.ManagerRole;
import Business.Role.StaffRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author quanhaonan
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        //Systemadmin belong to the system.
        
        Employee employee = system.getEmployeeDirectory().createEmployee("Haonan","Quan","8573487290","quan.h@husky.neu.edu","male");
        
        UserAccount ua1 = system.getUserAccountDirectory().CreateEmployeeAccount("sysadmin", "sysadmin", new SystemAdminRole(),employee);
        
        Customer c1 = system.getCustomers().createCustomer("2", "2", "1231231234","123@q.com","male");
        UserAccount ua2 = system.getUserAccountDirectory().CreateCustomerAccount("2", "2", c1);

        Customer c2 = system.getCustomers().createCustomer("1", "1", "1231231234","214@q.com","male");
        UserAccount ua3 = system.getUserAccountDirectory().CreateCustomerAccount("1", "1", c2);

        // MA NETWORK 
        Network network1 = system.createAndAddNetwork("Boston");
        network1.setId("Boston");
        Network network2 = system.createAndAddNetwork("Atlanta");
        network2.setId("Atlanta");

        // BOSTON Enterprise with organiztions created
        TravelCompany enter1 = network1.createTravelCompany("Avias", "91 Westland Ave, Boston, MA 02125", "(617) 553-5900");
        enter1.setDescription("This is a TravelCompany company.");
        enter1.setId("Transport");
        enter1.setPhotoPath("Images/TravelCompanny/avis.png");
        //Employee boss = enter1.getEmployeeDirectory().createEmployee("boss", "boss", "23323", "boss@com","male");
        //UserAccount bossA = enter1.getUserAccountDirectory().CreateEmployeeAccount("TravelCompany", "TravelCompany", new BossRole(), boss);
        // BOSTON Delivery Company Organization
        ManagerOrganization mo1 = (ManagerOrganization) enter1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        StaffOrganization do1 = (StaffOrganization) enter1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Staff);
        Employee employee2 = mo1.getEmployeeDirectory().createEmployee("Manager", "Manager", "111", "manager@demo.com","male");
        UserAccount ua4 = mo1.getUserAccountDirectory().CreateEmployeeAccount("tcm", "tcm", new ManagerRole(), employee2);

        Employee employee3 = mo1.getEmployeeDirectory().createEmployee("Driver1", "driver1", "1111", "932@q.com","male");
        UserAccount ua5 = do1.getUserAccountDirectory().CreateEmployeeAccount("tcd", "tcd", new StaffRole(), employee3);

        Employee employee4 = do1.getEmployeeDirectory().createEmployee("Driver1", "driver1", "1111", "421@q.com","male");
        UserAccount ua8 = do1.getUserAccountDirectory().CreateEmployeeAccount("tcdd", "tcdd", new StaffRole(), employee4);

        // BOSTON Hotel List
        Hotel hot1 = network1.createHotel("Hilton", "89 Broad St, Boston, MA 02110", "(617) 556-0006");
        //hot1.setCategory(Hotel.roo);
        hot1.setId("Hilton");
        hot1.setPhotoPath("Images/Hotel/hilton.png");
        hot1.setDescription("5 Star Hotel");
        Room dash1 = new Room("Room1",20,hot1);
        Room dash2 = new Room("Room2",80,hot1);
        Room dash3 = new Room("Room3",90.2,hot1);
        hot1.addRoom(dash1);
        hot1.addRoom(dash2);
        hot1.addRoom(dash3);
        
//        Employee b1 = hot1.getEmployeeDirectory().createEmployee("Hilton", "Boss", "12344", "boss@row34.com","male");
//        UserAccount ba1 = hot1.getUserAccountDirectory().CreateEmployeeAccount("row34", "row34", new BossRole(), b1);
        
        ManagerOrganization mo2 = (ManagerOrganization) hot1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        //StaffOrganization sf1 = (StaffOrganization) enter1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Staff);

        Employee em1 = mo2.getEmployeeDirectory().createEmployee("Manager", "Manager", "111", "manager@demo.com","male");
        UserAccount ua6 = mo2.getUserAccountDirectory().CreateEmployeeAccount("hm", "hm", new ManagerRole(), em1);
        //Employee employee10=sf1.getEmployeeDirectory().createEmployee("jj", "as", "823845", "82@qq.com", "male");
        //UserAccount sfa=sf1.getUserAccountDirectory().CreateEmployeeAccount("hs","hs", new StaffRole(), employee10);
       
        Hotel res2 = network1.createHotel("Le Meridien", "20 Sidney St, Cambridge, MA 02139", "(617) 577-0200");
      //  res2.setCategory(Hotel.HotelCategory.Seafood);
        res2.setId("legal");
        res2.setPhotoPath("Images/Hotel/cambridge.png");
        res2.setDescription("Cambridge 4 star hotel");
        Room d1 = new Room("Room1",20,hot1);
        Room d2 = new Room("Room1",21.3,hot1);
        Room d3 = new Room("Room1",11.3,hot1);
        res2.addRoom(d1);
        res2.addRoom(d2);
        res2.addRoom(d3);
        
//        Employee e = res2.getEmployeeDirectory().createEmployee("Legal", "Boss", "222", "boss@demo.com","male");
//        UserAccount ee = res2.getUserAccountDirectory().CreateEmployeeAccount("legal", "legal", new BossRole(), e);
        
        ManagerOrganization mo3 = (ManagerOrganization) res2.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
        Employee em2 = mo3.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com","male");
        UserAccount ua7 = mo3.getUserAccountDirectory().CreateEmployeeAccount("cm", "cm", new ManagerRole(), em2);

        // Boston Store List
//        Store store1 = network1.createStore("Whole Foods", "15 Westland Ave, Boston, MA 02115", "(617) 375-1010");
//        store1.setId("whole");
//        store1.setPath("Images/StoreCut/default.png");
//        store1.setCategory(Store.StoreCategory.Organic);
//        store1.setDescription("Eco-minded chain with natural & organic grocery items, housewares & other products.");
//        Product p1 = new Product(store1, "Cookie", 2);
//        Product p2 = new Product(store1, "Coke", 2.5);
//        Product p3 = new Product(store1, "Water", 1);
//        Product p4 = new Product(store1, "fork", 6);
//        store1.addProductToList(p1);
//        store1.addProductToList(p2);
//        store1.addProductToList(p3);
//        store1.addProductToList(p4);
//        
//        Employee se1 = store1.getEmployeeDirectory().createEmployee("Whole", "Foods", "222", "boss@demo.com");
//        UserAccount sa1 = store1.getUserAccountDirectory().createEmployeeAccount("whole", "whole", new BossRole(), e);
//        
//        ManagerOrganization mo4 = (ManagerOrganization) store1.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
//        Employee se2 = mo4.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com");
//        UserAccount sa2 = mo4.getUserAccountDirectory().createEmployeeAccount("wm", "wm", new ManagerRole(), em2);
        
        
        // Atlanta Hotel List
//        Hotel res = network2.createHotel("Home grown GA Hotel", "968 Memorial Dr SE, Atlanta, GA 30316", "(404) 222-0455");
//       // res.setCategory(Hotel.HotelCategory.American);
//        res.setId("home");
//        res.setPhotoPath("Images/HotelCut/default.png");
//        res.setDescription("Laid-back eatery serving locally sourced breakfast & Southern fare in a retro country-diner setting.");
//        Room da1 = new Room("Room1",99.2,hot1);
//        Room da2 = new Room("Room1",10.2,hot1);
//        Room da3 = new Room("Room1",21.3,hot1);
//        res.addRoom(da1);
//        res.addRoom(da2);
//        res.addRoom(da3);
//        
//        Employee he = res.getEmployeeDirectory().createEmployee("Home Grown", "Boss", "222", "boss@demo.com","male");
//        UserAccount hee = res.getUserAccountDirectory().CreateEmployeeAccount("home", "home", new BossRole(), he);
//        
//        ManagerOrganization hmo3 = (ManagerOrganization) res.getOrganizationDirectory().getTypicalOrganization(Organization.Type.Manager);
//        Employee hem2 = hmo3.getEmployeeDirectory().createEmployee("Manager", "Manager", "222", "manager@demo.com","male");
//        UserAccount hua7 = hmo3.getUserAccountDirectory().CreateEmployeeAccount("hm", "hm", new ManagerRole(), hem2);
// 
        return system;
    }
    
}

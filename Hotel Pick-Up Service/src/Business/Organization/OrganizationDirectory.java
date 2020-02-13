/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        this.organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return this.organizationList;
    }
    
//    public Organization createOrganization(Type type){
//        Organization organization = null;
//        if (type.getValue().equals(Type.Manager.getValue())){
//            organization = new ManagerOrganization();
//            organizationList.add(organization);
//        }
//        else if (type.getValue().equals(Type.Staff.getValue())){
//            organization = new StaffOrganization();
//            organizationList.add(organization);
//        }
//        return organization;
//    }
    
        public Organization getTypicalOrganization(Type type) {
        if (type.equals(Type.Staff)) {
            for (Organization or:this.organizationList) {
                if (or.getName().equalsIgnoreCase(Type.Staff.getValue())) {
                    return or;
                }
            }
        }
        if (type.equals(Type.Manager)) {
            for (Organization or:this.organizationList) {
                if (or.getName().equalsIgnoreCase(Type.Manager.getValue())) {
                    return or;
                }
            }
        }
        return null;
    }
}
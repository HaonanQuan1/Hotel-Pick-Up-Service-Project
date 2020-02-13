/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.TravelCompany.TravelCompany;

/**
 *
 * @author quanhaonan
 */
public class EnterpriseProduce {
        public static Enterprise createEnterprise(String name, String address, String phone, String description, String type) {
        if (type.equalsIgnoreCase("Hotel")) {
            Hotel r = new Hotel(name, address, phone);
            r.setDescription(description);
            r.creatOrganization();
            return r;
        }

        if (type.equalsIgnoreCase("TravelComopany")) {
           TravelCompany tc=new TravelCompany(name,address,phone);
           tc.setDescription(description);
           tc.creatOrganization();
           return tc;
        }
        return null;
    }
}

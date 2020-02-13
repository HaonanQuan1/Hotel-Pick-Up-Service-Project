/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    public void removeEnterprise(Enterprise enterprise){
        Enterprise e=null;
        if(!enterpriseList.isEmpty()){
            for(Enterprise en:enterpriseList){
                if(en.getId().equalsIgnoreCase(enterprise.getId())){
                    e=en;
                }
            }
            if(e!=null) enterpriseList.remove(e);
        }
    }


}

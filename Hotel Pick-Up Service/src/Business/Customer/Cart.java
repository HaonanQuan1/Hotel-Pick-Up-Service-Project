/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

//import Business.Enterprise.Item;
import java.util.ArrayList;

/**
 *
 * @author quanhaonan
 */
public class Cart {
    private ArrayList<ItemOrder>itemlist;
    
    private double totalprice;
    
    public Cart(){
        itemlist=new ArrayList<>();
    }
   
    public double getTotalprice(){
        totalprice=0;
        for(ItemOrder item:itemlist){
            totalprice+=item.getPrice();
        }
        return totalprice;
    }
    public void addItem(ItemOrder order){
        itemlist.add(order);
    }
    
    public boolean isCartEmpty() {
        return itemlist.isEmpty();
    }
    
    public void clearCart(){
        this.itemlist = new ArrayList<>();
    }

    public ArrayList<ItemOrder> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<ItemOrder> itemlist) {
        this.itemlist = itemlist;
    }
    
    
}

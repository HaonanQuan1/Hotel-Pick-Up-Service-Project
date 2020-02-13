/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Enterprise.Item;
import Business.Enterprise.Model;
import java.math.BigDecimal;

/**
 *
 * @author quanhaonan
 */
public abstract class ItemOrder {
    private double price;
  //  private String name;
    private Item item;
    private Model model;
    private int quantatity;
            
    public ItemOrder(int quantatity, Item item, Model model){
        this.item=item;
        this.model=model;
        this.quantatity=quantatity;
    }

    public double getPrice() {
        BigDecimal bd = new BigDecimal(item.getPrice() * quantatity);
        this.price = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return this.price;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public abstract Model getModel();


    public int getQuantatity() {
        return quantatity;
    }

    public void setQuantatity(int q) {
        this.quantatity = q;
//        BigDecimal bd = new BigDecimal(item.getPrice() * q);
//        this.price = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    @Override
    public String toString(){
        return item.getName();
    }
    
    
        
    
}

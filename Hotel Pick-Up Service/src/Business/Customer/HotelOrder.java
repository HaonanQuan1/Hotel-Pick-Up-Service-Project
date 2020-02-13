/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Enterprise.Hotel.Hotel;
import Business.Enterprise.Item;
import Business.Enterprise.Model;
import static Business.Enterprise.Model.EnterpriseType.Hotel;

/**
 *
 * @author quanhaonan
 */
public class HotelOrder extends ItemOrder{
    private Hotel hotel;

    public HotelOrder(int quantatity, Item item, Model model) {
        super(quantatity, item, model);
        this.hotel=(Hotel)model;
    }

    @Override
    public Model getModel() {
        return this.hotel;
    }
    
    public Hotel getHotel(){
        return (Hotel)this.getModel();
    }
    
}

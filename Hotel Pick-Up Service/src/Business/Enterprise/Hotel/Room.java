/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Hotel;

import Business.Enterprise.Item;

/**
 *
 * @author quanhaonan
 */
public class Room extends Item{
    private Hotel hotel;

    public Room(String name, double price, Hotel hotel) {
        super(name, price);
        this.hotel=hotel;
    }

    public Hotel getHotel() {
        return this.hotel;
    }
    
}

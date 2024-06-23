/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.library.model;

/**
 *
 * @author marys
 */
public class Rental {
    private Item item;
    private Customer customer;
    
    public Rental(Item item, Customer customer){
        this.item = item;
        this.customer = customer;
    }
    
    public Item getItem(){
        return item;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
}

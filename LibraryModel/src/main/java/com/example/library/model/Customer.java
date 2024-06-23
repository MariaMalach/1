/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.library.model;

/**
 *
 * @author marys
 */
public class Customer {
    private String name;
    private String lastName;
    private int age;
    
    public Customer(String name, String lastName, int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
             
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastName(){
        return lastName;
        
    }
    
    public int getAge(){
        return age;
    }
}

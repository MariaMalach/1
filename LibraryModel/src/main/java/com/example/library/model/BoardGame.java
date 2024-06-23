/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.library.model;

/**
 *
 * @author marys
 */
public class BoardGame implements Item{
    private String name;
    private int minAge;
    private int maxAge;
    
    public BoardGame(String name,int minAge,int maxAge){
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public int getMinAge(){
        return minAge;
    }
    
    public int getMaxAge(){
        return maxAge;
    }
}

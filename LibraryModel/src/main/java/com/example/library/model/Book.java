/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.library.model;

/**
 *
 * @author marys
 */
public class Book implements Item{
    private String name;
    private String author;
    private int minAge;
    
    public Book(String name,String author, int minAge){
        this.name = name;
        this.author = author;
        this.minAge = minAge;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    public String getAuthor(){
        return author;
    }
    
    @Override
    public int getMinAge(){
        return minAge;
    }
}

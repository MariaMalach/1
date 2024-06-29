/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taskmanager.podroz;

/**
 *
 * @author marys
 */
public class Miasto {
    String nazwa;
    String wJakimKraju;
    boolean czyStolica;
    boolean czyOdwiedzone;
    
    Miasto(String nazwa,
    String wJakimKraju,
    boolean czyStolica,
    boolean czyOdwiedzone){
        this.czyOdwiedzone = czyOdwiedzone;
        this.czyStolica = czyStolica;
        this.nazwa = nazwa;
        this.wJakimKraju = wJakimKraju;
    }
    
     public void setNazwa(String nazwa) {
        if (nazwa != null && nazwa.length() <= 120) {
            this.nazwa = nazwa;
        } else {
            throw new IllegalArgumentException("Nazwa może mieć maksymalnie 120 znaków.");
        }
    }
     
     public void setWJakimKraju(String wJakimKraju) {
        if (wJakimKraju != null && wJakimKraju.length() <= 120) {
            this.wJakimKraju = wJakimKraju;
        } else {
            throw new IllegalArgumentException("Nazwa w jakim kraju znajduje sie miasto może mieć maksymalnie 120 znaków.");
        }
     }
        
            public String getNazwa() {
                return nazwa;
            }
             public boolean getCzyOdwiedzone() {
                return czyOdwiedzone;
            }
              public String getWjakimKraju() {
                return wJakimKraju;
            }
            public boolean getCzyStolica() {
            return czyStolica;
            }
    
}

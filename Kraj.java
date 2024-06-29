/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.taskmanager.podroz;

/**
 *
 * @author marys
 */
public class Kraj {
    String nazwa;
    boolean czyWUE;
    private String waluta;
    boolean czyOdwiedzone;
    Kraj(String nazwa, boolean czyWUE, String waluta, boolean czyOdwiedzone){
        this.czyOdwiedzone = czyOdwiedzone;
        this.czyWUE = czyWUE;
        this.nazwa = nazwa;
        this.waluta = waluta;
    }

    public void setWaluta(String waluta) {
        if (waluta != null && waluta.length() <= 3) {
            this.waluta = waluta;
        } else {
            throw new IllegalArgumentException("Waluta może mieć maksymalnie 3 znaki.");
        }
    }

    public String getWaluta() {
        return waluta;
    }
     public boolean getCzyOdwiedzone() {
        return czyOdwiedzone;
    }
      public String getNazwa() {
        return nazwa;
    }
       public boolean getCzyWUE() {
        return czyWUE;
    }
}

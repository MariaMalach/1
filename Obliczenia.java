package com.example.taskmanager.podroz;

import java.util.ArrayList;
import java.util.List;

public class Obliczenia {
    private final List<Miasto> listaMiast = new ArrayList<>();
    private final List<Kraj> listaKrajow = new ArrayList<>();

    public int liczKraje() {
        return listaKrajow.size();
    }

    public int liczMiasta() {
        return listaMiast.size();
    }

    public int liczStolice() {
        return (int) listaMiast.stream()
                               .filter(miasto -> miasto.getCzyStolica())
                               .count();
    }

    public void dodajMiasto(Miasto miasto) {
        listaMiast.add(miasto);
    }

    public void dodajKraj(Kraj kraj) {
        listaKrajow.add(kraj);
    }

    public List<Miasto> getMiasta() {
        return listaMiast;
    }

    public List<Kraj> getKraje() {
        return listaKrajow;
    }
    public List<Miasto> getOdwiedzoneMiasta() {
        List<Miasto> odwiedzoneMiasta = new ArrayList<>();
        for (Miasto miasto : listaMiast) {
            if (miasto.getCzyOdwiedzone()) {
                odwiedzoneMiasta.add(miasto);
            }
        }
        return odwiedzoneMiasta;
    }

    // Metoda zwracająca listę odwiedzonych krajów
    public List<Kraj> getOdwiedzoneKraje() {
        List<Kraj> odwiedzoneKraje = new ArrayList<>();
        for (Kraj kraj : listaKrajow) {
            if (kraj.getCzyOdwiedzone()) {
                odwiedzoneKraje.add(kraj);
            }
        }
        return odwiedzoneKraje;
    }
}

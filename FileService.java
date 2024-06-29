package com.example.taskmanager.podroz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileService {
    
    public void zapiszRaport(String nazwaPliku, List<Miasto> miasta, List<Kraj> kraje) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku))) {
            writer.write("Raport Podróży\n");
            writer.write("=====================\n");
            writer.write("Liczba krajów: " + kraje.size() + "\n");
            writer.write("Liczba miast: " + miasta.size() + "\n");
            writer.write("Liczba stolic: " + liczStolice(miasta) + "\n");
            writer.write("=====================\n");

            writer.write("Lista miast:\n");
            for (Miasto miasto : miasta) {
                writer.write("Nazwa: " + miasto.getNazwa() + ", Kraj: " + miasto.getWjakimKraju() + ", Stolica: " + miasto.getCzyStolica() + ", Odwiedzone: " + miasto.getCzyOdwiedzone() + "\n");
            }
            
            writer.write("=====================\n");
            writer.write("Lista krajów:\n");
            for (Kraj kraj : kraje) {
                writer.write("Nazwa: " + kraj.getNazwa() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku: " + e.getMessage());
        }
    }

    private int liczStolice(List<Miasto> miasta) {
        return (int) miasta.stream()
                           .filter(Miasto::getCzyStolica)
                           .count();
    }
}

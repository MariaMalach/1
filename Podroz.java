/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.example.taskmanager.podroz;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marys
 */
public class Podroz {
    static Scanner scanner = new Scanner(System.in);
    private static final Obliczenia obliczenia = new Obliczenia();
    private static final FileService fileService = new FileService();


    public static void main(String[] args) {
        while (true) {
            PokazMenu();
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1:
                    DodajMiejsce();
                    break;
                case 2:
                   wyswietlOdwiedzoneMiejsca();
                    break;
                case 3:
                    generujRaport();
                    break;
                case 4:
                  zapiszRaportDoPliku();
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }    
    }
    private static void PokazMenu() {
        System.out.println("1. Dodanie nowego miejsca do odwiedzenia");
        System.out.println("2. Wyświetlenie listy odwiedzonych miejsc");
        System.out.println("3. Wygenerowanie raportu");
        System.out.println("4. Zapis do pliku");
        System.out.println("5. Zakończenie programu");
    }
    
   private static void DodajMiejsce() {
    System.out.println("1. Podróż do kraju");
    System.out.println("2. Podróż do miasta");
    System.out.println("Wybierz opcję: ");
    int wybor = scanner.nextInt();
    scanner.nextLine(); // Skonsumuj znak nowej linii pozostawiony przez nextInt()

    switch (wybor) {
        case 1:
            dodajKraj();
            break;
        case 2:
            dodajMiasto();
            break;
        default:
            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
    }
}

private static void dodajKraj() {
    System.out.println("Podaj nazwę kraju:");
    String nazwa = scanner.nextLine();

    System.out.println("Podaj walutę kraju (max 3 znaki):");
    String waluta = scanner.nextLine();
    while (waluta.length() > 3) {
        System.out.println("Nieprawidłowa długość waluty. Podaj ponownie (max 3 znaki):");
        waluta = scanner.nextLine();
    }

    System.out.println("Czy kraj jest odwiedzony? (Tak/Nie):");
    boolean czyOdwiedzone = scanner.nextLine().equalsIgnoreCase("Tak");

    System.out.println("Czy kraj należy do WUE? (Tak/Nie):");
    boolean czyWUE = scanner.nextLine().equalsIgnoreCase("Tak");

    Kraj kraj = new Kraj(nazwa,czyWUE, waluta, czyOdwiedzone ); // Tworzymy obiekt kraju z podanymi parametrami
    obliczenia.dodajKraj(kraj); // Dodajemy kraj do listy ogol w Obliczenia
}


private static void dodajMiasto() {
    System.out.println("Podaj nazwę miasta:");
    String nazwa = scanner.nextLine();
    System.out.println("Podaj nazwę kraju, w którym się znajduje:");
    String wJakimKraju = scanner.nextLine();
    System.out.println("Czy miasto jest stolicą? (Tak/Nie):");
    boolean czyStolica = scanner.nextLine().equalsIgnoreCase("Tak");
    System.out.println("Czy miasto zostało odwiedzone? (Tak/Nie):");
    boolean czyOdwiedzone = scanner.nextLine().equalsIgnoreCase("Tak");
    Miasto miasto = new Miasto(nazwa, wJakimKraju, czyStolica, czyOdwiedzone);
    obliczenia.dodajMiasto(miasto); // Metoda do dodawania miasta do listy ogol w Obliczenia
}


     private static void generujRaport() {
        int KrajeOdwiedzone = obliczenia.liczKraje();
        int MiastaOdwiedzone = obliczenia.liczMiasta();
        int StoliceOdwiedzone = obliczenia.liczKraje();
     

        System.out.println("Ilość odwiedzonych krajów: " + KrajeOdwiedzone);
        System.out.println("Ilość odwiedzonych miast: " + MiastaOdwiedzone);
        System.out.println("Ilość odwiedzonych stolic: " + MiastaOdwiedzone);
        
    }
    private static void wyswietlOdwiedzoneMiejsca() {
        System.out.println("Odwiedzone kraje:");
        List<Kraj> odwiedzoneKraje = obliczenia.getOdwiedzoneKraje();
        if (odwiedzoneKraje.isEmpty()) {
            System.out.println("Brak odwiedzonych krajów.");
        } else {
            for (int i = 0; i < odwiedzoneKraje.size(); i++) {
                Kraj kraj = odwiedzoneKraje.get(i);
                System.out.println((i + 1) + ". Kraj: " + kraj.getNazwa() + ", Waluta: " + kraj.getWaluta() + ", Czy WUE: " + (kraj.getCzyWUE() ? "Tak" : "Nie"));
            }
        }

        System.out.println("\nOdwiedzone miasta:");
        List<Miasto> odwiedzoneMiasta = obliczenia.getOdwiedzoneMiasta();
        if (odwiedzoneMiasta.isEmpty()) {
            System.out.println("Brak odwiedzonych miast.");
        } else {
            for (int i = 0; i < odwiedzoneMiasta.size(); i++) {
                Miasto miasto = odwiedzoneMiasta.get(i);
                System.out.println((i + 1) + ". Miasto: " + miasto.getNazwa() + ", Kraj: " + miasto.getWjakimKraju() + ", Stolica: " + (miasto.getCzyStolica() ? "Tak" : "Nie"));
            }
        }
    }
     private static void zapiszRaportDoPliku() {
        System.out.println("Podaj nazwę pliku do zapisu raportu:");
        String nazwaPliku = scanner.nextLine();
        List<Miasto> miasta = obliczenia.getMiasta();
        List<Kraj> kraje = obliczenia.getKraje();
        
        fileService.zapiszRaport(nazwaPliku, miasta, kraje);
        System.out.println("Raport został zapisany do pliku: " + nazwaPliku);
    }
  
}



    


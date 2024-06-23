// LibraryApp.java
package com.example.library.service;

import com.example.library.model.*;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LibraryService libraryService = new LibraryService();
    private static final FileService fileService = new FileService();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getIntInput("Wybierz opcję: ");
            switch (choice) {
                case 1:
                    addNewRental();
                    break;
                case 2:
                    displayRentals();
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    saveRentalsToFile();
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Dodanie nowego wypożyczenia");
        System.out.println("2. Wyświetlenie listy wypożyczeń");
        System.out.println("3. Wygenerowanie raportu");
        System.out.println("4. Zapis do pliku");
        System.out.println("5. Zakończenie programu");
    }

    private static void addNewRental() {
        System.out.println("1. Wypożyczenie książki");
        System.out.println("2. Wypożyczenie gry planszowej");
        int choice = getIntInput("Wybierz opcję: ");

        System.out.print("Podaj imię klienta: ");
        String firstName = scanner.next();
        System.out.print("Podaj nazwisko klienta: ");
        String lastName = scanner.next();
        int age = getIntInput("Podaj wiek klienta: ");
        Customer customer = new Customer(firstName, lastName, age);

        Item item = null;
        switch (choice) {
            case 1:
                item = createBook();
                break;
            case 2:
                item = createBoardGame();
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        if (item != null) {
            if (age < item.getMinAge()) {
                System.out.println("Klient jest za młody, aby wypożyczyć tę pozycję.");
                return;
            }
            if (item instanceof BoardGame && age > ((BoardGame) item).getMaxAge()) {
                System.out.println("Klient jest za stary, aby wypożyczyć tę pozycję.");
                return;
            }
            libraryService.addRental(new Rental(item, customer));
        }
    }

    private static Book createBook() {
        System.out.print("Podaj nazwę książki: ");
        String name = scanner.nextLine();
        System.out.print("Podaj autora: ");
        String author = scanner.nextLine();
        int minAge = getIntInput("Podaj minimalny wiek: ");
        return new Book(name, author, minAge);
    }

    private static BoardGame createBoardGame() {
        System.out.print("Podaj nazwę gry: ");
        String name = scanner.nextLine();
        int minAge = getIntInput("Podaj minimalny wiek: ");
        int maxAge = getIntInput("Podaj maksymalny wiek: ");
        return new BoardGame(name, minAge, maxAge);
    }

    private static void displayRentals() {
        List<Rental> rentals = libraryService.getRentals();
        int index = 1;
        for (Rental rental : rentals) {
            Item item = rental.getItem();
            Customer customer = rental.getCustomer();
            System.out.println(index++ + ". " + item.getName() + ", " + (item instanceof Book ? ((Book) item).getAuthor() : "Gra planszowa") + ", " + customer.getLastName() + ", " + customer.getAge());
        }
    }

    private static void generateReport() {
        int bookCount = libraryService.countBooks();
        int boardGameCount = libraryService.countBoardGames();
        int childrenCount = libraryService.countRentalsByAgeGroup(0, 10);
        int youthCount = libraryService.countRentalsByAgeGroup(11, 17);
        int adultCount = libraryService.countRentalsByAgeGroup(18, Integer.MAX_VALUE);

        System.out.println("Ilość wypożyczonych książek: " + bookCount);
        System.out.println("Ilość wypożyczonych gier: " + boardGameCount);
        System.out.println("Ilość wypożyczeń dzieci (do lat 10): " + childrenCount);
        System.out.println("Ilość wypożyczeń młodzież (11-17 lat): " + youthCount);
        System.out.println("Ilość wypożyczeń dorosłych (18+): " + adultCount);
    }

    private static void saveRentalsToFile() {
        String filePath = "rentals.txt";  // Możesz tutaj podać pełną ścieżkę do pliku
        fileService.saveRentalsToFile(libraryService.getRentals(), filePath);
        System.out.println("Lista wypożyczeń została zapisana do pliku " + filePath);
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Błędne dane. Spróbuj ponownie. " + prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }
}

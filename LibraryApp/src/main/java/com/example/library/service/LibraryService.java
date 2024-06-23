/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.library.service;

import com.example.library.model.BoardGame;
import com.example.library.model.Book;
import com.example.library.model.Rental;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marys
 */
public class LibraryService {
    
    private final List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public int countBooks() {
        return (int) rentals.stream().filter(r -> r.getItem() instanceof Book).count();
    }

    public int countBoardGames() {
        return (int) rentals.stream().filter(r -> r.getItem() instanceof BoardGame).count();
    }

    public int countRentalsByAgeGroup(int minAge, int maxAge) {
        return (int) rentals.stream().filter(r -> r.getCustomer().getAge() >= minAge && r.getCustomer().getAge() <= maxAge).count();
    }
}


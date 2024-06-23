/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.library.service;

import com.example.library.model.Customer;
import com.example.library.model.Item;
import com.example.library.model.Rental;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author marys
 */
public class FileService {
   public void saveRentalsToFile(List<Rental> rentals, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Rental rental : rentals) {
                Item item = rental.getItem();
                Customer customer = rental.getCustomer();
                writer.write(item.getName() + "," + customer.getLastName() + "," + customer.getAge());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

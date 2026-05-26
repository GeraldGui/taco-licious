package com.pluralsight.ui;

import com.pluralsight.order.Order;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Order currentOrder;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {
        boolean quit = false;

        while (!quit) {
            System.out.println("---------- Menu ----------");
            System.out.println("1. New Order");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> newOrder();
                case "2" -> quit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public void newOrder() {


    }

    public void addTaco() {

    }

    public void addDrink() {

    }

    public void addChipsAndSalsa() {

    }

    public void checkout() {

    }
}

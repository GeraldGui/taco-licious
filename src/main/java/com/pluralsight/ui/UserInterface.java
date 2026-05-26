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
            System.out.println("---------- Welcome To Taco Shop ----------");
            System.out.println("1. New Order");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> newOrder();
                case 2 -> quit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public void newOrder() {
        boolean quit = false;

        while (!quit) {
            System.out.println("---------- Main Menu ----------");
            System.out.println("1. Add Taco");
            System.out.println("2. Add Drinks");
            System.out.println("3. Add Chips & Salsa");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTaco();
                case 2 -> addDrink();
                case 3 -> addChipsAndSalsa();
                case 4 -> checkout();
                case 5 -> quit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addTaco() {
        boolean quit = false;

        while (!quit) {
            System.out.println("---------- Build Your Taco ----------");
            System.out.println("1. Single");
            System.out.println("2. 3-Taco");
            System.out.println("3. Burrito");

            System.out.print("Enter your choice: ");
            int taco = scanner.nextInt();
            scanner.nextLine();

            System.out.println("---------- Select Your Shell ----------");
            System.out.println("1. Corn");
            System.out.println("2. Flour");
            System.out.println("3. Hard Shell");
            System.out.println("4. Bowl");

            System.out.print("Enter your choice: ");
            int shell = scanner.nextInt();
            scanner.nextLine();

            System.out.println("---------- Select Your Meat ----------");
            System.out.println("1. Carne Asada");
            System.out.println("2. Al Pastor");
            System.out.println("3. Carnitas");
            System.out.println("4. Pollo");
            System.out.println("5. Chorizo");
            System.out.println("6. Pescado");

            System.out.print("Enter your choice: ");
            int meat = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Would you like extra meat?");
            System.out.println("Single +0.50 | 3-Taco +1.00 | Burrito +1.50");

            System.out.println("\n1. Yes");
            System.out.println("2. No");

            System.out.print("Enter your choice: ");
            int extraMeat = scanner.nextInt();
            scanner.nextLine();

            System.out.println("---------- Select Your Cheese ----------");
            System.out.println("1. Queso Fresco");
            System.out.println("2. Oaxaca");
            System.out.println("3. Cotija");
            System.out.println("4. Cheddar");
            System.out.println("5. No Cheese");

            System.out.print("Enter your choice: ");
            int cheese = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Would you like extra cheese?");
            System.out.println("Single +0.30 | 3-Taco +0.60 | Burrito +0.90");

            System.out.println("\n1. Yes");
            System.out.println("2. No");

            System.out.print("Enter your choice: ");
            int extraCheese = scanner.nextInt();
            scanner.nextLine();

            System.out.println("---------- Select Your Toppings ----------");
            System.out.println("1. Lettuce");
            System.out.println("2. Cilantro");
            System.out.println("3. Onions");
            System.out.println("4. Tomatoes");
            System.out.println("5. Jalapenos");
            System.out.println("6. Radishes");
            System.out.println("7. Pico de Gallo");
            System.out.println("8. Guacamole");
            System.out.println("9. Corn");
            System.out.println("0. Done selecting");

            System.out.print("Enter your choice: ");
            int toppings = scanner.nextInt();
            scanner.nextLine();

            System.out.println("---------- Select Your Sauce (Free) ----------");
            System.out.println("1. Salsa Verde");
            System.out.println("2. Salsa Roja");
            System.out.println("3. Chipotle");
            System.out.println("4. Habanero");
            System.out.println("5. Mild");
            System.out.println("6. Extra Hot");
            System.out.println("7. No Sauce");

        }
    }

    public void addDrink() {

    }

    public void addChipsAndSalsa() {

    }

    public void checkout() {

    }
}

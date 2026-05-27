package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.menu.Drinks;
import com.pluralsight.menu.Taco;
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
            System.out.println("0. Cancel Order");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTaco();
                case 2 -> {
                    getDrinkSize();
                }
                case 3 -> addChipsAndSalsa();
                case 4 -> checkout();
                case 0 -> quit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addTaco() {
        boolean quit = false;

        while (!quit) {
            ShellType shell = chooseShell();
            TacoSize tacoSize = chooseTacoSize();
            MeatType meat = chooseMeat();

            System.out.println("Would you like extra meat?");
            System.out.println("Single +0.50 | 3-Taco +1.00 | Burrito +1.50");

            System.out.println("\n1. Yes");
            System.out.println("2. No");

            System.out.print("Enter your choice: ");
            int extraMeat = getChoice(1, 2);

            CheeseType cheese = chooseCheese();

            System.out.println("Would you like extra cheese?");
            System.out.println("Single +0.30 | 3-Taco +0.60 | Burrito +0.90");

            System.out.println("\n1. Yes");
            System.out.println("2. No");

            System.out.print("Enter your choice: ");
            int extraCheese = getChoice(1, 2);

            ToppingType regularTopping = chooseType();
            SalsaType salsa = chooseSauce();

            Taco taco = new Taco(tacoSize.name(), shell.name(), meat.name(), cheese.name(), salsa.name());
            taco.addIngredients(regularTopping);
            currentOrder.addItem(taco);

            quit = true;
        }
    }
    public TacoSize chooseTacoSize() {
        System.out.println("---------- Build Your Taco ----------");
        System.out.println("1. Single");
        System.out.println("2. 3-Taco");
        System.out.println("3. Burrito");

        System.out.print("Enter your choice: ");
        int taco = getChoice(1, 3);

        return switch (taco) {
            case 1 -> TacoSize.SINGLE;
            case 2 -> TacoSize.THREE_TACO;
            case 3 -> TacoSize.BURRITO;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public ShellType chooseShell() {
        System.out.println("---------- Select Your Shell ----------");
        System.out.println("1. Corn");
        System.out.println("2. Flour");
        System.out.println("3. Hard Shell");
        System.out.println("4. Bowl");

        System.out.print("Enter your choice: ");
        int shell = getChoice(1, 4);

        return switch (shell) {
            case 1 -> ShellType.CORN;
            case 2 -> ShellType.FLOUR;
            case 3 -> ShellType.HARD_SHELL;
            case 4 -> ShellType.BOWL;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public MeatType chooseMeat() {
        System.out.println("---------- Select Your Meat ----------");
        System.out.println("1. Carne Asada");
        System.out.println("2. Al Pastor");
        System.out.println("3. Carnitas");
        System.out.println("4. Pollo");
        System.out.println("5. Chorizo");
        System.out.println("6. Pescado");

        System.out.print("Enter your choice: ");
        int meat = getChoice(1, 6);

        return switch (meat) {
            case 1 -> MeatType.CARNE_ASADA;
            case 2 -> MeatType.AL_PASTOR;
            case 3 -> MeatType.CARNITAS;
            case 4 -> MeatType.POLLO;
            case 5 -> MeatType.CHORIZO;
            case 6 -> MeatType.PESCADO;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public CheeseType chooseCheese() {
        System.out.println("---------- Select Your Cheese ----------");
        System.out.println("1. Queso Fresco");
        System.out.println("2. Oaxaca");
        System.out.println("3. Cotija");
        System.out.println("4. Cheddar");
        System.out.println("5. No Cheese");

        System.out.print("Enter your choice: ");
        int cheese = getChoice(1, 5);

        return switch (cheese) {
            case 1 -> CheeseType.QUESO_FRESCO;
            case 2 -> CheeseType.OAXACA;
            case 3 -> CheeseType.COTIJA;
            case 4 -> CheeseType.CHEDDAR;
            case 5 -> CheeseType.NONE;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public ToppingType chooseType() {
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
        int toppings = getChoice(0, 9);

        return switch (toppings) {
            case 1 -> ToppingType.LETTUCE;
            case 2 -> ToppingType.CILANTRO;
            case 3 -> ToppingType.ONIONS;
            case 4 -> ToppingType.TOMATOES;
            case 5 -> ToppingType.JALAPENOS;
            case 6 -> ToppingType.RADISHES;
            case 7 -> ToppingType.PICO_DE_GALLO;
            case 8 -> ToppingType.GUACAMOLE;
            case 9 -> ToppingType.CORN;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public SalsaType chooseSauce() {
        System.out.println("---------- Select Your Sauce (Free) ----------");
        System.out.println("1. Salsa Verde");
        System.out.println("2. Salsa Roja");
        System.out.println("3. Chipotle");
        System.out.println("4. Habanero");
        System.out.println("5. Mild");
        System.out.println("6. Extra Hot");
        System.out.println("7. No Sauce");

        System.out.print("Enter your choice: ");
        int sauce = getChoice(1, 7);

        return switch (sauce) {
            case 1 -> SalsaType.SALSA_VERDE;
            case 2 -> SalsaType.SALSA_ROJA;
            case 3 -> SalsaType.CHIPOTLE;
            case 4 -> SalsaType.HABANERO;
            case 5 -> SalsaType.MILD;
            case 6 -> SalsaType.EXTRA_HOT;
            case 7 -> SalsaType.NONE;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public int getChoice(int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= min && choice <= max) {
                    return choice;
                }

                System.out.println("Please enter valid number.");
            }
            else {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }

    }

    public DrinkSize getDrinkSize(){
        System.out.println("---------- Select Your Drink Size ----------");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        System.out.print("Enter your choice: ");
        int drink = getChoice(1, 4);

        return switch (drink) {
            case 1 -> DrinkSize.SMALL;
            case 2 -> DrinkSize.MEDIUM;
            case 3 -> DrinkSize.LARGE;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public DrinkType addDrinkType() {
        System.out.println("---------- Select Your Drink ----------");
        System.out.println("1. Coca-Coal");
        System.out.println("2. Pepsi");
        System.out.println("3. Sprite");
        System.out.println("4. Crush");

        System.out.print("Enter your choice: ");
        int drink = getChoice(1, 4);

        return switch (drink) {
            case 1 -> DrinkType.COCA_COAL;
            case 2 -> DrinkType.PEPSI;
            case 3 -> DrinkType.SPRITE;
            case 4 -> DrinkType.CRUSH;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public SalsaType addChipsAndSalsa() {
        System.out.println("---------- Select Your Drink ----------");
        System.out.println("1. Salsa Verde");
        System.out.println("2. Salsa Roja");
        System.out.println("3. Chipotle");
        System.out.println("4. Habanero");
        System.out.println("5. Mild");
        System.out.println("6. Extra Hot");
        System.out.println("7. None");

        System.out.print("Enter your choice: ");
        int salsa = getChoice(1, 4);

        return switch (salsa) {
            case 1 -> SalsaType.SALSA_VERDE;
            case 2 -> SalsaType.SALSA_ROJA;
            case 3 -> SalsaType.CHIPOTLE;
            case 4 -> SalsaType.HABANERO;
            case 5 -> SalsaType.MILD;
            case 6 -> SalsaType.EXTRA_HOT;
            case 7 -> SalsaType.NONE;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };

    }

    public void checkout() {

    }
}

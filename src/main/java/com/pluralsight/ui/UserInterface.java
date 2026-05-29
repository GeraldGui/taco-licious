package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.menu.ChipsAndSalsa;
import com.pluralsight.menu.Drinks;
import com.pluralsight.menu.Taco;
import com.pluralsight.order.Order;
import com.pluralsight.order.ReceiptFileManager;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UserInterface {

    private Scanner scanner;
    private Order currentOrder;

    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {
        boolean quit = false;

        while (!quit) {
            System.out.println(YELLOW + "\n---------- Welcome To Taco-Licious ----------" + RESET);
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
        currentOrder = new Order();

        boolean quit = false;

        while (!quit) {
            System.out.println(YELLOW + "\n---------- Order Menu ----------" + RESET);
            System.out.println("1. Add Taco");
            System.out.println("2. Add Drinks");
            System.out.println("3. Add Chips & Salsa");
            System.out.println(RED + "\n---------- Signature Menu ----------" + RESET);
            System.out.println("4. Street Tacos");
            System.out.println("5. Super Burrito");
            System.out.println(GREEN + "\n---------- Checkout / Cancel----------" + RESET);
            System.out.println("6. Checkout");
            System.out.println("0. Cancel Order");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTaco();
                case 2 -> {
                    DrinkSize drinkSize = getDrinkSize();
                    DrinkType drinkType = addDrinkType();
                    Drinks drinks = new Drinks(drinkSize.name(), drinkType.name());
                    currentOrder.addItem(drinks);
                    System.out.println("Your Drink was Added!");
                }
                case 3 -> {
                    SalsaType salsaType = addChipsAndSalsa();
                    ChipsAndSalsa chipsAndSalsa = new ChipsAndSalsa(salsaType.name());
                    currentOrder.addItem(chipsAndSalsa);
                    System.out.println("Your Chips and Salsa Was Added!");
                }
                case 4 -> streetTaco();
                case 5 -> superBurrito();
                case 6 -> {
                    checkout();
                    quit = true;
                }
                case 0 -> quit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void addTaco() {
        boolean quit = false;

        while (!quit) {
            TacoSize tacoSize = chooseTacoSize();
            ShellType shell = chooseShell();
            MeatType meat = chooseMeat();

            System.out.println("\nWould you like extra meat?");
            System.out.println("Single +0.50 | 3-Taco +1.00 | Burrito +1.50");

            System.out.println("\n1. Yes");
            System.out.println("2. No");

            System.out.print("Enter your choice: ");
            int extraMeat = getChoice(1, 2);
            boolean hasExtraMeat = extraMeat == 1;

            CheeseType cheese = chooseCheese();

            System.out.println("\nWould you like extra cheese?");
            System.out.println("Single +0.30 | 3-Taco +0.60 | Burrito +0.90");

            System.out.println("\n1. Yes");
            System.out.println("2. No");

            System.out.print("Enter your choice: ");
            int extraCheese = getChoice(1, 2);
            boolean hasExtraCheese = extraCheese == 1;

            Taco taco = new Taco(tacoSize.name(), shell.name(), meat.name(), hasExtraMeat, cheese.name(), hasExtraCheese, null, false, null);

            while (true) {
                ToppingType toppingType = chooseTopping();
                if (toppingType == null) break;
                taco.addIngredients(toppingType);
            }
            SalsaType salsaType = chooseSauce();

            isCoveredInSalsaAndQueso(taco);

            SideType sideType = chooseSide();

            taco.setSalsa(salsaType.name());
            taco.setSide(sideType.name());

            currentOrder.addItem(taco);

            quit = true;
        }
    }

    public TacoSize chooseTacoSize() {
        System.out.println(YELLOW + "\n---------- Build Your Taco ----------" + RESET);
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
        System.out.println(YELLOW + "\n---------- Select Your Shell ----------" + RESET);
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
        System.out.println(YELLOW + "\n---------- Select Your Meat ----------" + RESET);
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
        System.out.println(YELLOW + "\n---------- Select Your Cheese ----------" + RESET);
        System.out.println("1. Queso Fresco");
        System.out.println("2. Oaxaca");
        System.out.println("3. Cotija");
        System.out.println("4. Cheddar");

        System.out.print("Enter your choice: ");
        int cheese = getChoice(1, 4);

        return switch (cheese) {
            case 1 -> CheeseType.QUESO_FRESCO;
            case 2 -> CheeseType.OAXACA;
            case 3 -> CheeseType.COTIJA;
            case 4 -> CheeseType.CHEDDAR;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public ToppingType chooseTopping() {
        System.out.println(YELLOW + "\n---------- Select Your Toppings ----------" + RESET);
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
        System.out.println(YELLOW + "\n---------- Select Your Sauce (Free) ----------" + RESET);
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

    public SideType chooseSide() {
        System.out.println(YELLOW + "\n---------- Select Your Side ----------" + RESET);
        System.out.println("1. Lime Wedges");
        System.out.println("2. Crema");

        System.out.print("Enter your choice: ");
        int side = getChoice(1, 2);

        return switch (side) {
            case 1 -> SideType.LIME_WEDGES;
            case 2 -> SideType.CREAMA;
            default -> {
                System.out.println("Invalid Choice!");
                yield null;
            }
        };
    }

    public DrinkSize getDrinkSize() {
        System.out.println(YELLOW + "\n---------- Select Your Drink Size ----------" + RESET);
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
        System.out.println(YELLOW + "\n---------- Select Your Drink ----------" + RESET);
        System.out.println("1. Coca-Coal");
        System.out.println("2. Pepsi");
        System.out.println("3. Sprite");
        System.out.println("4. Crush");

        System.out.print("Enter your choice: ");
        int drink = getChoice(1, 4);

        return switch (drink) {
            case 1 -> DrinkType.COCA_COLA;
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
        System.out.println(YELLOW + "\n---------- Select Your Salsa ----------" + RESET);
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

    public void isCoveredInSalsaAndQueso(Taco taco) {
        System.out.println("\nWould you like the taco/burrito covered in salsa and queso?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your choice: ");
        int covered = getChoice(1, 2);
        taco.setCoveredInSalsaAndQueso(covered == 1);

        if (covered == 1) {
            taco.setCoveredInSalsaAndQueso(true);
        }
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
            } else {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
    }

    public void streetTaco() {
        Taco taco = new Taco(TacoSize.THREE_TACO.name(), ShellType.CORN.name(), MeatType.CARNE_ASADA.name(), false, CheeseType.QUESO_FRESCO.name(), false, SalsaType.SALSA_VERDE.name(), false, SideType.LIME_WEDGES.name());
        taco.addIngredients(ToppingType.valueOf(ToppingType.ONIONS.name()));
        taco.addIngredients(ToppingType.valueOf(ToppingType.CILANTRO.name()));

        System.out.println(RED + "\n---------- Street Taco ----------" + RESET);
        System.out.println("\n" +taco);
        removeItemFromTaco(taco);
        addATopping(taco);

        currentOrder.addItem(taco);
        System.out.println("Added Street Taco to order!\n");
    }

    public void superBurrito() {
        Taco taco = new Taco(TacoSize.BURRITO.name(), ShellType.FLOUR.name(), MeatType.CARNITAS.name(), false, CheeseType.CHEDDAR.name(), false, SalsaType.NONE.name(), true, SideType.LIME_WEDGES.name());
        taco.addIngredients(ToppingType.valueOf(ToppingType.PICO_DE_GALLO.name()));
        taco.addIngredients(ToppingType.valueOf(ToppingType.LETTUCE.name()));
        taco.addIngredients(ToppingType.valueOf(ToppingType.TOMATOES.name()));

        System.out.println(RED + "\n---------- Super Burrito ----------" + RESET);
        System.out.println("\n" + taco);
        removeItemFromTaco(taco);
        addATopping(taco);

        currentOrder.addItem(taco);
        System.out.println("Added Street Taco to order!\n");
    }

    public void addATopping(Taco taco) {
        while (true) {
            System.out.println("\nWould you like to add a topping?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            if (getChoice(1, 2) == 2) break;

            ToppingType topping = chooseTopping();
            if (topping != null) {
                taco.addIngredients(topping);
                System.out.println(taco); // show updated taco
            }
        }
    }

    public void removeItemFromTaco(Taco taco) {
        while (true) {
            System.out.println("\nWould you like to remove from the taco/burrito??");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            int removeItem = getChoice(1, 2);

            if (removeItem == 2) break;

            System.out.println("\nWhat Item are you removing?");
            System.out.println("1. Shell");
            System.out.println("2. Meat");
            System.out.println("3. Cheese");
            System.out.println("4. Salsa");
            System.out.println("5. Toppings");

            System.out.print("Enter your choice: ");
            int choice = getChoice(1, 5);

            switch (choice) {
                case 1 -> taco.setShell(null);
                case 2 -> taco.setMeat(null);
                case 3 -> taco.setCheese(null);
                case 4 -> taco.setSalsa(null);
                case 5 -> {
                    System.out.println("Which topping?");
                    List<ToppingType> topping = taco.getToppings();
                    IntStream.range(0, topping.size()).forEach(i -> System.out.println((i + 1) + ". " + topping.get(i).getTopping()));

                    int toppingChoice = getChoice(1, topping.size());
                    taco.removeIngredient(toppingChoice - 1);
                }
            }
            System.out.println("\n" + taco);
        }
    }


    public void checkout() {
        if (!currentOrder.isValidOrder()) {
            System.out.println("Order must have a taco, or a drink/chips& salsa!");
            return;
        }

        System.out.println(currentOrder.getReceiptText());
        System.out.println("1. Confirm Order");
        System.out.println("0. Cancel order");
        System.out.print("Your Choice: ");

        int choice = getChoice(0, 1);

        if (choice == 1) {
            ReceiptFileManager receiptFileManager = new ReceiptFileManager();
            receiptFileManager.saveReceipt(currentOrder);
        } else {
            currentOrder = null;
            System.out.println("Order Canceled!");
        }


    }
}

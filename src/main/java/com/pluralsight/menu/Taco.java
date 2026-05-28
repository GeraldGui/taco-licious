package com.pluralsight.menu;

import com.pluralsight.enums.TacoSize;
import com.pluralsight.enums.ToppingType;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.Meat;

import java.util.ArrayList;
import java.util.List;

public class Taco implements IPriceable{
    private String shell;
    private String size;
    private String meat;
    private String cheese;
    private String salsa;
    private String side;
    private boolean hasExtraMeat;
    private boolean hasExtraCheese;
    List<ToppingType> toppings;

    public Taco() {
        toppings = new ArrayList<>();
    }

    public Taco(String size, String shell, String meat, boolean hasExtraMeat,  String cheese, boolean hasExtraCheese, String salsa, String side) {
        this.size = size;
        this.shell = shell;
        this.meat = meat;
        this.hasExtraMeat = hasExtraMeat;
        this.cheese = cheese;
        this.hasExtraCheese = hasExtraCheese;
        this.salsa = salsa;
        this.side = side;
        toppings = new ArrayList<>();
    }

    public String getShell() {
        return shell;
    }

    public String getSize() {
        return size;
    }

    public String getMeat() {return meat;}

    public String getCheese() {
        return cheese;
    }

    public String getSalsa() {
        return salsa;
    }

    public String getSide() {
        return side;
    }

    public void addIngredients(ToppingType regularTopping) {
        toppings.add(regularTopping);

    }

    @Override
    public double getPrice() {
        double base = switch (TacoSize.valueOf(size)) {
            case SINGLE -> 3.50;
            case THREE_TACO -> 9.00;
            case BURRITO -> 8.50;
        };

        double meatPrice = new Meat(meat, hasExtraMeat).getPrice(size);

        double cheesePrice = new Cheese(cheese, hasExtraCheese).getPrice(size);

        double total = base + meatPrice + cheesePrice;

        return total;
    }

    @Override
    public String toString() {
        return size + " Taco - " + shell + " shell, " + meat;
    }

}

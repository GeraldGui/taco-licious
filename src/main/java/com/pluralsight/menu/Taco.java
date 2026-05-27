package com.pluralsight.menu;

import com.pluralsight.enums.TacoSize;
import com.pluralsight.enums.ToppingType;
import com.pluralsight.toppings.Toppings;

import java.util.ArrayList;
import java.util.List;

public class Taco implements IPriceable{
    private String shell;
    private String size;
    private String meat;
    private String cheese;
    private String salsa;
    private String side;
    List<ToppingType> toppings;

    public Taco() {
        toppings = new ArrayList<>();
    }

    public Taco(String shell, String size, String meat, String cheese, String salsa, String side) {
        this.shell = shell;
        this.size = size;
        this.meat = meat;
        this.cheese = cheese;
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

    public String getDescription(){
        return "";
    }

    public double getPrice(TacoSize size) {
        return switch (size) {
            case SINGLE -> 3.50;
            case THREE_TACO -> 9.00;
            case BURRITO -> 8.50;
        };
    }

    @Override
    public double getPrice() {
        return 0.0;
    }
}

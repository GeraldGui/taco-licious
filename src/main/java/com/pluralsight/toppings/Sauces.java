package com.pluralsight.toppings;

public class Sauces extends Toppings{
    private String salsaType;

    public Sauces(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String size) {
        return 0.0;
    }
}

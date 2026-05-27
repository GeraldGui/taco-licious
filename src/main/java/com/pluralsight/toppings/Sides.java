package com.pluralsight.toppings;

public class Sides extends Toppings{
    private String sideType;

    public Sides(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String size) {
        return 0.0;
    }
}

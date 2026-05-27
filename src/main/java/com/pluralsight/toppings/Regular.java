package com.pluralsight.toppings;

public class Regular extends Toppings{
    public Regular(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String size) {
        return 0.0;
    }
}

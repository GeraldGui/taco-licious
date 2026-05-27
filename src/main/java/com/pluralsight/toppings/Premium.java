package com.pluralsight.toppings;

public class Premium extends Toppings{
    protected boolean hasExtra = false;

    public Premium(String toppingName) {
        super(toppingName);
    }


    @Override
    public double getPrice(String size) {
        return 0.0;
    }
}

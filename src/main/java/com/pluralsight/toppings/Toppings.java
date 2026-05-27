package com.pluralsight.toppings;

import com.pluralsight.menu.Taco;

public  abstract class Toppings extends Taco {
    private String toppingName;

    public Toppings(String toppingName) {
        super();
        this.toppingName = toppingName;
    }

    public String getToppingName() {
        return toppingName;
    }

    @Override
    public double getPrice(String size) {
        return 0.0;
    }
}

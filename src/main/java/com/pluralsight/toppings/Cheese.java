package com.pluralsight.toppings;

import com.pluralsight.enums.TacoSize;

public class Cheese extends Premium {

    public Cheese(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(TacoSize size) {
        return switch (size) {
            case SINGLE -> !hasExtra ? 1.05 : 0.70;
            case THREE_TACO -> !hasExtra ? 2.10 : 1.50;
            case BURRITO -> !hasExtra ? 3.15 : 2.25;
        };
    }
}

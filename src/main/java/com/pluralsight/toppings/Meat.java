package com.pluralsight.toppings;

import com.pluralsight.enums.TacoSize;

public class Meat extends Premium {
    public Meat(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(TacoSize size){
        return switch (size) {
            case SINGLE -> !hasExtra ? 1.50 : 1.00;
            case THREE_TACO -> !hasExtra ? 3.00 : 2.00;
            case BURRITO -> !hasExtra ? 4.50 : 3.00;
        };
    }
}

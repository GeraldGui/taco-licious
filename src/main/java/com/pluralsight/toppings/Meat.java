package com.pluralsight.toppings;

import com.pluralsight.enums.TacoSize;

public class Meat extends Premium {


    public Meat(String toppingName, boolean hasExtra) {
        super(toppingName, hasExtra);
    }

    public double getPrice(String size){
        return switch (TacoSize.valueOf(size)) {
            case SINGLE -> hasExtra ? 1.50 : 1.00;
            case THREE_TACO -> hasExtra ? 3.00 : 2.00;
            case BURRITO -> hasExtra ? 4.50 : 3.00;
        };
    }
}

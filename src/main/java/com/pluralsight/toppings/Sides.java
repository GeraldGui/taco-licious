package com.pluralsight.toppings;

import com.pluralsight.enums.TacoSize;

public class Sides extends Toppings{
    private String sideType;

    public Sides(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(TacoSize size) {
        return 0.0;
    }
}

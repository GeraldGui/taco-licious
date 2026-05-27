package com.pluralsight.toppings;

import com.pluralsight.enums.TacoSize;

public class Sauces extends Toppings{
    private String salsaType;

    public Sauces(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(TacoSize size) {
        return 0.0;
    }
}

package com.pluralsight.toppings;

import com.pluralsight.enums.TacoSize;

public class Regular extends Toppings{
    public Regular(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(TacoSize size) {
        return 0.0;
    }
}

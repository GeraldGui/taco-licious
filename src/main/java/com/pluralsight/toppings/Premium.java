package com.pluralsight.toppings;

import com.pluralsight.enums.TacoSize;

public class Premium extends Toppings{
    protected boolean hasExtra;
    protected String size;

    public Premium(String toppingName, boolean hasExtra) {
        super(toppingName);
        this.hasExtra = hasExtra;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }
}

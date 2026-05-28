package com.pluralsight.menu;

import com.pluralsight.enums.DrinkSize;

public class Drinks implements IPriceable {
    String size;
    String flavor;

    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getDescription() {
        return "";
    }

    @Override
    public double getPrice() {
        return switch (DrinkSize.valueOf(size)) {
            case SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
        };
    }

    @Override
    public String toString() {
        return size + " " + flavor;
    }
}

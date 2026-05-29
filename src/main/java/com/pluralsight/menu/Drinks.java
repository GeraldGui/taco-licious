package com.pluralsight.menu;

import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.DrinkType;

public class Drinks implements IPriceable {
    String size;
    String flavor;

    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
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
        return "Drink: " + DrinkSize.valueOf(size).getDrinkSize() + " " + DrinkType.valueOf(flavor).getSodaType();
    }
}

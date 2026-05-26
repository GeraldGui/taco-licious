package com.pluralsight.menu;

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
        return 0;
    }
}

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
    public double getPrice(String size) {
        double price = 0;

        if (size.equalsIgnoreCase("small")) {
            price = 2.00;

            return price;
        } else if(size.equalsIgnoreCase("medium")) {
            price = 2.50;

            return price;
        }else if(size.equalsIgnoreCase("large")) {
            price = 3.00;

            return price;
        } else {
            return price;
        }
    }

}

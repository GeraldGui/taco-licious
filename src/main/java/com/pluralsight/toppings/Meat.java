package com.pluralsight.toppings;

import com.pluralsight.enums.TacoSize;

public class Meat extends Premium {
    public Meat(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String size){
        double price = 0;

        if (size.equalsIgnoreCase("SINGLE")) {
            price = 1.00;

            if (!hasExtra) {
                price += 0.50;
            }

            return price;
        } else if(size.equalsIgnoreCase("THREE_TACO")) {
            price = 2.00;

            if (!hasExtra) {
                price += 1.00;
            }

            return price;
        }else if(size.equalsIgnoreCase("BURRITO")) {
            price = 3.00;

            if (!hasExtra) {
                price += 1.50;
            }

            return price;
        } else {
        return price;
        }
    }
}

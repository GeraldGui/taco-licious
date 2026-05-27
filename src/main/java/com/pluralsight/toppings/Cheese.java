package com.pluralsight.toppings;

public class Cheese extends Premium {
    private boolean hasExtraCheese;


    public Cheese(String toppingName) {
        super(toppingName);
    }

    @Override
    public double getPrice(String size){
        double price = 0;

        if (size.equalsIgnoreCase("SINGLE")) {
            price = 1.00;

            if (!hasExtra) {
                price += 0.30;
            }

            return price;
        } else if(size.equalsIgnoreCase("THREE_TACO")) {
            price = 2.00;

            if (!hasExtra) {
                price += 0.60;
            }

            return price;
        }else if(size.equalsIgnoreCase("BURRITO")) {
            price = 3.00;

            if (!hasExtra) {
                price += 0.90;
            }

            return price;
        } else {
            return price;
        }
    }
}

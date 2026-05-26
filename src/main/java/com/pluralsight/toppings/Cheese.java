package com.pluralsight.toppings;

public class Cheese extends Premium {
    private boolean hasExtraCheese;


    public Cheese(String shell, String size, boolean hasQueso, boolean hasSalsa) {
        super(shell, size, hasQueso, hasSalsa);
    }
}

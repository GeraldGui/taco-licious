package com.pluralsight.toppings;

public class Meat extends Premium {
    private boolean hasExtraMeat;


    public Meat(String shell, String size, boolean hasQueso, boolean hasSalsa) {
        super(shell, size, hasQueso, hasSalsa);
    }
}

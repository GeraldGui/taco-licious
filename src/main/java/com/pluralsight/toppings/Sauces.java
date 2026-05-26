package com.pluralsight.toppings;

public class Sauces extends Toppings{
    private String salsaType;

    public Sauces(String shell, String size, boolean hasQueso, boolean hasSalsa) {
        super(shell, size, hasQueso, hasSalsa);
    }
}

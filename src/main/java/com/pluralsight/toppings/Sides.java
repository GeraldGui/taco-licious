package com.pluralsight.toppings;

public class Sides extends Toppings{
    private String sideType;


    public Sides(String shell, String size, boolean hasQueso, boolean hasSalsa) {
        super(shell, size, hasQueso, hasSalsa);
    }
}

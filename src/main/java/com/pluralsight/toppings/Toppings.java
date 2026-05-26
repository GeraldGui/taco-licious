package com.pluralsight.toppings;

import com.pluralsight.menu.Taco;

public class Toppings extends Taco {
    private String toppingName;

    public Toppings(String shell, String size, boolean hasQueso, boolean hasSalsa) {
        super(shell, size, hasQueso, hasSalsa);
    }

}

package com.pluralsight.menu;

import com.pluralsight.enums.SalsaType;

public class ChipsAndSalsa implements IPriceable {
    private String salsaType;

    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
    }

    public String getSalsaType() {
        return salsaType;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips & Salsa: " + SalsaType.valueOf(salsaType).getSauceType();
    }

}

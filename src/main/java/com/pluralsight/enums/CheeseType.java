package com.pluralsight.enums;

public enum CheeseType {
    QUESO_FRESCO("Queso Fresco"), OAXACA("Oaxaca"), COTIJA("Cotija"), CHEDDAR("Cheddar");

    private final String cheeseType;

    CheeseType(String  cheeseType) {
        this.cheeseType = cheeseType;
    }

    public String getCheeseType() {
        return cheeseType;
    }
}

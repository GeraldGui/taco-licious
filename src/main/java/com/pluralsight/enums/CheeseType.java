package com.pluralsight.enums;

public enum CheeseType {
    QUESO_FRESCO(1), OAXACA(2), COTIJA(3), CHEDDAR(4), NONE(5);

    private final int cheeseType;

    CheeseType(int cheeseType) {
        this.cheeseType = cheeseType;
    }

    public int getCheeseType() {
        return cheeseType;
    }
}

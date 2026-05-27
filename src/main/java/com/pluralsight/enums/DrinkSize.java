package com.pluralsight.enums;

public enum DrinkSize {
    SMALL(1), MEDIUM(2), LARGE(3);

    private final int drinkSize;

    DrinkSize(int drinkSize) {
        this.drinkSize = drinkSize;
    }

    public int getDrinkSize() {
        return drinkSize;
    }
}

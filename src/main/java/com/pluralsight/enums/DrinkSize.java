package com.pluralsight.enums;

public enum DrinkSize {
    SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

    private final String drinkSize;

    DrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getDrinkSize() {
        return drinkSize;
    }
}

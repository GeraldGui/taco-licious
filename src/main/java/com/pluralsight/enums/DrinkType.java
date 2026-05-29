package com.pluralsight.enums;

public enum DrinkType {
    COCA_COLA("Coca-Cola"), PEPSI("Pepsi"), SPRITE("Sprite"), CRUSH("Crush");

    private final String sodaType;

    DrinkType(String sodaType) {
        this.sodaType = sodaType;
    }

    public String getSodaType() {
        return sodaType;
    }
}

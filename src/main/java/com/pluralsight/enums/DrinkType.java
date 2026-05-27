package com.pluralsight.enums;

public enum DrinkType {
    COCA_COAL(1), PEPSI(2), SPRITE(3), CRUSH(4);

    private final int sodaType;

    DrinkType(int sodaType) {
        this.sodaType = sodaType;
    }

    public int getSodaType() {
        return sodaType;
    }
}

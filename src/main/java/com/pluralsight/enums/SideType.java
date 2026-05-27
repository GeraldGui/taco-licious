package com.pluralsight.enums;

public enum SideType {
    LIME_WEDGES(1), CREAMA(2);

    private final int sides;

    SideType(int sides) {
        this.sides = sides;
    }

    public int getSides() {
        return sides;
    }
}

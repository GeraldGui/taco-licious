package com.pluralsight.enums;

public enum SideType {
    LIME_WEDGES("Lime Wedges"), CREAMA("Creama");

    private final String sides;

    SideType(String sides) {
        this.sides = sides;
    }

    public String getSides() {
        return sides;
    }
}

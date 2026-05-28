package com.pluralsight.enums;

public enum ToppingType {
    LETTUCE("Lettuce"), CILANTRO("Cilantro"), ONIONS("Onions"), TOMATOES("Tomatoes"), JALAPENOS("Jalapenos"), RADISHES("Radishes"), PICO_DE_GALLO("Pico De Gallo"), GUACAMOLE("Guacamole"), CORN("Corn");

    private final String topping;

    ToppingType(String topping) {
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }
}

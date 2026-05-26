package com.pluralsight.enums;

public enum ToppingType {
    LETTUCE(1), CILANTRO(2), ONIONS(3), TOMATOES(4), JALAPENOS(5), RADISHES(6), PICO_DE_GALLO(7), GUACAMOLE(8), CORN(9);

    private final int topping;

    ToppingType(int topping) {
        this.topping = topping;
    }

    public int getTopping() {
        return topping;
    }
}

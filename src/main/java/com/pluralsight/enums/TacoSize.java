package com.pluralsight.enums;

public enum TacoSize {
    SINGLE(1), THREE_TACO(2), BURRITO(3);

    private final int tacoSize;

    TacoSize(int tacoSize) {
        this.tacoSize = tacoSize;
    }

    public int getTacoSize() {
        return tacoSize;
    }
}

package com.pluralsight.enums;

public enum TacoSize {
    SINGLE(1, 3.50), THREE_TACO(2, 9.00), BURRITO(3, 8.50);

    private final int tacoSize;
    private final double price;

    TacoSize(int tacoSize, double price) {
        this.tacoSize = tacoSize;
        this.price = price;
    }

    public int getTacoSize() {
        return tacoSize;
    }

    public double getPrice() {
        return price;
    }
}

package com.pluralsight.enums;

public enum TacoSize {
    SINGLE("Single"), THREE_TACO("Three Taco"), BURRITO("Burrito");

    private final String tacoSize;

    TacoSize(String tacoSize) {
        this.tacoSize = tacoSize;
    }

    public String getTacoSize() {
        return tacoSize;
    }
}
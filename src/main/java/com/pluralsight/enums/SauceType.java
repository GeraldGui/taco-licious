package com.pluralsight.enums;

public enum SauceType {
    SALSA_VERDE(1), SALSA_ROJA(2), CHIPOTLE(3), HABANERO(4), MILD(5), EXTRA_HOT(6), NONE(7);

    private final int sauceType;

    SauceType(int sauceType) {
        this.sauceType = sauceType;
    }

    public int getSauceType() {
        return sauceType;
    }
}

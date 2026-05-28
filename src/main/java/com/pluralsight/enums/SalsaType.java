package com.pluralsight.enums;

public enum SalsaType {
    SALSA_VERDE("Salsa Verde"), SALSA_ROJA("Salsa Roja"), CHIPOTLE("Chipotle"), HABANERO("Habanero"), MILD("Mild"), EXTRA_HOT("Extra Hot"), NONE("None");

    private final String sauceType;

    SalsaType(String sauceType) {
        this.sauceType = sauceType;
    }

    public String getSauceType() {
        return sauceType;
    }
}

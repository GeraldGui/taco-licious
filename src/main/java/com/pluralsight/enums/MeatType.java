package com.pluralsight.enums;

public enum MeatType {
    CARNE_ASADA(1), AL_PASTOR(2), CARNITAS(3), POLLO(4), CHORIZO(5), PESCADO(6);

    private final int meatType;

    MeatType(int meatType) {
        this.meatType = meatType;
    }

    public int getMeatType() {
        return meatType;
    }

}

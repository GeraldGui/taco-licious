package com.pluralsight.enums;

public enum MeatType {
    CARNE_ASADA("Carne Asada"), AL_PASTOR("Al Pastor"), CARNITAS("Carnitas"), POLLO("Pollo"), CHORIZO("Chorizo"), PESCADO("Pescado");

    private final String meatType;

    MeatType(String meatType) {
        this.meatType = meatType;
    }

    public String getMeatType() {
        return meatType;
    }

}

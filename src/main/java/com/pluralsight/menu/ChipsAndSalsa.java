package com.pluralsight.menu;

public class ChipsAndSalsa implements IPriceable{
    private String salsaType;

    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
    }

    public String getSalsaType() {
        return salsaType;
    }

    public String getDescription() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }
}

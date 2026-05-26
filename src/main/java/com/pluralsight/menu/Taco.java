package com.pluralsight.menu;

public class Taco implements IPriceable{
    private String shell;
    private String size;
    private String meat;
    private boolean hasQueso;
    private boolean hasSalsa;



    public Taco(String shell, String size, String meat, boolean hasQueso, boolean hasSalsa) {
        this.shell = shell;
        this.size = size;
        this.meat = meat;
        this.hasQueso = hasQueso;
        this.hasSalsa = hasSalsa;
    }

    public String getShell() {
        return shell;
    }

    public String getSize() {
        return size;
    }

    public String getmeat() {return meat;}

    public boolean isHasQueso() {
        return hasQueso;
    }

    public boolean isHasSalsa() {
        return hasSalsa;
    }

    public void addIngredients() {

    }

    public String getDescription(){
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }

}

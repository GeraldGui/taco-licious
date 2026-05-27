package com.pluralsight.menu;

public class Taco implements IPriceable{
    private String shell;
    private String size;
    private String meat;
    private String cheese;
    private String salsa;

    public Taco() {

    }

    public Taco(String shell, String size, String meat, String cheese, String salsa) {
        this.shell = shell;
        this.size = size;
        this.meat = meat;
        this.cheese = cheese;
        this.salsa = salsa;
    }

    public String getShell() {
        return shell;
    }

    public String getSize() {
        return size;
    }

    public String getMeat() {return meat;}

    public String getCheese() {
        return cheese;
    }

    public String getSalsa() {
        return salsa;
    }

    public void addIngredients() {

    }

    public String getDescription(){
        return "";
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }

}

package com.pluralsight.menu;

import com.pluralsight.enums.*;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.Meat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Taco implements IPriceable {
    private String shell;
    private String size;
    private String meat;
    private String cheese;
    private String salsa;
    private String side;
    private boolean hasExtraMeat;
    private boolean hasExtraCheese;
    private boolean coveredInSalsaAndQueso;
    List<ToppingType> toppings;

    public Taco() {
        toppings = new ArrayList<>();
    }

    public Taco(String size, String shell, String meat, boolean hasExtraMeat, String cheese, boolean hasExtraCheese, String salsa, boolean coveredInSalsaAndQueso, String side) {
        this.size = size;
        this.shell = shell;
        this.meat = meat;
        this.hasExtraMeat = hasExtraMeat;
        this.cheese = cheese;
        this.hasExtraCheese = hasExtraCheese;
        this.salsa = salsa;
        this.coveredInSalsaAndQueso = coveredInSalsaAndQueso;
        this.side = side;
        toppings = new ArrayList<>();
    }

    public String getShell() {
        return shell;
    }

    public String getSize() {
        return size;
    }

    public String getMeat() {
        return meat;
    }

    public String getCheese() {
        return cheese;
    }

    public String getSalsa() {
        return salsa;
    }

    public String getSide() {
        return side;
    }

    public boolean isCoveredInSalsaAndQueso() {
        return coveredInSalsaAndQueso;
    }

    public List<ToppingType> getToppings() {
        return toppings;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void addIngredients(ToppingType regularTopping) {
        toppings.add(regularTopping);
    }

    public void setCoveredInSalsaAndQueso(boolean coveredInSalsaAndQueso) {
        this.coveredInSalsaAndQueso = coveredInSalsaAndQueso;
    }

    public void removeIngredient(int index) {
        toppings.remove(index);
    }

    @Override
    public double getPrice() {
        double base = switch (TacoSize.valueOf(size)) {
            case SINGLE -> 3.50;
            case THREE_TACO -> 9.00;
            case BURRITO -> 8.50;
        };

        double meatPrice = (meat == null) ? 0.0 : new Meat(meat, hasExtraMeat).getPrice(size);

        double cheesePrice = (cheese == null) ? 0.0 : new Cheese(cheese, hasExtraCheese).getPrice(size);

        double total = base + meatPrice + cheesePrice;

        return total;
    }

    @Override
    public String toString() {
        return ("Taco: " + TacoSize.valueOf(size).getTacoSize() +
                "\nShell: " + (shell == null ? "No Shell" : ShellType.valueOf(shell).getShellType()) +
                "\nMeat: " + (meat == null ? "No Meat" : MeatType.valueOf(meat).getMeatType()) +
                "\nCheese: " + (cheese == null ? "No Cheese" : CheeseType.valueOf(cheese).getCheeseType()) +
                "\nRegular Toppings: " + toppings.stream().map(ToppingType::getTopping).collect(Collectors.joining(", ")) +
                "\nSauces: " + (salsa == null ? "No Salsa" : SalsaType.valueOf(salsa).getSauceType()) +
                "\nCovered in salsa and queso: " + (isCoveredInSalsaAndQueso() ? "Yes" : "NO") +
                "\nSides: " + SideType.valueOf(side).getSides());
    }

}

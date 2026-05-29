package com.pluralsight.order;

import com.pluralsight.menu.ChipsAndSalsa;
import com.pluralsight.menu.Drinks;
import com.pluralsight.menu.IPriceable;
import com.pluralsight.menu.Taco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Order {
    private static int orderNubmer = 0;
    private int orderID;
    private LocalDateTime orderDate;
    private List<IPriceable> items;

    public Order() {
        orderNubmer++;
        this.orderID = orderNubmer;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public int getOrderID() {
        return orderID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<IPriceable> getItems() {
        return items;
    }

    public void addItem(IPriceable item) { items.add(item);}

    public double getTotalPrice() {
        double total = 0;

        for (IPriceable item: items) {
            total += item.getPrice();
        }
        return total;
    }

    public boolean isValidOrder() {
        boolean hasTaco = items.stream().anyMatch(item -> item instanceof Taco);
        boolean hasDrinkOrChips = items.stream().anyMatch(item -> item instanceof Drinks || item instanceof ChipsAndSalsa);

        return hasTaco || hasDrinkOrChips;
    }

    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append("===================================\n");
        sb.append("        Taco-Licious RECEIPT\n");
        sb.append("===================================\n");
        sb.append("Order ID: ").append(getOrderID()).append("\n");
        sb.append("Date: ").append(getOrderDate().format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"))).append("\n");
        sb.append("-----------------------------------\n");

        List<IPriceable> reversed = new ArrayList<>(items);
        Collections.reverse(reversed);

        for (IPriceable item : reversed) {
            sb.append(item).
                    append("\n                              $").
                    append(String.format("%.2f", item.getPrice())).
                    append("\n-----------------------------------\n");
        }

        sb.append("Total: $").append(String.format("%.2f", getTotalPrice())).append("\n");
        sb.append("===================================\n");
        sb.append("Thank you! Come again!\n");
        return sb.toString();
    }
}

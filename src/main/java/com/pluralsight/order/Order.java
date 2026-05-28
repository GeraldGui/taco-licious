package com.pluralsight.order;

import com.pluralsight.menu.IPriceable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    public void removeItem() {

    }

    public double getTotalPrice() {
        double total = 0;

        for (IPriceable item: items) {
            total += item.getPrice();
        }
        return total;
    }

    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append("===================================\n");
        sb.append("        TACO SHOP RECEIPT\n");
        sb.append("===================================\n");
        sb.append("Order ID: ").append(getOrderID()).append("\n");
        sb.append("Date: ").append(getOrderDate().format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"))).append("\n");
        sb.append("-----------------------------------\n");

        for (IPriceable item : getItems()) {
            sb.append(item).append("  $").append(item.getPrice()).append("\n");
        }

        sb.append("-----------------------------------\n");
        sb.append("Total: $").append(getTotalPrice()).append("\n");
        sb.append("===================================\n");
        sb.append("Thank you! Come again!\n");
        return sb.toString();
    }
}

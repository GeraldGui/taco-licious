package com.pluralsight.order;

import com.pluralsight.menu.IPriceable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderID;
    private LocalDateTime orderDate;
    private List<IPriceable> items;

    public Order() {
        this.orderID = null;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public String getOrderID() {
        return orderID;
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

    public boolean isValidOrder() {
        return false;
    }
}

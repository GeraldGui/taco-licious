package com.pluralsight.order;

import com.pluralsight.menu.MenuItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderID;
    private LocalDateTime orderDate;
    private List<MenuItem> items;

    public Order() {
        this.orderID = null;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public String getOrderID() {
        return orderID;
    }

    public void addItem(MenuItem item) {

    }

    public void removeItem() {

    }

    public double getTotalPrice() {
        return 0;
    }

    public boolean isValidOrder() {
        return false;
    }
}

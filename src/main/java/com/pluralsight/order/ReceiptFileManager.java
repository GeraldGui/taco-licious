package com.pluralsight.order;

import com.pluralsight.menu.IPriceable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public void saveReceipt(Order order) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String time = order.getOrderDate().format(formatter);

        String fileName = time + ".txt";

        try {
            Path path = Path.of(fileName);
            Files.writeString(path,order.getReceiptText());
            System.out.println("Receipt saved: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save receipt!");
        }
    }
}

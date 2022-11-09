package tech.task;

import tech.task.model.Order;
import tech.task.model.Record;
import tech.task.service.InitializerService;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InitializerService initializer = new InitializerService();

        List<Record> records = initializer.initialize();

        LinkedList<Record> buyRecords = new LinkedList<>();
        LinkedList<Record> sellRecords = new LinkedList<>();

        for (Record record : records) {
            if (record.getOrder().equals(Order.BUY)) {
                buyRecords.add(record);
            }
            if (record.getOrder().equals(Order.SELL)) {
                sellRecords.add(record);
            }
        }

        Record recordWithBestBuyPrice = buyRecords.getFirst();
        for (Record record : buyRecords) {
            if (record.getPrice().compareTo(recordWithBestBuyPrice.getPrice()) < 0) {
                recordWithBestBuyPrice = record;
            }
        }

        Record recordWithBestSellPrice = buyRecords.getFirst();
        for (Record record : sellRecords) {
            if (record.getPrice().compareTo(recordWithBestSellPrice.getPrice()) > 0) {
                recordWithBestSellPrice = record;
            }
        }

        System.out.println("The sum of record with better price to BUY was: "
                + recordWithBestBuyPrice
                .getPrice()
                .multiply(BigDecimal.valueOf(recordWithBestBuyPrice.getQuantity()))
                + ", price: "
                + recordWithBestBuyPrice.getPrice()
                + System.lineSeparator()
                + "The sum of record with better price to SELL was: "
                + recordWithBestSellPrice
                .getPrice()
                .multiply(BigDecimal.valueOf(recordWithBestSellPrice.getQuantity()))
                + ", price: "
                + recordWithBestSellPrice.getPrice());

    }
}

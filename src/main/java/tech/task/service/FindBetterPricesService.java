package tech.task.service;

import tech.task.model.Order;
import tech.task.model.Record;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
public class FindBetterPricesService {
    LinkedList<Record> buyRecords = new LinkedList<>();
    LinkedList<Record> sellRecords = new LinkedList<>();

    public void getRecordWithBetterPrice(List<Record> records) {
        for (Record record : records) {
            if (record.getOrder().equals(Order.BUY)) {
                buyRecords.add(record);
            }
            if (record.getOrder().equals(Order.SELL)) {
                sellRecords.add(record);
            }
            Record recordWithBestBuyPrice = buyRecords.getFirst();
            for (Record record1 : buyRecords) {
                if (record1.getPrice().compareTo(recordWithBestBuyPrice.getPrice()) < 0) {
                    recordWithBestBuyPrice = record1;
                }
            }

            Record recordWithBestSellPrice = buyRecords.getFirst();
            for (Record record2 : sellRecords) {
                if (record2.getPrice().compareTo(recordWithBestSellPrice.getPrice()) > 0) {
                    recordWithBestSellPrice = record2;
                }
            }
            System.out.println(System.lineSeparator()
                    + "The sum of record with better price to BUY was: "
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
}

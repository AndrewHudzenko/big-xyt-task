package tech.task.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.task.model.OrderType;
import tech.task.model.Order;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
public class OrderService {
    private final Logger logger = LogManager.getLogger(OrderService.class);
    private final DeleteRedundantRecordsService deleteRedundantRecordsService = new DeleteRedundantRecordsService();

    public void printBestPrices(List<Order> orders) {
        deleteRedundantRecordsService.clearRecords(orders);

        LinkedList<Order> buyOrders = new LinkedList<>();
        LinkedList<Order> sellOrders = new LinkedList<>();
        Order orderWithBestBuyPrice;
        Order orderWithBestSellPrice;

        for (Order order : orders) {
            if (order.getOrder().equals(OrderType.BUY)) {
                buyOrders.add(order);
            }
            if (order.getOrder().equals(OrderType.SELL)) {
                sellOrders.add(order);
            }

            if (!buyOrders.isEmpty()) {
                orderWithBestBuyPrice = buyOrders.getFirst();
            } else {
                orderWithBestBuyPrice = sellOrders.getFirst();
            }

            if (!sellOrders.isEmpty()) {
                orderWithBestSellPrice = sellOrders.getFirst();
            } else {
                orderWithBestSellPrice = buyOrders.getFirst();
            }

            for (Order order1 : buyOrders) {
                if (order1.getPrice().compareTo(orderWithBestBuyPrice.getPrice()) < 0) {
                    orderWithBestBuyPrice = order1;
                }
            }

            for (Order order2 : sellOrders) {
                if (order2.getPrice().compareTo(orderWithBestSellPrice.getPrice()) > 0) {
                    orderWithBestSellPrice = order2;
                }
            }

            logger.info(System.lineSeparator()
                    + "The sum of record with better price to BUY was: "
                    + orderWithBestBuyPrice
                    .getPrice()
                    .multiply(BigDecimal.valueOf(orderWithBestBuyPrice.getQuantity()))
                    + ", price: "
                    + orderWithBestBuyPrice.getPrice()
                    + System.lineSeparator()
                    + "The sum of record with better price to SELL was: "
                    + orderWithBestSellPrice
                    .getPrice()
                    .multiply(BigDecimal.valueOf(orderWithBestSellPrice.getQuantity()))
                    + ", price: "
                    + orderWithBestSellPrice.getPrice());
        }
    }
}

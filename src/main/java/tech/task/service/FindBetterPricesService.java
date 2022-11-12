package tech.task.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.task.model.OrderType;
import tech.task.model.Order;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
public class FindBetterPricesService {
    private final Logger logger = LogManager.getLogger(FindBetterPricesService.class);
    LinkedList<Order> buyOrders = new LinkedList<>();
    LinkedList<Order> sellOrders = new LinkedList<>();

    public void getRecordWithBetterPrice(List<Order> orders) {
        for (Order order : orders) {
            if (order.getOrder().equals(OrderType.BUY)) {
                buyOrders.add(order);
            }
            if (order.getOrder().equals(OrderType.SELL)) {
                sellOrders.add(order);
            }
            Order orderWithBestBuyPrice = buyOrders.getFirst();
            for (Order order1 : buyOrders) {
                if (order1.getPrice().compareTo(orderWithBestBuyPrice.getPrice()) < 0) {
                    orderWithBestBuyPrice = order1;
                }
            }

            Order orderWithBestSellPrice = buyOrders.getFirst();
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

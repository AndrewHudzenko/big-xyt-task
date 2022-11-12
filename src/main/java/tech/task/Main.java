package tech.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.task.model.Order;
import tech.task.service.OrderService;
import tech.task.service.OrderInitializerService;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        OrderInitializerService orderInitializerService = new OrderInitializerService();
        OrderService betterPricesService = new OrderService();

        List<Order> orders = orderInitializerService.getRecords();

        logger.info("At the start we have a list of records: ");
        orders.forEach(logger::info);

        logger.info(System.lineSeparator() + "Total sum and better prices to BUY and SELL: ");
        betterPricesService.printBestPrices(orders);
    }
}

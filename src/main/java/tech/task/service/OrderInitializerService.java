package tech.task.service;

import tech.task.model.OrderType;
import tech.task.model.Order;
import tech.task.model.OperationType;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class OrderInitializerService {
    public static List<Order> orders = new LinkedList<>();

    public static void initialize() {
        Order firstOrder = new Order();
        firstOrder.setOrder(OrderType.BUY);
        firstOrder.setId(1L);
        firstOrder.setType(OperationType.ADD);
        firstOrder.setPrice(new BigDecimal(20));
        firstOrder.setQuantity(100L);

        Order secondOrder = new Order();
        secondOrder.setOrder(OrderType.SELL);
        secondOrder.setId(2L);
        secondOrder.setType(OperationType.ADD);
        secondOrder.setPrice(new BigDecimal(25));
        secondOrder.setQuantity(200L);

        Order thirdOrder = new Order();
        thirdOrder.setOrder(OrderType.BUY);
        thirdOrder.setId(3L);
        thirdOrder.setType(OperationType.ADD);
        thirdOrder.setPrice(new BigDecimal(23));
        thirdOrder.setQuantity(50L);

        Order forthOrder = new Order();
        forthOrder.setOrder(OrderType.BUY);
        forthOrder.setId(4L);
        forthOrder.setType(OperationType.ADD);
        forthOrder.setPrice(new BigDecimal(23));
        forthOrder.setQuantity(70L);

        Order fifthOrder = new Order();
        fifthOrder.setOrder(OrderType.BUY);
        fifthOrder.setId(3L);
        fifthOrder.setType(OperationType.REMOVE);
        fifthOrder.setPrice(new BigDecimal(23));
        fifthOrder.setQuantity(50L);

        Order sixthOrder = new Order();
        sixthOrder.setOrder(OrderType.SELL);
        sixthOrder.setId(5L);
        sixthOrder.setType(OperationType.ADD);
        sixthOrder.setPrice(new BigDecimal(28));
        sixthOrder.setQuantity(100L);

        orders.add(firstOrder);
        orders.add(secondOrder);
        orders.add(thirdOrder);
        orders.add(forthOrder);
        orders.add(fifthOrder);
        orders.add(sixthOrder);
    }

    public List<Order> getRecords() {
        OrderInitializerService.initialize();
        return orders;
    }

    public void clearRecords() {
        orders.clear();
    }
}

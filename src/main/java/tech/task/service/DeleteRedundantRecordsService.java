package tech.task.service;

import tech.task.model.Order;
import tech.task.model.OperationType;
import java.util.List;

public class DeleteRedundantRecordsService {
    public void clearRecords(List<Order> list) {
        List<Order> orders = list;
        for (Order order : orders) {
            if (order.getType().equals(OperationType.REMOVE)) {
                for (Order value : orders) {
                    if (value.getId().equals(order.getId()) && (value.getType().equals(OperationType.ADD))) {
                        orders.remove(order);
                        orders.remove(value);
                        break;
                    }
                }
            }
        }
    }
}

package tech.task.model;

import java.math.BigDecimal;

public class Order {
    private OrderType orderType;
    private Long id;
    private OperationType operationType;
    private BigDecimal price;
    private Long quantity;

    public Long getId() {
        return id;
    }

    public OrderType getOrder() {
        return orderType;
    }

    public void setOrder(OrderType orderType) {
        this.orderType = orderType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperationType getType() {
        return operationType;
    }

    public void setType(OperationType operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{"
                + "order=" + orderType
                + ", id=" + id
                + ", type=" + operationType
                + ", price=" + price
                + ", quantity=" + quantity
                + '}';
    }
}

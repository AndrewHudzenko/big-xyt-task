package tech.task.model;

import java.math.BigDecimal;

public class Record {
    private Order order;
    private Long id;
    private Type type;
    private BigDecimal price;
    private Long quantity;

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
                + "order=" + order
                + ", id=" + id
                + ", type=" + type
                + ", price=" + price
                + ", quantity=" + quantity
                + '}';
    }
}

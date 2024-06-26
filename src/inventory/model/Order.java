package inventory.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<InventoryItem> items;
    private double totalCost;
    private String paymentMethod;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void addItem(InventoryItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", items=" + items +
                ", totalCost=" + totalCost +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}

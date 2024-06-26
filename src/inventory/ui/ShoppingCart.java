package inventory.ui;

import inventory.model.InventoryItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(InventoryItem item, int quantity) {
        CartItem cartItem = new CartItem(item, quantity);
        items.add(cartItem);
    }

    public void displayItems() {
        for (CartItem item : items) {
            System.out.printf("Item: %s, Quantity: %d%n", item.getItem().getDescription(), item.getQuantity());
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getItem().getPrice() * item.getQuantity();
        }
        return total;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    // Inner class representing items in the cart with quantity
    private static class CartItem {
        private InventoryItem item;
        private int quantity;

        public CartItem(InventoryItem item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        public InventoryItem getItem() {
            return item;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}

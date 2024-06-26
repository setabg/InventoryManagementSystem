package inventory.model;

import inventory.interfaces.Item;

import java.time.LocalDate;

public class GroceryItem extends InventoryItem {
    private LocalDate expirationDate;

    public GroceryItem(int id, String description, double price, String category, int quantity, LocalDate expirationDate) {
        super(id, description, price, category, false, true, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public double calculateValue() {
        // Example calculation for GroceryItem
        // Assume value calculation based on price and quantity
        return getPrice() * getQuantity();
    }

    @Override
    public String getItemDetails() {
        return super.getItemDetails() + ", Expiration Date: " + expirationDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}

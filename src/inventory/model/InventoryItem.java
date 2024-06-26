package inventory.model;

import inventory.interfaces.Item;

import java.time.LocalDate;

/**
 * Represents an item in the inventory.
 */
public class InventoryItem implements Item {
    private int id;
    private String description;
    private double price;
    private String category;
    private boolean breakable;
    private boolean perishable;
    private int quantity;

    public InventoryItem(int id, String description, double price, String category, boolean breakable, boolean perishable, int quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.category = category;
        this.breakable = breakable;
        this.perishable = perishable;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return "ID: " + id + ", Description: " + description + ", Price: " + price + ", Category: " + category + ", Quantity: " + quantity;
    }

    @Override
    public double calculateValue() {
        // Default implementation for calculateValue
        // You can customize this based on specific requirements for subclasses
        return getPrice() * getQuantity();
    }

    @Override
    public LocalDate getExpirationDate() {
        // Default implementation returns null
        // Should be overridden in subclasses if applicable
        return null;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        // Default implementation does nothing
        // Should be overridden in subclasses if applicable
    }
}

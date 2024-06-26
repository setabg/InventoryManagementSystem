package inventory.model;

import inventory.interfaces.Item;

public class ElectronicsItem extends InventoryItem {
    private String brand;

    public ElectronicsItem(int id, String description, double price, String category, int quantity, String brand) {
        super(id, description, price, category, false, false, quantity);
        this.brand = brand;
    }

    @Override
    public double calculateValue() {
        // Example calculation for ElectronicsItem
        // Assume value calculation based on price, quantity, and brand value
        return getPrice() * getQuantity() * 1.1; // Adding a 10% premium
    }

    @Override
    public String getItemDetails() {
        return super.getItemDetails() + ", Brand: " + brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

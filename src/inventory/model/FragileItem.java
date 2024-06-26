package inventory.model;

import inventory.interfaces.Breakable;
import inventory.interfaces.Item;

public class FragileItem extends InventoryItem implements Breakable {

    public FragileItem(int id, String description, double price, String category, int quantity) {
        super(id, description, price, category, true, false, quantity);
    }

    @Override
    public double calculateValue() {
        // Example calculation for FragileItem
        return getPrice() * getQuantity() * 1.2; // Adding a 20% premium
    }

    @Override
    public void handleBreakage() {
        // Example handling for FragileItem
        System.out.println("Handle with care!");
    }
}

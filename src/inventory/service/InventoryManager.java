package inventory.service;

import inventory.model.InventoryItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private final List<InventoryItem> inventory = new ArrayList<>();

    public void addItem(InventoryItem item) {
        inventory.add(item);
    }

    public void listItems() {
        for (InventoryItem item : inventory) {
            System.out.println(item.getItemDetails());
        }
    }

    public void saveInventory(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (InventoryItem item : inventory) {
                writer.write(item.getId() + "," + item.getDescription() + "," + item.getPrice() + "," + item.getCategory() + "," + item.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
            throw e;
        }
    }

    public void loadInventory(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String description = parts[1];
                double price = Double.parseDouble(parts[2]);
                String category = parts[3];
                int quantity = Integer.parseInt(parts[4]);
                InventoryItem item = new InventoryItem(id, description, price, category, false, false, quantity);
                addItem(item);
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
            throw e;
        }
    }

    public boolean categorizeItem(int itemId, String newCategory) {
        InventoryItem item = findItemById(itemId);
        if (item != null) {
            item.setCategory(newCategory);
            return true;
        }
        return false;
    }

    private InventoryItem findItemById(int itemId) {
        for (InventoryItem item : inventory) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        return null;
    }
}

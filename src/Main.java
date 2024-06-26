
import inventory.model.InventoryItem;
import inventory.service.InventoryManager;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. List Items");
            System.out.println("3. Save Inventory");
            System.out.println("4. Load Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem(inventoryManager, scanner);
                    break;
                case 2:
                    inventoryManager.listItems();
                    break;
                case 3:
                    saveInventory(inventoryManager, scanner);
                    break;
                case 4:
                    loadInventory(inventoryManager, scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem(InventoryManager inventoryManager, Scanner scanner) {
        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        InventoryItem item = new InventoryItem(id, description, price, category, false, false, quantity);
        inventoryManager.addItem(item);
        System.out.println("Item added successfully.");
    }

    private static void saveInventory(InventoryManager inventoryManager, Scanner scanner) {
        System.out.print("Enter filename to save inventory: ");
        String filename = scanner.nextLine();
        try {
            inventoryManager.saveInventory(filename);
            System.out.println("Inventory saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    private static void loadInventory(InventoryManager inventoryManager, Scanner scanner) {
        System.out.print("Enter filename to load inventory: ");
        String filename = scanner.nextLine();
        try {
            inventoryManager.loadInventory(filename);
            System.out.println("Inventory loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }
    }
}

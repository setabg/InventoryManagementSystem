package inventory.ui;

import inventory.model.InventoryItem;
import inventory.service.InventoryManager;
import inventory.service.PaymentProcessor;

import java.io.IOException;
import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the E-commerce Console Application!");
        displayMenu();

        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter command (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline
            switch (choice) {
                case 1:
                    inventoryManager.listItems();
                    break;
                case 2:
                    addItem(inventoryManager, scanner);
                    break;
                case 3:
                    placeOrder(inventoryManager, paymentProcessor, scanner);
                    break;
                case 4:
                    categorizeItem(inventoryManager, scanner);
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. List Items");
        System.out.println("2. Add Item");
        System.out.println("3. Place Order");
        System.out.println("4. Categorize Item");
        System.out.println("5. Exit");
    }

    private static void addItem(InventoryManager inventoryManager, Scanner scanner) {
        System.out.println("Enter item details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        int id = generateItemId();
        InventoryItem item = new InventoryItem(id, name, price, category, false, false, quantity);
        inventoryManager.addItem(item);
        System.out.println("Item added successfully.");
    }

    private static int generateItemId() {
        // Implement logic to generate unique item IDs
        // For simplicity, let's use a simple counter for demonstration
        return (int) (Math.random() * 1000); // Example of generating random IDs
    }

    private static void placeOrder(InventoryManager inventoryManager, PaymentProcessor paymentProcessor, Scanner scanner) {
        // Implement order processing logic here
        // Example: Select items, calculate total, process payment, update inventory
    }

    private static void categorizeItem(InventoryManager inventoryManager, Scanner scanner) {
        System.out.print("Enter item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter new category: ");
        String newCategory = scanner.nextLine();

        if (inventoryManager.categorizeItem(itemId, newCategory)) {
            System.out.println("Item categorized successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }
}

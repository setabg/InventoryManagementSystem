package inventory.model;

import inventory.interfaces.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    private String category;
    private String description;
    private double price;
    private boolean breakable;
    private boolean perishable;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double calculateValue() {
        return price;
    }

    @Override
    public String getItemDetails() {
        return "Description: " + description + ", Price: " + price + ", Category: " + category +
                ", Breakable: " + breakable + ", Perishable: " + perishable;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public void handleBreakage() {
        if (breakable) {
            System.out.println("Item has broken.");
        }
    }

    @Override
    public boolean isPerishable() {
        return perishable;
    }

    @Override
    public void handleExpiration() {
        if (perishable) {
            System.out.println("Item has expired.");
        }
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }
}

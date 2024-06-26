package inventory.interfaces;

import java.time.LocalDate;

/**
 * Represents an item that can be managed in the inventory system.
 */
public interface Item {
    String getDescription();
    double calculateValue();
    String getItemDetails();
    String getCategory();
    void setCategory(String category);
    LocalDate getExpirationDate();
    void setExpirationDate(LocalDate expirationDate);
}

package inventory.interfaces;

public interface Perishable {
    boolean isPerishable();
    void handleExpiration();
}

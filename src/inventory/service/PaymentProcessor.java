package inventory.service;

public class PaymentProcessor {
    public boolean processPayment(String paymentMethod, double amount) {
        System.out.println("Processing " + paymentMethod + " payment for amount: " + amount);
        return true;
    }
}

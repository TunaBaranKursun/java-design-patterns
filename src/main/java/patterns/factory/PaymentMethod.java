package main.java.patterns.factory;

public interface PaymentMethod {
    boolean processPayment(double amount);
    String getPaymentType();
    void validatePayment(double amount);
}


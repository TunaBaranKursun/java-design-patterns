package main.java.patterns.factory;

public class BankTransferPayment implements PaymentMethod {
    private String bankName;
    private String accountNumber;
    private String accountHolderName;

    public BankTransferPayment(String bankName, String accountNumber, String accountHolderName) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    @Override
    public void validatePayment(double amount) {
        System.out.println("Banka hesabı bilgileri doğrulanıyor");

        if (amount <= 0) {
            throw new IllegalArgumentException("Ödeme tutarı 0'dan büyük olmalı.");
        }
        if (accountNumber.length() < 10) {
            throw new IllegalArgumentException("Hesap numarası geçersiz.");
        }

        System.out.println("Banka: " + bankName);
        System.out.println("Hesap Sahibi: " + accountHolderName);
    }

    @Override
    public boolean processPayment(double amount) {
        try {
            validatePayment(amount);
            System.out.println("Banka transferi ile " + amount + "TL ödeme işleniyor.");
            // Burada sleep kullanma amacım ödeme işlemi için Banka API'sını simüle etmek. Interrupt olduğu durumda
            try {
                Thread.sleep(3000); // Banka transferi daha uzun sürer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // interrupt flagini true yapar bu da threade lütfen dur der ama tam olarak durdurmaz.
                // Bir interrupt flag bir uyarı niteliği taşır. Default hali false dır.
                System.out.println("Banka transferi kesintiye uğradı.");

            }
            System.out.println();
            System.out.println("Banka transferi başarılı.");
            return true;

        } catch (Exception e) {
            System.out.println("Banka transferi başarısız: " + e.getMessage());

            return false;
        }
    }

    @Override
    public String getPaymentType() {
        return "Banka Transferi";
    }
}
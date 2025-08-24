package main.java.patterns.factory;

public class PayPalPayment implements PaymentMethod {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void validatePayment(double amount) {
        System.out.println("PayPal hesabı bilgileri doğrulanıyor");

        if (amount <= 0) {
            throw new IllegalArgumentException("Ödeme tutarı 0'dan büyük olmalı.");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("E-mail adresi geçersiz.");
        }

        System.out.println("E-mail: " + email);
    }

    @Override
    public boolean processPayment(double amount) {
        try {
            validatePayment(amount);
            System.out.println("PayPal ile " + amount + "TL ödeme işleniyor.");
            // Burada sleep kullanma amacım ödeme işlemi için PayPal API'sını simüle etmek. Interrupt olduğu durumda
            try {
                Thread.sleep(1500); // PayPal genellikle daha hızlı
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // interrupt flagini true yapar bu da threade lütfen dur der ama tam olarak durdurmaz.
                // Bir interrupt flag bir uyarı niteliği taşır. Default hali false dır.
                System.out.println("PayPal ödeme işlemi kesintiye uğradı.");

            }
            System.out.println();
            System.out.println("PayPal ödemesi başarılı.");
            return true;

        } catch (Exception e) {
            System.out.println("PayPal ödemesi başarısız: " + e.getMessage());

            return false;
        }
    }

    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}


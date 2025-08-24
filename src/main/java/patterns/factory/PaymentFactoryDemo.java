package main.java.patterns.factory;

public class PaymentFactoryDemo {
    public static void main(String[] args) {
        // E-ticaret processor'ı oluştur
        ECommerceProcessor processor = new ECommerceProcessor();

        System.out.println("FACTORY PATTERN ÖDEMe SİSTEMİ DEMO");
        System.out.println("====================================");

        try {
            // Test 1: Kredi Kartı ödemesi
            System.out.println("\nTest 1: Kredi Kartı Ödemesi");
            PaymentMethod creditCard = PaymentFactory.createCreditCardPayment(
                    "1234567890123456",
                    "Durmaz Dursun",
                    "12/25",
                    "123"
            );
            processor.processOrder(creditCard, 299.99, "ORD-001");

            // Test 2: PayPal ödemesi
            System.out.println("\nTest 2: PayPal Ödemesi");
            PaymentMethod paypal = PaymentFactory.createPayPalPayment(
                    "kullanici@email.com",
                    "supersecretpassword"
            );
            processor.processOrder(paypal, 149.50, "ORD-002");

            // Test 3: Banka Transferi
            System.out.println("\nTest 3: Banka Transferi");
            PaymentMethod bankTransfer = PaymentFactory.createBankTransferPayment(
                    "Ziraat Bankası",
                    "1234567890123",
                    "Mehmet Kurtaran"
            );
            processor.processOrder(bankTransfer, 999.00, "ORD-003");

            // Test 4: Hatalı ödeme tutarı ile test
            System.out.println("\nTest 4: Hatalı Tutar Testi");
            PaymentMethod testCard = PaymentFactory.createCreditCardPayment(
                    "1234567890123456",
                    "Test User",
                    "12/25",
                    "123"
            );
            processor.processOrder(testCard, -100, "ORD-004"); // Negatif tutar

            // Test 5: Geçersiz kart numarası ile test
            System.out.println("\nTest 5: Geçersiz Kart Numarası Testi");
            PaymentMethod invalidCard = PaymentFactory.createCreditCardPayment(
                    "123456789", // Kısa kart numarası
                    "Test User",
                    "12/25",
                    "123"
            );
            processor.processOrder(invalidCard, 50.0, "ORD-005");

        } catch (Exception e) {
            System.err.println("Hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }

        // Factory Pattern'in avantajlarını göster
        System.out.println("\n" + "=".repeat(60));
        System.out.println("FACTORY PATTERN AVANTAJLARI");
        System.out.println("=".repeat(60));
        System.out.println("Nesne yaratma mantığı tek yerde toplandı (PaymentFactory)");
        System.out.println("Yeni ödeme yöntemleri kolayca eklenebilir");
        System.out.println("stemci kodu (ECommerceProcessor) somut sınıfları bilmiyor");
        System.out.println("Kod daha esnek ve sürdürülebilir");
        System.out.println("Enum ile type safety sağlandı");
        System.out.println("Convenience methods ile kullanım kolaylaştırıldı");
        System.out.println("Polymorphism sayesinde tek interface ile tüm ödeme türleri yönetiliyor");
        System.out.println("=".repeat(60));
    }}
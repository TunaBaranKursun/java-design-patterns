package main.java.patterns.factory;

public class ECommerceProcessor {


        // Ana işlem methodu - Ödeme işlemini başlatır ve sonuçlarını yönetir
        public boolean processOrder(PaymentMethod paymentMethod, double amount, String orderNumber) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("Sipariş İşleme Başlatıldı");
            System.out.println("Sipariş No: " + orderNumber);
            System.out.println("Tutar: " + amount + " TL");
            System.out.println("Ödeme Yöntemi: " + paymentMethod.getPaymentType());
            System.out.println("=".repeat(50));

            // Ödeme işlemini başlat - bu kısım polymorphism sayesinde hangi sınıf olduğunu bilmeden çalışır
            boolean success = paymentMethod.processPayment(amount);

            // Sonuca göre işlem yap
            if (success) {
                System.out.println("Sipariş başarıyla tamamlandı.");
                System.out.println("Onay e-postası gönderildi.");
                // Burada stok güncelleme, kargo hazırlama gibi işlemler yapılabilir
            } else {
                System.out.println("Sipariş iptal edildi.");
                // Burada hata logları, müşteri bilgilendirme gibi işlemler yapılabilir
            }

            System.out.println("=".repeat(50) + "\n");
            return success;
        }
    }


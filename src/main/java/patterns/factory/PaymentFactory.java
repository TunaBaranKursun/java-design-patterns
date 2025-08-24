package main.java.patterns.factory;

// Factory sınıfı - Ödeme yöntemlerini yaratır
class PaymentFactory {

    // Enum ile ödeme türlerini tanımlıyoruz - Type Safety için
    public enum PaymentType {
        CREDIT_CARD, PAYPAL, BANK_TRANSFER
    }

    // Ana factory method - Ödeme türüne göre uygun sınıf örneği döndürür
    public static PaymentMethod createPaymentMethod(PaymentType type, Object... params) {
        switch (type) {
            case CREDIT_CARD:
                // Kredi kartı için 4 parametre beklenir: cardNumber, cardHolderName, expiryDate, cvv
                if (params.length != 4) {
                    throw new IllegalArgumentException("Kredi kartı için 4 parametre gerekli: cardNumber, cardHolderName, expiryDate, cvv");
                }
                return new CreditCardPayment(
                        (String) params[0], // cardNumber
                        (String) params[1], // cardHolderName
                        (String) params[2], // expiryDate
                        (String) params[3]  // cvv
                );

            case PAYPAL:
                // PayPal için 2 parametre beklenir: email, password
                if (params.length != 2) {
                    throw new IllegalArgumentException("PayPal için 2 parametre gerekli: email, password");
                }
                return new PayPalPayment(
                        (String) params[0], // email
                        (String) params[1]  // password
                );

            case BANK_TRANSFER:
                // Banka transferi için 3 parametre beklenir: bankName, accountNumber, accountHolderName
                if (params.length != 3) {
                    throw new IllegalArgumentException("Banka transferi için 3 parametre gerekli: bankName, accountNumber, accountHolderName");
                }
                return new BankTransferPayment(
                        (String) params[0], // bankName
                        (String) params[1], // accountNumber
                        (String) params[2]  // accountHolderName
                );

            default:
                throw new IllegalArgumentException("Desteklenmeyen ödeme türü: " + type);
        }
    }

    public static PaymentMethod createCreditCardPayment(String cardNumber, String cardHolderName,
                                                        String expiryDate, String cvv) {
        return createPaymentMethod(PaymentType.CREDIT_CARD, cardNumber, cardHolderName, expiryDate, cvv);
    }

    public static PaymentMethod createPayPalPayment(String email, String password) {
        return createPaymentMethod(PaymentType.PAYPAL, email, password);
    }

    public static PaymentMethod createBankTransferPayment(String bankName, String accountNumber,
                                                          String accountHolderName) {
        return createPaymentMethod(PaymentType.BANK_TRANSFER, bankName, accountNumber, accountHolderName);
    }
}

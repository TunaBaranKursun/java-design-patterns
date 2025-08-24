package main.java.patterns.factory;

public class CreditCardPayment implements PaymentMethod{
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    private String maskCardNumber(String cardNumber) {
        return "**** **** **** " + cardNumber.substring(12);
    }



    @Override
    public void validatePayment(double amount){
        System.out.println("Kredi kartı bilgileri doğrulanıyor");

        if(amount <= 0){
            throw new IllegalArgumentException("Ödeme tutarı 0'dan büyük olmalı.");
        }
        if(cardNumber.length() != 16){
            throw new IllegalArgumentException("Kart numarası geçersiz.");
        }

        System.out.println("Kart No: "+ maskCardNumber(cardNumber));
        System.out.println("Kart Sahibi" + cardHolderName);
    }

    @Override
    public boolean processPayment(double amount) {

        try {
            validatePayment(amount);
            System.out.println("Kredi kartından " + amount + "TL ödeme işleniyor.");
            //Burada sleep kullanma amacım ödeme işlemi için kredi kartı API ını simüle etmek. Interrupt olduğu durumda

            try
            {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();//interrupt flagini true yapar bu da threade lütfen dur der ama tam olarak durdurmaz. Bir interrupt flag bir uyarı niteliği taşır.
                //default hali false dır.
                System.out.println("Ödeme işlemi kesintiye uğradı.");
            }
            System.out.println();
            System.out.println("Kredi kartı ödemesi başarılı.");
            return true;

        }catch (Exception e){
            System.out.println("Kredi kartı ödemesi başarısız: " + e.getMessage());
            return false;
        }
    }
    @Override
    public String getPaymentType(){
        return "Kredi Kartı";
    }

}

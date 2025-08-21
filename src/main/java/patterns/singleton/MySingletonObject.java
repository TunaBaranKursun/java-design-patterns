package main.java.patterns.singleton;
//Lazy singleton eager için obje direkt bir method çağrılmadan oluşturulmalı
public class MySingletonObject {
    private static MySingletonObject mySingletonObject;

    private String singletonString;
    private double singletonDouble;

    //Constructor private dışardan kontrolsüz obje oluşturmayı engellemek için
    private MySingletonObject() {
        this.singletonString = singletonString;
        this.singletonDouble = singletonDouble;
    }

    //synchronized thread safety sağlar
    public static synchronized MySingletonObject getInstance() {
        if (mySingletonObject == null) {
            mySingletonObject = new MySingletonObject();
            System.out.println("Obje yaratılmıştır");
        }else
            System.out.println("Hali hazırda bir objeniz var yeni bir tane oluşturmak için reset methodunu kullanınız.");
        return mySingletonObject;
    }

    public void showInfoOfSingleton(){
        System.out.println("Singleton string : "+singletonString);
        System.out.println("Singleton double : "+singletonDouble);
        System.out.println("Tüm bilgiler bu kadar.");
    }






    public String getSingletonString() {
        return singletonString;
    }

    public void setSingletonString(String singletonString) {
        this.singletonString = singletonString;
    }

    public double getSingletonDouble() {
        return singletonDouble;
    }

    public void setSingletonDouble(double singletonDouble) {
        this.singletonDouble = singletonDouble;
    }
}


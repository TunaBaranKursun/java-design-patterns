package main.java.patterns.singleton;

public class MySingletonMain {
    public static void main(String[] args) {
        System.out.println("=== İlk Singleton Oluşturma ===");
        MySingletonObject s1 = MySingletonObject.getInstance();
        s1.setSingletonDouble(35.55);
        s1.setSingletonString("Singleton Object 1");

        System.out.println("\n=== Aynı Singleton'ı Yeni Referans ile Alma ===");
        MySingletonObject s2 = MySingletonObject.getInstance();
        s2.setSingletonDouble(66.33);
        s2.setSingletonString("Singleton Object 2");

        System.out.println("\n=== İlk ve İkinci Referans ile Bilgi Göster ===");
        s1.showInfoOfSingleton();
        s2.showInfoOfSingleton();

        if(s1==s2)
            System.out.println("s1 ve s2 referansları aynı nesneyi gösteriyor");
        else
            System.out.println("s1 ve s2 farklı nesneler");




    }
}

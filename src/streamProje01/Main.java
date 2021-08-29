package streamProje01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static List<Ogrenci> ogrListesi = new ArrayList<>();


    public static void main(String[] args) {

        testOgrenciOlustur(); // ogrencileri olusturduk methodla
        ismeGoreListele("ahmet"); // ahmetin nesnesini getir diye method yaptık
        ismeGoreListele("ayse");
        ismeGoreListele("john");

        System.out.println("soyismi can olan kisiler");
        soyIsmeGoreListele("can");
        System.out.println("cinsiyeti kadin olan kisiler");
        cinsiyeteGoreListele("kadin");
        System.out.println("diplama notuna gore kisilerin sirasi");
        notaGoreSirala();
        System.out.println("kisilerin yasina gore sirasi");
        yasaGoreSirala();
        System.out.println("sinif ortalamasi");
        //sinifOrtalamasiHesapla();
    }

    //private static void sinifOrtalamasiHesapla(){
      //  ogrListesi.stream()
    //}

    private static void yasaGoreSirala(){
        ogrListesi.stream().sorted(Comparator.comparing(Ogrenci::getYas)).forEach(System.out::println);
    }

    private static void cinsiyeteGoreListele(String cinsiyet){
        ogrListesi.stream().filter(t->t.getCinsiyet().equalsIgnoreCase(cinsiyet)).forEach(System.out::println);
    }

    private static void notaGoreSirala(){
        ogrListesi.stream().sorted(Comparator.comparing(Ogrenci::getDiplomaNotu)).forEach(System.out::println);
    }

    private static void soyIsmeGoreListele(String soyisim){
        ogrListesi.stream().filter(t-> t.getSoyad().equalsIgnoreCase(soyisim)).forEach(System.out::println);
    }

    private static void ismeGoreListele(String isim){
        ogrListesi.stream().filter(t-> t.getAd().equalsIgnoreCase(isim)).forEach(System.out::println);
    }

    private static void testOgrenciOlustur(){

        ogrListesi.add(new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ayse", "Can", 21, 82.3, "kadin"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ayse", "Yilmaz", 40, 45, "kadin"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "ozturk", 20, 95.5, "erkek"));


    }
}

package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Stream04String {
    public static void main(String[] args) {

    List<String> liste = new ArrayList<>();
           liste.add("Ali");
           liste.add("Mark");
           liste.add("Jackson");
           liste.add("Amanda");
           liste.add("Mariano");
           liste.add("Alberto");
           liste.add("Tucker");
           liste.add("Christ");
           liste.add("Alfonso");
           liste.add("Alonzo");
           liste.add("Alihano");

           aIleBaslayanlar(liste);
        System.out.println("========");
           buyukHarfeCevir(liste);
        System.out.println("========");
        uzunlugaGoreSiralaKucult(liste);
        System.out.println("========");
        uzunlugaGoreYazdir(liste,3);
        System.out.println("========");
        System.out.println("tum elemanlar belirtilen degerden kucuk: " + uzunlukKucukMu(liste,9));
        System.out.println("baslayan yok mu " + baslamayanHArfVarMi(liste,"M"));
        System.out.println("biten harf var mi " + herhangiBitenElemanVarMi(liste,"a"));
        System.out.println("========");
        aIleOYazdir(liste);
        System.out.println("========");
        listeleYazdir(liste);
        System.out.println("========");
        kucukBuyukHarf(liste);

    }
  //listedeki bas harfi a ile baslayan isimleri
    // yazdiran methodu tanimlayalim

public static void aIleBaslayanlar(List<String> liste) {
        liste.stream().filter(h -> h.startsWith("A")).forEach(System.out::println);
}

    public static void buyukHarfeCevir(List<String> liste) {
        liste.stream().map(h -> h.toUpperCase()).forEach(System.out::println);
    }
//listedeki tum elemanlari uzunluklarina gore siralayan ve
// kucuk harfe ceviren methodu tanimlayalim
    public static void uzunlugaGoreSiralaKucult(List<String> liste){
        liste.stream().sorted(Comparator.comparing(t -> t.length())).
                map(t->t.toLowerCase()).forEach(System.out::println);
    }
    //listedeki elemanlarin uzunluklari , belirtilen uzunluktan
    // fazla olanlari yazdiran methodu tanimlayin

    public static void uzunlugaGoreYazdir(List<String> liste, int uzunluk) {
        liste.stream().filter(t-> t.length()>uzunluk).forEach(System.out::println);
    }
    //listedeki tum elemanlarin uzunluklari belirtilen uzunluktan
    //kucuk mu diye kontrol eden method yaziniz
    public static boolean uzunlukKucukMu(List<String> liste, int uzunluk){
return liste.stream().
        allMatch(t-> t.length()<uzunluk); //icinde belirtilen sarta gore butun elemanlara bakiyor bi tanesi saglamazsa bile false veriyo
    }
    //listedeki tum elemanlarin belirtilen harf ile baslayıp baslamadigini
    //kontrol eden method
    public static boolean baslamayanHArfVarMi(List<String> liste, String harf){
        return liste.stream().noneMatch(t-> t.startsWith(harf));

        //allmatch : belirtilen sartlari tum elemanlar sagliyorsa true dondurur
        //nonemstch: belirtilen sartlari tum elemanalr saglamiyorsa true donduruur

    }
    // anyMatch () : herhangi bir sartin saglanip saglanmamasina bakar,
// sart bir defa saglaniyorsa true dondurur, hic sagmanmiyorsa false


    //listedeki herhangi bir eleman BELİRTİLEN BİR HARF İLE bitiyor mu diye kontrol edilen methodu yaziniz
    public static boolean herhangiBitenElemanVarMi (List<String> liste, String harf){
        return liste.stream().anyMatch(t-> t.endsWith(harf));
    }
//a ile baslayip o ile biten elemanlari yazdiran method tanimlayiniz
public static void aIleOYazdir(List<String> liste) {
        liste.stream().
                filter(x->x.startsWith("A") && x.endsWith("o")).
                forEach(System.out::println);
}

// asagidaki formata gore listedeki her bir elemanin uzunlugunu yazdiram method
    // Ali: 3      Mark:4    Amanda: 6 gibi
    public static void listeleYazdir(List<String> liste){
        liste.stream().sorted(Comparator.comparing(String::length)).//t -> t.length()
                map(t-> t+":"+t.length()+"\t").forEach(System.out::print);
    }
    public static void kucukBuyukHarf(List<String> liste){
        liste.stream().map(String::toLowerCase).//hepsini kucuk harfe cevirir
                filter(t-> t.startsWith("a")).forEach(System.out::println);
    }

}

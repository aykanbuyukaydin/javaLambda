package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03Integer {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(-2);
        liste.add(-1);
        liste.add(4);
        liste.add(12);
        liste.add(15);
        liste.add(500);
        liste.add(-15);

        System.out.println("en buyuk deger " + buyukBul(liste));
        System.out.println("en buyuk deger " + buyukBul1(liste));
        System.out.println("en buyuk deger " + buyukBul2(liste));
        System.out.println("en kucuk deger " + kucukBul(liste));
        System.out.println("carpim deger " + carpimBul(liste));
        System.out.println("say " + dokuzSay(liste));
        System.out.println("negatif liste " + negatifSayiListesi(liste));
        //yada
        List<Integer> negatifler = negatifSayiListesi(liste);
        System.out.println("negatifler listi " + negatifler);

        System.out.println("tek sayilarin sirali karesi " + tekKareSiraliListele(liste));
    }

    public static int buyukBul (List<Integer> liste) {
        return liste.stream().reduce(0,(x,y) -> x>y ? x:y);
    }
    public static int buyukBul1 (List<Integer> liste) {
        return liste.stream().reduce(0, Math::max);
    }
    public static int buyukBul2 (List<Integer> liste) {
        return liste.stream().sorted().reduce(0, (x,y) -> y );
    }
    public static int kucukBul (List<Integer> liste) {
        return liste.stream().reduce(0, (x,y) -> x<y ? x:y );
    }
    public static int carpimBul (List<Integer> liste) {
        return liste.stream().reduce(1, (x,y) ->  x*y );
    }
    //liste icerisinde kac tane 9 sayisi bulunmaktadir ,
    // bunu bulan bir method yazalim
    public static int dokuzSay (List<Integer> liste) {
       return (int) liste.stream().filter(x -> x == 9).count();
    }

    //listedeki negatif sayilari ayri bir liste
    //olarak donduren bir method yazalim

    public static List<Integer> negatifSayiListesi (List<Integer> liste) {
        return liste.stream().filter(x -> x <0).collect(Collectors.toList());
        // kalıcı olarak listi olusturur Collectors.toList()
    }

    // listedeki tek elemanlarin karelerini sirali ve tekrarsiz
    //bir sekilde listeye kaydeden methodu yaziniz

    public static List<Integer> tekKareSiraliListele(List<Integer> liste){
       return liste.
               stream().
               distinct().
               filter(Methodlar::tekMi).
               map(x -> (int) Math.pow(x,2)). // x taban 2 ust // hali hazirda varsa method referansi alinablir yada //x -> x*x
               sorted(Comparator.reverseOrder()). // ici bos olsa dogal siralama yapar ama bizim yazdigimiz ters sirala
               collect(Collectors.toList());
    }

}

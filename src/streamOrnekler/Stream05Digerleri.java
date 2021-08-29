package streamOrnekler;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.*;

public class Stream05Digerleri {
    public static void main(String[] args) {
        // ÖRNEK: 1'den belirtilen değere kadar olan tamsayıları toplayan
        // ve sonucu döndüren metodu yazınız.

        System.out.println("toplam: " + topla(4)); // 4 dahil olmuyor 1+2+3
        System.out.println("toplam: " + topla1(4)); // 4 dahil oluyor 1+2+3+4
        topla2(4);
        System.out.println("========");
        tekTopla(1,7);
        System.out.println("faktoriyel: " + faktoriyel(10));
        System.out.println("faktoriyel: " + faktoriyel1(34));
        System.out.println("faktoriyel: " + faktoriyel2(34));
        System.out.println("50 den buyuk not listem: " + doubleDizidenCevirList());

    }

    public static int topla(int deger){
       return IntStream.range(1,deger).sum(); // range aralik demek
    }
    public static int topla1(int deger){
        return IntStream.rangeClosed(1,deger).sum(); // rangeClodsed araliklar ikiside dahil demek

    }
    public static void topla2(int deger){
        IntStream.rangeClosed(1,deger).forEach(System.out::println);

    }
//belirtilen degerler arasindaki tek asayilari toplayalim
    public static void tekTopla(int alt, int ust){
        System.out.println(IntStream.rangeClosed(alt,ust).filter(Methodlar::tekMi).sum());
    }
    //Instream.of kendimiz ınt olusturabiliyoruz

    //belirtilen sayinin faktoreyelini hesaplayan ethodu yaziniz
    public static Integer faktoriyel (int n){
//return IntStream.rangeClosed(1,n).reduce(1,(x,y)->x*y);
   return IntStream.iterate(1,t->t+1).limit(n).reduce(1,(x,y)-> x*y);
    }

    public static Long faktoriyel1 (int n){
        return LongStream.rangeClosed(1,n).reduce(1,(x, y)->x*y);
    }
    public static double faktoriyel2 (int n){
        return DoubleStream.iterate(1,t->t+1).limit(n).//baslangıc degeri ve artma miktari .limit bittigi yer belirt
        reduce(1,(x,y) -> x*y);

    }
    //Bir double diziyi (notlar) Stream nesnesine dönüştürerek
    // bu dizi içerisinde bulunan
// sayıların 50 den büyük olanlarını ayrı bir listeye kaydererek
// yazdıran metodu tanımlayınız
    public static List<Double> doubleDizidenCevirList(){
        Double[] notlar = {88.5, 52.3, 88.9, 100.0, 99.6, 42.0, 10.0};

        Stream<Double> streamNotlar = Stream.of(notlar);
        //biz elimizdeki diziyi stream.of methoduyla caırıp, stream a ceviriyoruz
        //.stream diye ceviremeyiz

        return streamNotlar.filter(t -> t>50).collect(Collectors.toList());
// filter(..).skip(3) dersen filterin ilk 3 elemani alma demis oluruz
    }
}

package streamOrnekler;

import java.util.ArrayList;
import java.util.List;

public class Stream01Integer {
    public static void main(String[] args) {
        List<Integer> rakamlar = new ArrayList<>();
        rakamlar.add(5);
        rakamlar.add(7);
        rakamlar.add(7);
        rakamlar.add(9);
        rakamlar.add(-1);
        rakamlar.add(2);
        rakamlar.add(4);
        rakamlar.add(-1000);
        rakamlar.add(4);
        rakamlar.stream().filter(t -> t%2!=0).forEach(System.out::println);
        //yada burdadad cifleri yazdiralim
        System.out.println("========");
        rakamlar.stream().filter(t -> t%2==0).forEach(x -> System.out.println(x));
        //yada method referansı ile yapalim tekliyi
        rakamlar.stream().filter(t -> t%2!=0).forEach(Stream01Integer::yazdir);
        //yada tek icin
        System.out.println("========");
        rakamlar.stream().filter(Stream01Integer::tekMi).forEach(Stream01Integer::yazdir);

        System.out.println("=============");
        cifleriYazdir(rakamlar);




    }

    public static void cifleriYazdir(List<Integer> liste){  // cifleri yazdiracak bir fonksiypnel olusturduk
//liste.stream().filter(x-> x%2==0).forEach(x -> System.out.print(x + " "));
        //method referansi ile yapalim
        liste.stream().filter(Stream01Integer::ciftMi).forEach(Stream01Integer::yazdir);
    }

    public static boolean ciftMi(int x){
        return x%2==0;
    }

    public static void yazdir (int x) {
        System.out.print(x + " ");
    }
    public static boolean tekMi(int x) {
        return x%2!=0;
    }


}

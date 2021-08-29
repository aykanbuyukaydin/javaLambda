package streamOrnekler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

public class Stream06Files {
    //Files.lines(path.of(" bir patch belirtip buraya dosyayi cekebiliri"))
    public static void main(String[] args) throws IOException {
//mars sag tık patch copy -patch from content root
        String patch="src/streamOrnekler/mars.txt"; //yapalim kolaylik olsun diye

        Files.lines(Path.of("src/streamOrnekler/mars.txt"));
        //ya dosyayi bulamazsam icin diye exception veriyor
        //oi parent oldugu icin ya okuyamzsayi da kapsayor

        Stream<String> satirlar =  Files.lines(Path.of("src/streamOrnekler/mars.txt"));
        satirlar.forEach(System.out::println);
        System.out.println("=========================");

        //bu mars icindeki herseyi buyuk karf olarak yazdiralım
       // satirlar.map(t->t.toUpperCase()).forEach(System.out::println);
    //hata verir cunku streamlar bir keree kullanilir biter daha kullanamayiz
        Files.lines(Path.of("src/streamOrnekler/mars.txt")).
                map(t->t.toUpperCase()).forEach(System.out::println);
        //satirda streamindan degil direk olrak dosyayi alip yaptik mecbur

        //her defasinda patch al yapistir yapacagima bir string olarak tanimlayabilirim
        //(en ustte yaptim)

        System.out.println("===========");
        //dosyadan sadeec ilk satiri okuyarak buyuk harfle yazdiralim
        Files.lines(Path.of(patch)).limit(1).map(t->t.toUpperCase()).forEach(System.out::println);
        //limit(5) ilk 5 i al, skip(2) ilk 2 yi alma
        System.out.println("======");
    //3 ve 4 satiri almak istiyorum
        Files.lines(Path.of(patch)).
                skip(2).limit(2).
                forEach(System.out::println);

        System.out.println("==========");
        //"bu" kelimesi dosyada kac defa geciyor satirda (her satiri bir eleman olarak almıs oluyoruz)
        System.out.println(Files.lines(Path.of(patch)).map(String::toLowerCase).filter(x->x.contains("bu")).count());

        System.out.println("==========");
        //dosyadaki tum farkli kelimeleri alt alta yazdiralim bide kucuk harfe cevirelim
        Files.lines(Path.of(patch)).map(t->t.toLowerCase().split(" ")).
                flatMap(Arrays::stream). //kelimeleren olusan tek bir list olmus oldu
                distinct(). // farkliliklari aliyor
                forEach(System.out::println);
        //ic ice nestesd olan ycollectionlari tek colletion hale getiriyor: flatmap


        System.out.println("=========");
        //kelimelr icindeki m veya M harfi olanlari sayalim ve yazdiralim
       long mSayisi= Files.lines(Path.of(patch)).map(x->x.toLowerCase().split(" ")).flatMap(Arrays::stream).filter(t->t.contains("m")).count();
        System.out.println(mSayisi);
    //bosluk ve noktalam isaretleri haric dosyada kac adet karakter
        //kullanildigini hesaplayarak sonucu yazdiralim
        // \\W "a-z" ve "A-Z" ve "0-9" ve "_" haric tum karakterler demektir
        System.out.println(Files.lines(Path.of(patch)).map(t->t.replace("_","").replaceAll("\\W","").split("")).
                flatMap(Arrays::stream).count());

    }


}

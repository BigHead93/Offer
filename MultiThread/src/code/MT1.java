package code;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class MT1 {
    public volatile int inc = 0;
    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
//        final MT1 test = new MT1();
//        for(int i=0;i<10;i++){
//            new Thread(){
//                public void run() {
//                    for(int j=0;j<100;j++)
//                        test.increase();
//                };
//            }.start();
//        }
//
//        if(Thread.activeCount()>1)  //保证前面的线程都执行完
//            Thread.yield();
//        System.out.println(test.inc);
//        String a = "测试长度";
//        String b = "test";
//        System.out.println(a.length());
//        System.out.println(b.length());

//        Locale locale = new Locale("English");
//        Locale[] locales = Locale.getAvailableLocales();
//        for(int i = 0; i < locales.length; i++) {
//            System.out.println(locales[i].getDisplayCountry() + " | "
//                    + locales[i].getDisplayCountry(locale) + " | "
//                    + locales[i].getCountry() + " | "
//                    + locales[i].toString());
//        }


        System.out.println(LocalDateTime.now().toString().length());

    }


}

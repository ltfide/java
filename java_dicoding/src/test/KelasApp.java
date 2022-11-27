package test;

import com.dicoding.oop.modifier.KelasA;

public class KelasApp {
    public static void main(String[] args) {
//        KelasA kelasAaa = new KelasA();
//        System.out.println(kelasAaa.memberB);
        System.out.println(KelasA.nilai);

        for (int i = 0; i < 5; i++) {
            new KelasA();
        }

        System.out.println(KelasA.nilai);
    }
}

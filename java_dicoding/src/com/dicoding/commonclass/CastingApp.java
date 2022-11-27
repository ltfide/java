package com.dicoding.commonclass;

public class CastingApp {
    public static void main(String[] args) {

        int x = (int) 3.4;
        System.out.println(x);

        String myString = String.valueOf(3213);
        System.out.println(myString);

        Kucing anggora = new Kucing();
        anggora.meow();

        Hewan hewan = anggora;
        hewan = (Hewan) anggora;
        hewan.makan();

        Hewan hewan1 = new Kucing();
        ((Kucing) hewan1).meow();

    }
}


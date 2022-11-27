package com.dicoding.oop.modifier;

public class KelasA {
    private int memberA = 5;
    public char memberB = 'A';
    double memberC = 1.5;
    public static int nilai = 1;

    public KelasA() {
        nilai++;
    }

    private int functionA() {
        return memberA;
    }

    int functionB() {
        // pemanggilan private member dan private function
        int hasil = functionA() + memberA;
        return hasil;
    }
}

class KelasApp {
    public static void main(String[] args) {
        KelasA kelasAa = new KelasA();
        System.out.println(kelasAa.functionB());
//        System.out.println(kelasAa.memberA); error
        System.out.println(kelasAa.memberC);
    }
}

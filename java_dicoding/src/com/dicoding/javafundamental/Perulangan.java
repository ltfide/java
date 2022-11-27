package com.dicoding.javafundamental;

public class Perulangan {
    public static void main(java.lang.String[] args) {
        // for
        int firstValue = 1;
        int lastValue = 3;
//        for (int i = firstValue; i <= lastValue; i++) {
//            System.out.println("The value is " + i);
//        }

        // nested for
//        for (int i = firstValue; i <= lastValue; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println("");
//        }

        // while
//        while (firstValue <= lastValue) {
//            System.out.println("The value is " + firstValue);
//            firstValue++;
//        }

        do {
            System.out.println("The value is " + firstValue);
            firstValue++;
        } while (firstValue <= lastValue);
    }
}

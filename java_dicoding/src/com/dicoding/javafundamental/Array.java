package com.dicoding.javafundamental;

public class Array {
    public static void main(java.lang.String[] args) {
        // Cara 1
//        int[] arrInt = new int[]{1,2,3,4,5,6};
//        System.out.println(arrInt[0]);
//        System.out.println(arrInt[1]);
//        System.out.println(arrInt[2]);
//        System.out.println(arrInt[3]);
//        System.out.println(arrInt[4]);

        // Cara 2
//        int[] arrInt = new int[6];
//        arrInt[0] = 1;
//        arrInt[1] = 2;
//        arrInt[2] = 3;
//        arrInt[3] = 4;
//        arrInt[4] = 5;
//        arrInt[5] = 6;

        // Cara 3
        int[] arrInt = {1,2,3,4,5,6};

        for (int value : arrInt) {
            System.out.println(value);
        }
    }
}

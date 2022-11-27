package com.dicoding.javafundamental;

import java.util.Scanner;

public class InputOutputFunction {
    public static void main(java.lang.String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program penjumlahan sangat sederhana");
        System.out.print("Masukkan Angka pertama : ");
        int value = scanner.nextInt();
        System.out.print("Masukkan Angka kedua : ");
        int anotherValue = scanner.nextInt();
        int result = value + anotherValue;
        System.out.println("Hasilnya adalah : " + result);
    }
}

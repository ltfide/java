package com.dicoding.studikasus;

import java.util.Scanner;

public class ImplementasiFor {
    public static void main(String[] args) {

        String keyword = "";
        int vokal = 0;
        int konsonan = 0;

        System.out.print("Masukkan Keyword: ");
        Scanner scanner = new Scanner(System.in);
        keyword = scanner.next();

        vokal = numVokal(keyword);
        konsonan = numKonsonan(keyword);

        System.out.println("Sum of vokal: " + vokal);
        System.out.println("Sum of konsonan: " + konsonan);

    }

    public static int numVokal(String keyword) {
        int result = 0;
        for (int i = 0; i < keyword.length(); i++) {
            if (keyword.charAt(i) == 'a' || keyword.charAt(i) == 'i' || keyword.charAt(i) == 'u' || keyword.charAt(i) == 'e' || keyword.charAt(i) == 'o') {
                result++;
            }
        }
        return result;
    }

    public static int numKonsonan(String keyword) {
        int result = 0;
        for (int i = 0; i < keyword.length(); i++) {
            if (keyword.charAt(i) != 'a' && keyword.charAt(i) != 'i' && keyword.charAt(i) != 'u' && keyword.charAt(i) != 'e' && keyword.charAt(i) != 'o') {
                result++;
            }
        }
        return result;
    }

}

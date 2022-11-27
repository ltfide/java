package com.dicoding.studikasus;

import java.util.Scanner;

public class ImplementasiIf {
    public static void main(String[] args) {

        int T;

        System.out.print("Suhu (der.C) = ");

        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        if (T < 0) {
            System.out.println("Wujud air Beku " + T);
        } else if (0 < T && T <= 100) {
            System.out.println("Wujud air cair " + T);
        } else if (T > 100) {
            System.out.println("Wujud air gas " + T);
        }

    }
}

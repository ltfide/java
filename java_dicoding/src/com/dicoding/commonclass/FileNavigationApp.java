package com.dicoding.commonclass;

import java.io.File;

public class FileNavigationApp {
    public static void main(String[] args) {

        String dirname = "/java/latihan1";
        File file = null;
        String[] paths;

        try {
            // instansiasi objek file
            file = new File(dirname);

            // ambil list files dan masukkan ke string paths
            paths = file.list();

            // tampilkan semua path yang ada
            for (String path : paths) {
                System.out.println(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

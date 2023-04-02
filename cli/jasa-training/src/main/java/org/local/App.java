package org.local;

import java.util.Scanner;

import org.local.entity.DaftarPelajaran;
import org.local.entity.User;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            User user = new User();
            DaftarPelajaran kursus = new DaftarPelajaran();

            System.out.print("\t\tWelcome to Course-Net");
            System.out.print("\n\t\t=====================\n");

            System.out.print("Masukan nama lengkap anda\t: ");
            user.setNamaLengkap(sc.nextLine());

            System.out.print("Masukan alamat anda\t\t: ");
            user.setAlamat(sc.nextLine());

            System.out.print("Masukan kode pos anda\t\t: ");
            user.setKodePos(sc.nextLine());

            System.out.print("Masukan provinsi anda\t\t: ");
            user.setProvinsi(sc.nextLine());

            System.out.print("Masukan no telepon anda\t\t: ");
            user.setNoTelp(sc.nextLine());

            System.out.print("\nHello " + user.getNamaLengkap() + ",\n");
            System.out.println("List program pembelajaran yang tersedia [1 untuk ambil / 0 untuk tidak] : \n");

            System.out.printf("Algoritma dan Pemrograman (Rp. %s)\t : ", DaftarPelajaran.HARGA_ALGORITHM_PEMROGRAMAN);
            kursus.setAlgoritmaDanPemrograman(sc.nextInt());

            System.out.printf("Database System (Rp. %s)\t\t : ", DaftarPelajaran.HARGA_DATABASE_SYSTEM);
            kursus.setDatabaseSystem(sc.nextInt());

            System.out.printf("Computer Network (Rp. %s)\t\t : ", DaftarPelajaran.HARGA_COMPUTER_NETWORK);
            kursus.setComputerNetwork(sc.nextInt());

            System.out.printf("OOP (Rp. %s)\t\t\t : ", DaftarPelajaran.HARGA_OOP);
            kursus.setOop(sc.nextInt());

            System.out.printf("Android (Rp. %s)\t\t\t : ", DaftarPelajaran.HARGA_ANDROID);
            kursus.setAndroid(sc.nextInt());

            System.out.printf("\nNama lengkap\t : %s", user.getNamaLengkap());
            System.out.printf("\nAlamat\t\t : %s", user.getAlamat());
            System.out.printf("\nKode Pos\t : %s", user.getKodePos());
            System.out.printf("\nProvinsi\t : %s", user.getProvinsi());
            System.out.printf("\nNo. Telp\t : %s", user.getNoTelp());

            System.out.printf("\n\nTotal Biaya Kursus : %s", kursus.getTotal());

            System.out.print("\n\n\tTerima kasih telah bergabung dengan Course-Net !!");
            running = false;
        }

        sc.close();
    }
}

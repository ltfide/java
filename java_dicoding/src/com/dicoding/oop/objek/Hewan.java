package com.dicoding.oop.objek;

class Hewan {
    String nama;
    int berat;
    int jumlahKaki;

    Hewan(String nama) {
        this.nama = nama;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public void setJumlahKaki(int jumlahKaki) {
        this.jumlahKaki = jumlahKaki;
    }

    public void cetakNama() {
        System.out.println("Nama Hewan : " + nama);
        System.out.println("Berat Hewan : " + berat);
        System.out.println("Jumlah Kaki Hewan : " + jumlahKaki);
    }
}

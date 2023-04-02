package org.local.entity;

public class DaftarPelajaran {

    public final static Integer HARGA_ALGORITHM_PEMROGRAMAN = 500000;
    public final static Integer HARGA_DATABASE_SYSTEM = 1000000;
    public final static Integer HARGA_COMPUTER_NETWORK = 1500000;
    public final static Integer HARGA_OOP = 2000000;
    public final static Integer HARGA_ANDROID = 2500000;

    private Integer algoritmaDanPemrograman;
    private Integer databaseSystem;
    private Integer computerNetwork;
    private Integer Oop;
    private Integer android;

    private Integer total = 0;

    public DaftarPelajaran() {
    }

    public DaftarPelajaran(Integer algoritmaDanPemrograman, Integer databaseSystem, Integer computerNetwork,
            Integer oop,
            Integer android) {
        this.algoritmaDanPemrograman = algoritmaDanPemrograman;
        this.databaseSystem = databaseSystem;
        this.computerNetwork = computerNetwork;
        this.Oop = oop;
        this.android = android;
    }

    public Integer getAlgoritmaDanPemrograman() {
        return algoritmaDanPemrograman;
    }

    public void setAlgoritmaDanPemrograman(Integer algoritmaDanPemrograman) {
        this.algoritmaDanPemrograman = algoritmaDanPemrograman;
        if (algoritmaDanPemrograman == 1) {
            this.total += HARGA_ALGORITHM_PEMROGRAMAN;
        }
    }

    public Integer getDatabaseSystem() {
        return databaseSystem;
    }

    public void setDatabaseSystem(Integer databaseSystem) {
        this.databaseSystem = databaseSystem;
        if (databaseSystem == 1) {
            this.total += HARGA_DATABASE_SYSTEM;
        }
    }

    public Integer getComputerNetwork() {
        return computerNetwork;
    }

    public void setComputerNetwork(Integer computerNetwork) {
        this.computerNetwork = computerNetwork;
        if (computerNetwork == 1) {
            this.total += HARGA_COMPUTER_NETWORK;
        }
    }

    public Integer getOop() {
        return Oop;
    }

    public void setOop(Integer oop) {
        Oop = oop;
        if (oop == 1) {
            this.total += HARGA_OOP;
        }
    }

    public Integer getAndroid() {
        return android;
    }

    public void setAndroid(Integer android) {
        this.android = android;
        if (android == 1) {
            this.total += HARGA_ANDROID;
        }
    }

    public String getTotal() {
        return "Rp. " + this.total + ",-";
    }

}

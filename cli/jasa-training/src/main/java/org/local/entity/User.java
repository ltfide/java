package org.local.entity;

public class User {

    private String namaLengkap;
    private String alamat;
    private String kodePos;
    private String provinsi;
    private String noTelp;

    public User() {
    }

    public User(String namaLengkap, String alamat, String kodePos, String provinsi, String noTelp) {
        this.namaLengkap = namaLengkap;
        this.alamat = alamat;
        this.kodePos = kodePos;
        this.provinsi = provinsi;
        this.noTelp = noTelp;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

}

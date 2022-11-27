package com.dicoding.commonclass;

public class Hewan {
    public void makan() {
        System.out.println("MAKANNNNN");
    }
}

class Kucing extends Hewan {
    @Override
    public void makan() {
        super.makan();
    }

    public void meow() {
        System.out.println("MEOWWWWW");
    }
}
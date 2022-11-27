package com.dicoding.oop.modifier;

import java.io.Serializable;

class TransientType implements Serializable {
    transient int nilaiA;

    double nilaiB;
    String nilaiC;
}

class TransientImpl {
    public static void main(String[] args) {
        TransientType transientType = new TransientType();
        transientType.nilaiA = 10;
        System.out.println(transientType.nilaiA);
    }
}

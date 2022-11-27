package com.dicoding.commonclass;

import java.util.ArrayList;
import java.util.Collection;

public class WildCardAndGenerics {
    // menggunakan wildcards
    static void print(Collection<?> collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }

    // menggunakan generic methods
    static <T> Collection arrayToCollection(T[] a) {
        Collection<T> c = new ArrayList<>();
        for (T o : a) {
            System.out.println(o);
        }
        return c;
    }

    public static void main(String[] args) {
        String[] sa = {"Satu", "Dua"};
        Collection r = arrayToCollection(sa);
        print(r);
    }

}

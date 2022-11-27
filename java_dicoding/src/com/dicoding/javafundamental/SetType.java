package com.dicoding.javafundamental;

import java.lang.String;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetType {
    public static void main(String[] args) {
        Set<String> planets = new HashSet<>();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Earth");
        planets.add("Earth");
        planets.add("Mars");

        // method size() untuk mendapatkan ukuran Set
        System.out.println("Set planets awal : (size = " + planets.size() + ")");
        for (String planet : planets) {
            System.out.println("\t" + planet);
        }

        planets.remove("Venus");

        System.out.println("Set planets akhir : (size = " + planets.size() + ")");
        for (Iterator iterator = planets.iterator(); iterator.hasNext();) {
            // looping menggunakan Iterator
            System.out.println("\t" + iterator.next());
        }
    }
}

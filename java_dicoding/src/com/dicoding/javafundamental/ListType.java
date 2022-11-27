package com.dicoding.javafundamental;

import java.util.ArrayList;
import java.util.List;

public class ListType {
    public static void main(java.lang.String[] args) {
        // deklarasi array
        String[] heroes = new String[2];
        heroes[0] = "Batman";
        heroes[1] = "Superman";
        for (String value : heroes) {
            System.out.println(value);
        }

        // menggunakan array list
        List<String> planets = new ArrayList<>();
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");

        System.out.println("List planets awal :");
        for (String planet : planets) {
            System.out.println(planet);
        }

        // to remove object from list
        planets.remove("Venus");

        System.out.println("List planets akhir :");
        for (String planet : planets) {
            System.out.println(planet);
        }
    }
}

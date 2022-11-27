package com.dicoding.commonclass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WildCardApp {
    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();
        ls.add("String1");
        ls.add("String2");

        print(ls);

        Collection<Planet> cp = new ArrayList<>();
        cp.add(new Planet("Mercury", 100));
        cp.add(new Planet("Mars", 2000));

        print(cp);

    }

    public static void print(Collection<?> collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}

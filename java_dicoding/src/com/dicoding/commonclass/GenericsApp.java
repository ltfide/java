package com.dicoding.commonclass;

import java.util.ArrayList;
import java.util.List;

public class GenericsApp {
    public static void main(String[] args) {

        List lo = new ArrayList();
        lo.add("lo - String 1");
        lo.add(new Planet("Mercury", 123));

        for (Object o : lo) {
            Planet p = (Planet) o;
            p.print();
        }

        List<Planet> lp = new ArrayList<>();
        lp.add(new Planet("Mercury", 100));
        // lp.add("String"); // ERROR

    }
}

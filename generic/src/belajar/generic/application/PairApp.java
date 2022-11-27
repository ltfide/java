package belajar.generic.application;

import belajar.generic.Pair;

public class PairApp {
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<String, Integer>("Lutfi", 200);
        pair.setFirst("Lisa");
        pair.setSecond(30);

        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}

package belajar.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingApp {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.addAll(List.of("Lutfi", "Dendiansyah", "Satu", "Tiga"));

        Collections.sort(list);

        for (var value : list) {
            System.out.println(value);
        }

        Comparator<String> reverse = (o1, o2) -> o2.compareTo(o1);

        Collections.sort(list, reverse);

        for (var value : list) {
            System.out.println(value);
        }

    }
}

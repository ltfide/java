package belajar.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {

        // List<String> strings = new ArrayList<>();
        List<String> strings = new LinkedList<>();

        strings.add("Lutfi");
        strings.add("Dendiansyah");
        strings.add("new data");

        strings.set(0, "updated");

        strings.remove(1);
        System.out.println(strings.get(0));

        for (var value : strings) {
            System.out.println(value);
        }
    }
}

package belajar.collection.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IterableInterface {

    public static Iterable<String> iterableApp() {
        Iterable<String> names = List.of("Lutfi", "Dendiansyah");
        return names;
    }

    public static void forEachMethod() {
        Iterable<String> names = iterableApp();
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void iteratorMethod() {
        Iterable<String> names = iterableApp();
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        iteratorMethod();
    }
}

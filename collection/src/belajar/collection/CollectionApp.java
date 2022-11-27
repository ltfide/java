package belajar.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();

        collection.add("Lutfi");
        collection.add("Dendiansyah");
        collection.addAll(List.of("Belajar", "Java", "Collection"));

        for (var value : collection) {
            System.out.println(value);
        }

        System.out.println("REMOVE");

        collection.remove("Dendiansyah");
        collection.removeAll(List.of("Java"));

        for (var value : collection) {
            System.out.println(value);
        }

        Collection<String> names = new ArrayList<>();

        names.add("aku adalah");
        names.add("aku juga");
        names.add("gakada");

        List<String> result = names.stream().filter(name -> name.startsWith("aku"))
                .toList();

        System.out.println(result);

        System.out.println(collection.remove("Belajar"));
        System.out.println(collection.containsAll(List.of("Lutfi", "Collection")));
        System.out.println(collection.size());
    }
}

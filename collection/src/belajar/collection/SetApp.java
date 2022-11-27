package belajar.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Lutfi");
        hashSet.add("Dendiansyah");
        hashSet.add("Lutfi");
        hashSet.add("Dendiansyah");
        System.out.println(hashSet);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Lutfi");
        linkedHashSet.add("Dendiansyah");
        linkedHashSet.add("Lutfi");
        linkedHashSet.add("Dendiansyah");
        System.out.println(linkedHashSet);
    }
}

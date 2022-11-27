package belajar.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetApp {
    public static void main(String[] args) {

        Set<String> empty = Collections.emptySet();
        Set<String> one = Collections.singleton("Lutfi");

        Set<String> mutable = new HashSet<>();
        mutable.add("Lutfi");
        mutable.add("Dendiansyah");
        Set<String> immutable = Collections.unmodifiableSet(mutable);

        Set<String> set = Set.of("Lutfi", "Dendiansyah");

        // set.add("Test"); // ERROR
        // set.remove("Lutfi"); // ERROR
    }
}

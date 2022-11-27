package belajar.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableApp {
    public static void main(String[] args) {

        List<String> one = Collections.singletonList("Satu");
        List<String> empty = Collections.emptyList();

        List<String> mutable = new ArrayList<>();
        mutable.add("Lutfi");
        mutable.add("Dendiansyah");
        List<String> immutable = Collections.unmodifiableList(mutable);
        System.out.println(immutable);

        List<String> elements = List.of("Lutfi", "Dendiansyah");
//        elements.add("asd"); // error
//        System.out.println(elements);
    }
}

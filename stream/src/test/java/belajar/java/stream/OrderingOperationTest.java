package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OrderingOperationTest {

    @Test
    void testSorted() {
        List.of("Lutfi", "Dendiansyah", "Software")
                .stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void testSortedWithComparator() {
        Comparator<String> reverseComparator = Comparator.reverseOrder();

        List.of("Lutfi", "Dendiansyah", "Satu")
                .stream()
                .sorted(reverseComparator)
                .forEach(System.out::println);
    }

}

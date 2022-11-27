package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class FilteringOperationsTest {

    @Test
    void testFilteringOperation() {
        List<String> names = List.of("Lutfi", "Dendiansyah", "Lutfi");

        names.stream()
                .filter(value -> value.length() > 5)
                .forEach(System.out::println);
        names.stream()
                .distinct()
                .forEach(System.out::println);
    }

}

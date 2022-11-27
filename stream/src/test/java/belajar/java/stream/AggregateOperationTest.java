package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class AggregateOperationTest {

    @Test
    void testAggregateOperation() {
        List<String> names = List.of("Lutfi", "Dendiansyah", "Latu");

        names.stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);

        names.stream()
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println);

        long count = names.stream().count();
        System.out.println(count);

        var result = List.of(1,2,3,4,5).stream()
                .reduce(0, (value, item) -> value + item);
        System.out.println(result);
    }

}

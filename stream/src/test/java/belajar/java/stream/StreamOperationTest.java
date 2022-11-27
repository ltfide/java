package belajar.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperationTest {

    @Test
    @DisplayName("Strem Operation")
    void testStreamOperation() {
        List<String> names = List.of("Lutfi", "Dendiansyah");

        Stream<String> streamNames = names.stream();
        Stream<String> streamUpper = streamNames.map(value -> value.toUpperCase());

        streamUpper.forEach(System.out::println);

        names.forEach(System.out::println);
    }

}

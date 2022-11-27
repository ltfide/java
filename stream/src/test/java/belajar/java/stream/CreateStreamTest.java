package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    void testCreateStreamFromArray() {
        Stream<String> arrayStream = Stream.of("Lutfi", "Dendiansyah");
        arrayStream.forEach(System.out::println);

        String[] array = new String[] {"Lutfi", "Dendiansyah"};
        Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.forEach(System.out::println);
    }

    @Test
    void testCreateStreamFromCollection() {
        Collection<String> collectionString = List.of("Lutfi", "Dendiansyah");

        Stream<String> streamString = collectionString.stream();
        streamString.forEach(System.out::println);

        Stream<String> streamString2 = collectionString.stream();
        streamString2.forEach(System.out::println);
    }

    @Test
    void testCreateStreamIterate() {
        Stream<String> stringStream = Stream.generate(() -> "Lutfi");
        // stringStream.forEach(System.out::println);

        Stream<Integer> iterate = Stream.iterate(1, value -> value + 1);
        iterate.forEach(System.out::println);
    }

}

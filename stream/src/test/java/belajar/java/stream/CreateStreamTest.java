package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    void testCreateStreamFromArray() {
        Stream<String> arrayStream = Stream.of("Lutfi", "Dendiansyah");
        arrayStream.forEach(System.out::println); // Lutfi // Dendiansyah

        String[] array = new String[] { "Lutfi", "Dendiansyah" };
        Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.forEach(System.out::println); // Lutfi // Dendiansyah

        int[] numbers = { 1, 2, 3, 4, 5 };
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println); // 1 // 2 // 3 // 4 // 5

        List<String> names = Arrays.asList("John", "Jane", "Bob");
        Stream<String> stream2 = names.stream();
        stream2.forEach(System.out::println);
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
    void testCreateStreamFromList() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        List<Integer> listFilter = list.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(listFilter);

    }

    @Test
    void testCreateStreamIterate() {
        Stream<String> stringStream = Stream.generate(() -> "Lutfi");
        stringStream.forEach(System.out::println);

        Stream<Integer> iterate = Stream.iterate(1, value -> value + 1);
        iterate.forEach(System.out::println);
    }

}

package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TransformationOperationTest {

    @Test
    void testMap() {
        List.of("Lutfi", "Dendiansyah").stream()
                .map(str -> str.toUpperCase())
                .map(upper -> upper.length())
                .forEach(length -> System.out.println(length)); // 5 // 11
    }

    @Test
    void testFlatMap() {
        List.of("Lutfi", "Dendiansyah").stream()
                .map(name -> name.toUpperCase())
                .flatMap(upper -> Stream.of(upper, upper.length()))
                .flatMap(value -> Stream.of(value, value))
                .forEach(length -> System.out.println(length));
        // output
        // 2
        // LUTFI
        // 2
        // 5
        // 2
        // DENDIANSYAH
        // 2
        // 11
    }

    @Test
    void transformationOperationExample() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        // Mengubah semua huruf menjadi huruf besar
        List<String> capitalizedWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(capitalizedWords); // [APPLE, BANANA, CHERRY]

        // Memecah setiap kata menjadi beberapa huruf, kemudian menggabungkannya kembali
        String combinedWords = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .reduce("", (a, b) -> a + b);
        System.out.println(combinedWords); // applebananacherry

        // Mencetak setiap kata ke konsol
        words.stream()
                .peek(System.out::println)
                .count();
    }

}

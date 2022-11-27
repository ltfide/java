package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class RetrievingOperationTest {

    @Test
    void testLimit() {
        List.of("Lutfi", "Dendiansyah", "Satu", "Dua")
                .stream()
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    void testSkip() {
        List.of("Lutfi", "Dendiansyah", "Satu", "Dua")
                .stream()
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    void testTakeWhile() {
        List.of("Lutfi", "Dendiansyah", "Satu", "Dua")
                .stream()
                .takeWhile(str -> str.length() > 4)
                .forEach(System.out::println);
    }

    @Test
    void testDropWhile() {
        List.of("Lutfi", "Dendiansyah", "Satu", "Dua")
                .stream()
                .dropWhile(str -> str.length() >= 4)
                .forEach(System.out::println);
    }

    @Test
    void testFindAny() {
        Optional<String> optional = List.of("Lutfi", "Dendiansyah", "Satu", "Dua").stream().findAny();
        Optional<String> optional2 = List.of("Lutfi", "Dendiansyah", "Satu", "Dua").stream().findAny();
        Optional<String> optional3 = List.of("a", "Dendiansyah", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan", "Sembilan").stream().findAny();

        optional.ifPresent(System.out::println);
        optional2.ifPresent(System.out::println);
        System.out.println(optional3);
    }

    @Test
    void testFindFirst() {
        Optional<String> optional = List.of("Lutfi", "Dendiansyah", "Satu", "Dua").stream().findFirst();
        Optional<String> optional2 = List.of("Lutfi", "Dendiansyah", "Satu", "Dua").stream().findFirst();
        Optional<String> optional3 = List.of("a", "Dendiansyah", "Satu", "Dua", "Tiga", "Empat", "Lima", "Enam", "Tujuh", "Delapan", "Sembilan").stream().findFirst();

        optional.ifPresent(System.out::println);
        optional2.ifPresent(System.out::println);
        optional3.ifPresent(System.out::println);
    }

}

package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckOperationTest {

    @Test
    void testAnyMatch() {
        boolean match = List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .anyMatch(number -> number > 4);
        System.out.println(match);
    }

    @Test
    void testAllMatch() {
        boolean match = List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .allMatch(number -> number > 4);
        System.out.println(match);
    }

    @Test
    void testNoneMatch() {
        boolean match = List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .noneMatch(number -> number > 100);
        System.out.println(match);
    }

}

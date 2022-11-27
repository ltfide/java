package belajar.java.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ForEachOperationTest {

    @Test
    void testPeekBefore() {
        List.of("Lutfi", "Dendiansyah", "Satu").stream()
                .map(name -> {
                    System.out.println("Before change name to upper " + name);
                    String upper = name.toUpperCase();
                    System.out.println("Change name to upper " + upper);
                    return upper;
                })
                .forEach(name -> System.out.println("Final name: " + name));
    }

    @Test
    void testPeekAfter() {
        List.of("Lutfi", "Dendiansyah", "Satu").stream()
                .peek(name -> System.out.println("Before change name to upper " + name))
                .map(name -> name.toUpperCase())
                .peek(upper -> System.out.println("Change name to upper " + upper))
                .forEach(name -> System.out.println("Final name: " + name));
    }

}

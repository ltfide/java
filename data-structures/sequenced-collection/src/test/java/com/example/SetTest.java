package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.SequencedSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    @Test
    void test() {
        SequencedSet<String> set = new TreeSet<>();
        set.add("satu");
        set.add("dua");
        set.add("tiga");

        assertEquals("dua", set.getFirst());
        assertEquals("tiga", set.getLast());

        SequencedSet<String> reversed = set.reversed();
        assertEquals("tiga", reversed.getFirst());
        assertEquals("dua", reversed.getLast());

        String dua = set.removeFirst();
        assertEquals("dua", dua);

        String tiga = set.removeLast();
        assertEquals("tiga", tiga);

        assertEquals(1, set.size());
    }
}

package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class CollectionTest {

    @Test
    void test() {
        SequencedCollection<String> list = new ArrayList<>();
        list.addLast("tiga");
        list.addFirst("dua");
        list.addFirst("satu");

        assertEquals(List.of("satu", "dua", "tiga"), list);

        assertEquals("satu", list.getFirst());
        assertEquals("tiga", list.getLast());

        SequencedCollection<String> reversed = list.reversed();
        assertEquals(List.of("tiga", "dua", "satu"), reversed);

        String tiga = list.removeLast();
        assertEquals("tiga", tiga);

        String satu = list.removeFirst();
        assertEquals("satu", satu);

        assertEquals(List.of("dua"), list);
    }
}

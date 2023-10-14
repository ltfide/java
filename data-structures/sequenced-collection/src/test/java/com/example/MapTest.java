package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.SequencedMap;
import java.util.TreeMap;

public class MapTest {

    @Test
    void map() {
        SequencedMap<String, String> map = new TreeMap<>();
        map.put("c", "tiga");
        map.put("b", "dua");
        map.put("a", "satu");

        assertEquals("satu", map.firstEntry().getValue());
        assertEquals("tiga", map.lastEntry().getValue());

        SequencedMap<String, String> reversed = map.reversed();
        assertEquals("tiga", reversed.firstEntry().getValue());
        assertEquals("satu", reversed.lastEntry().getValue());
    }

    @Test
    void linkedMap() {
        SequencedMap<String, String> map = new LinkedHashMap<>();
        map.put("a", "satu"); // a
        map.put("b", "dua");  // b, a
        map.put("c", "tiga"); // c, b, a

        assertEquals("satu", map.firstEntry().getValue());
        assertEquals("tiga", map.lastEntry().getValue());
    }
}

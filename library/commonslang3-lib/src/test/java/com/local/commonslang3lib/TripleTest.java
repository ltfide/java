package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TripleTest {

    private static Triple<String, String, String> triple;

    @BeforeAll
    static void setUp() {
        triple = Triple.of("Left Element", "Middle Element", "Right Element");
    }

    @Test
    void testCalledGetLeft() {
        assertEquals("Left Element", triple.getLeft());
    }

    @Test
    void testCalledGetMiddle() {
        assertEquals("Middle Element", triple.getMiddle());
    }

    @Test
    void testCalledGetRight() {
        assertEquals("Right Element", triple.getRight());
    }
}

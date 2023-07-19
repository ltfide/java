package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.tuple.MutablePair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MutablePairTest {

    private static MutablePair<String, String> mutablePair;

    @BeforeAll
    static void setUp() {
        mutablePair = new MutablePair<String, String>("Left element", "Right element");
    }

    @Test
    void testCalledGetLeft() {
        assertEquals("Left element", mutablePair.getLeft());
    }

    @Test
    void testCalledGetRight() {
        assertEquals("Right element", mutablePair.getRight());
    }

    @Test
    void testCalledSetLeft() {
        mutablePair.setLeft("New Left Element");

        assertEquals("New Left Element", mutablePair.getLeft());
    }
}

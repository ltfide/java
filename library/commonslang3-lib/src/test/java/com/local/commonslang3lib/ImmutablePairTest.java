package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ImmutablePairTest {

    private static ImmutablePair<String, String> immutablePair;

    @BeforeAll
    static void setUp() {
        immutablePair = new ImmutablePair<String, String>("Left Element", "Right Element");
    }

    @Test
    void testCalledGetLeft() {
        assertEquals("Left Element", immutablePair.getLeft());
    }

    @Test
    void testCalledGetRight() {
        assertEquals("Right Element", immutablePair.getRight());
    }

    @Test
    void testCalledOf() {
        assertInstanceOf(ImmutablePair.class, ImmutablePair.of("Left Element", "Right Element"));
    }

    @Test
    void testCalledSetValue() {
        assertThrows(UnsupportedOperationException.class, () -> {
            immutablePair.setValue("new Value");
        });
    }
}

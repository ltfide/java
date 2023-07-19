package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;

public class NumberUtilsTest {

    @Test
    void testCompare() {
        assertEquals(0, NumberUtils.compare(1, 1));
        assertEquals(0, NumberUtils.compare(1L, 1L));
    }

    @Test
    void testCreateNumber() {
        Number num = NumberUtils.createNumber("123");

        assertEquals(123, num.intValue());
    }

    @Test
    void testIsDigits() {
        assertTrue(NumberUtils.isDigits("123"));
        assertFalse(NumberUtils.isDigits("abc"));
    }

    @Test
    void testMathOperations() {
        int[] arr = { 1, 2, 3, 4, 5 };

        assertEquals(5, NumberUtils.max(arr));
        assertEquals(1, NumberUtils.min(arr));
        assertEquals((byte) 1, NumberUtils.min(arr));
    }
}

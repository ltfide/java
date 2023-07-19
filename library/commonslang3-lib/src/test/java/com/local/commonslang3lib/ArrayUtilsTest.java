package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {

    @Test
    void testToString() {
        String[] arr1 = { "a", "b", "c" };
        assertEquals("{a,b,c}", ArrayUtils.toString(arr1));
        assertEquals("Array is null", ArrayUtils.toString(null, "Array is null"));
    }

    @Test
    void testHashCode() {
        String[] arr1 = { "a", "b", "c" };
        assertEquals(997619, ArrayUtils.hashCode(arr1));
    }

    @Test
    void testToMap() {
        String[][] arr = { { "a", "1" }, { "b", "2" }, { "c", "3" } };
        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        assertEquals(map, ArrayUtils.toMap(arr));
    }

    @Test
    void testIsSameLength() {
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 1, 2, 3 };

        assertTrue(ArrayUtils.isSameLength(arr1, arr2));
    }

    @Test
    void testIndexOf() {
        int[] arr = { 1, 2, 3 };

        assertEquals(0, ArrayUtils.indexOf(arr, 1, 0));
        assertEquals(1, ArrayUtils.indexOf(arr, 2, 1));
        assertEquals(0, ArrayUtils.indexOf(arr, 1));
    }
}

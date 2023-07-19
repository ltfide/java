package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void testIsBlank() {
        String strNull = null;
        String strEmpty = "";
        String strSpace = "    ";
        String strValid = "valid";

        assertTrue(StringUtils.isBlank(strNull));
        assertTrue(StringUtils.isBlank(strEmpty));
        assertTrue(StringUtils.isBlank(strSpace));
        assertFalse(StringUtils.isBlank(strValid));
    }

    @Test
    void testCompare() {
        String st1 = "one";
        String st2 = "two";

        int compare = StringUtils.compare(st1, st2);
        assertEquals(-5, compare);

        compare = StringUtils.compare(st1, st1);
        assertEquals(0, compare);
    }

    @Test
    void testContains() {
        String hello = "hello";
        String ll = "ll";
        String nn = "nn";

        boolean contains = StringUtils.contains(hello, ll);
        System.out.println(contains); // true

        contains = StringUtils.contains(hello, nn);
        System.out.println(contains); // false

        contains = StringUtils.contains(hello, "e");
        System.out.println(contains); // true
    }

}

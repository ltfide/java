package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.apache.commons.lang3.mutable.MutableObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MutableObjectTest {

    private static MutableObject<String> mutableObject;

    @BeforeAll
    static void setUpMutableObject() {
        mutableObject = new MutableObject<>("Initial value");
    }

    @Test
    void testCalledGetValue() {
        assertInstanceOf(String.class, mutableObject.getValue());
    }

    @Test
    void testCalledSetValue() {
        mutableObject.setValue("Dia");

        assertEquals("Dia", mutableObject.getValue());
    }

    @Test
    void testCalledToString() {
        assertEquals("Initial value", mutableObject.toString());
    }
}

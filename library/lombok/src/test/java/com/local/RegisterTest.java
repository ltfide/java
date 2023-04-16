package com.local;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    @Test
    void testWith() {
        Register register1 = new Register("lutfi", "123");
        Register register2 = register1.withUsername("lisa");

        assertEquals(register1.getPassword(), register2.getPassword());
        assertNotEquals(register1.getUsername(), register2.getUsername());
    }
}
package com.local;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testCustomer() {
        Customer customer = new Customer();
        customer.setId("01");
        customer.setName("Lutfi");

        assertEquals("01", customer.getId());
        assertEquals("Lutfi", customer.getName());
    }
}
package com.local;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {

    @Test
    void createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        assertNotNull(objectMapper);
    }
}

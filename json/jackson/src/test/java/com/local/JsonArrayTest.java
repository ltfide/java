package com.local;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonArrayTest {

    @Test
    void createJsonArray() throws JsonProcessingException {
        List<String> students = List.of("Lutfi", "Lisa", "Lili");

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(students);
        System.out.println(json); // ["Lutfi","Lisa","Lili"]
    }

    @Test
    void readJsonArray() throws JsonMappingException, JsonProcessingException {
        String json = """
                ["Lutfi","Lisa","Lili"]
                    """;
        ObjectMapper om = new ObjectMapper();
        List<String> result = om.readValue(json, new TypeReference<List<String>>() {
        });

        System.out.println(result); // [Lutfi, Lisa, Lili]
    }
}

package com.local;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectTest {

    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = new HashMap<>();
        person.put("name", "Lutfi");
        person.put("age", 30);
        person.put("isMarried", false);

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(person);
        System.out.println(json);
        // {"isMarried":false,"name":"Lutfi","age":30}
    }

    @Test
    void readJson() throws JsonMappingException, JsonProcessingException {
        String json = """
                {"isMarried":false,"name":"Lutfi","age":30}
                    """;

        ObjectMapper om = new ObjectMapper();
        Map<String, Object> person = om.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        System.out.println(person.get("name")); // Lutfi
        System.out.println(person.get("age")); // 30
        System.out.println(person.get("isMarried")); // false
    }
}

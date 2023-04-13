package com.local;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FeatureTest {

    @Test
    void testMapperFeature() throws JsonMappingException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        // Deprecated
        om.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        String json = """
                {"ID" : "1", "Name": "Lutfi"}
                """;

        Person person = om.readValue(json, Person.class);
        System.out.println(person.getId()); // 1
        System.out.println(person.getName()); // Lutfi
    }
}

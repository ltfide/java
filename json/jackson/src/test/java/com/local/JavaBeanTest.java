package com.local;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaBeanTest {

    @Test
    void createJsonFromObject() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Lutfi");
        person.setHobbies(List.of("Game", "Reading"));

        Address address = new Address();
        address.setStreet("JL. A");
        address.setCity("Jakarta");
        address.setCountry("Indonesia");
        person.setAddress(address);

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(person);

        System.out.println(json);
        // {
        // "id": "1",
        // "name": "Lutfi",
        // "hobbies": ["Game", "Reading"],
        // "address": { "street": "JL. A", "city": "Jakarta", "country": "Indonesia" }
        // }
    }

    @Test
    void jsonToObject() throws JsonMappingException, JsonProcessingException {
        String json = """
                {
                    "id": "1",
                    "name": "Lutfi",
                    "hobbies": ["Game", "Reading"],
                    "address": { "street": "JL. A", "city": "Jakarta", "country": "Indonesia" }
                }
                    """;

        ObjectMapper om = new ObjectMapper();
        Person person = om.readValue(json, Person.class);

        System.out.println(person.getId()); // 1
        System.out.println(person.getName()); // Lutfi
        System.out.println(person.getHobbies()); // [Game, Reading]
        System.out.println(person.getAddress()); // com.local.Address@18d87d80
    }
}

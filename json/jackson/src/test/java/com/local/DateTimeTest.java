package com.local;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DateTimeTest {

    @Test
    void dateTime() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person();
        person.setId("1");
        person.setName("Lutfi");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
        // {"id":"1","name":"Lutfi","hobbies":null,"address":null,"createdAt":1681411530040,"updatedAt":1681411530040}
    }

    @Test
    void dateFormat() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("1");
        person.setName("Lutfi");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
        // {"id":"1","name":"Lutfi","hobbies":null,"address":null,"createdAt":"2023-04-14
        // 01:45:41","updatedAt":"2023-04-14 01:45:41"}
    }
}

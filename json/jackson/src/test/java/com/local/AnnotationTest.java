package com.local;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AnnotationTest {

    @Test
    void annotation() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setSerializationInclusion(Include.NON_NULL)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("1");
        person.setName("Lutfi");
        person.setFullName("Lutfi Dendiansyah");
        person.setPassword("rahasia");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
        // {"id":"1","name":"Lutfi","createdAt":"2023-04-13","updatedAt":"2023-04-14
        // 01:57:44","full_name":"Lutfi Dendiansyah"}
    }
}

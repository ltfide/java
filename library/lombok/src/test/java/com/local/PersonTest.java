package com.local;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonTest {

    @Test
    void testCreateBuilder() {
        Person person = Person.builder()
                .name("Lutfi")
                .age(30)
                .hobbies(List.of("Gaming", "Travelling"))
                .build();

        System.out.println(person.toString());
        // Person(name=Lutfi, age=30, hobbies=[Gaming, Travelling])
    }

    @Test
    void testSingular() {
        Person.PersonBuilder personBuilder = Person.builder()
                .name("Lutfi")
                .age(30)
                .hobby("Gaming")
                .hobby("Travelling");
        Person person = personBuilder.build();

        System.out.println(person.toString());
        // Person(name=Lutfi, age=30, hobbies=[Gaming, Travelling])
    }
}

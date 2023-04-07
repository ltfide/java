package dev.local;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import dev.local.data.Person;

public class ModifierTest {

    @Test
    void testModifier() throws SecurityException, NoSuchFieldException {
        Class<Person> personClass = Person.class;

        Field firstName = personClass.getDeclaredField("firstName");

        System.out.println(Modifier.isPublic(personClass.getModifiers())); // true
        System.out.println(Modifier.isPrivate(firstName.getModifiers())); // true
    }
}

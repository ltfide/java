package dev.local;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class ClassTest {

    @Test
    void testCreateClass() throws ClassNotFoundException {
        Class<Person> personClass1 = Person.class;

        Class<?> personClass2 = Class.forName("dev.local.Person");

        Person person = new Person();
        Class<? extends Person> personClass3 = person.getClass();

        assertEquals("Person", personClass1.getSimpleName());
        assertEquals("Person", personClass2.getSimpleName());
        assertEquals("Person", personClass3.getSimpleName());
    }

    @Test
    void testClassMethod() {
        Class<Person> personClass = Person.class;

        System.out.println(personClass.getSuperclass()); // class java.lang.Object
        System.out.println(Arrays.toString(personClass.getInterfaces())); // []
        System.out.println(Arrays.toString(personClass.getDeclaredConstructors())); // [public dev.local.Person()]

        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        // [public java.lang.String dev.local.Person.toString(), public void
        // dev.local.Person.setLastName(java.lang.String), public java.lang.String
        // dev.local.Person.getLastName(), public void
        // dev.local.Person.setFirstName(java.lang.String), public java.lang.String
        // dev.local.Person.getFirstName()]

        System.out.println(Arrays.toString(personClass.getDeclaredFields()));
        // [private java.lang.String dev.local.Person.firstName, private
        // java.lang.String dev.local.Person.lastName]

        System.out.println(personClass.getModifiers()); // 1
        System.out.println(personClass.getPackage()); // package dev.local
        System.out.println(personClass.getName()); // dev.local.Person
        System.out.println(personClass.getSimpleName()); // Person
    }
}

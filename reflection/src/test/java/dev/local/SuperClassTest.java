package dev.local;

import org.junit.jupiter.api.Test;

public class SuperClassTest {

    @Test
    void testSuperClass() {
        Class<Person> personClass = Person.class;

        Class<? super Person> objectClass = personClass.getSuperclass();
        System.out.println(objectClass); // class java.lang.Object

        Class<? super Person> superClassTop = objectClass.getSuperclass();
        System.out.println(superClassTop); // null
    }
}

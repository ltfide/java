package dev.local;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dev.local.data.Nameable;
import dev.local.data.Person;

public class InterfaceTest {

    @Test
    void testInterface() {
        Class<Nameable> nameableClass = Nameable.class;

        System.out.println(nameableClass.getName()); // dev.local.data.Nameable
        System.out.println(nameableClass.isInterface()); // true
        System.out.println(nameableClass.getSuperclass()); // null
        System.out.println(Arrays.toString(nameableClass.getInterfaces())); // []
        System.out.println(Arrays.toString(nameableClass.getDeclaredFields())); // []
        System.out.println(Arrays.toString(nameableClass.getDeclaredMethods()));
        // [public abstract java.lang.String dev.local.data.Nameable.getLastName(),
        // public abstract java.lang.String dev.local.data.Nameable.getFirstName()]
        System.out.println(Arrays.toString(nameableClass.getDeclaredConstructors())); // []
    }

    @Test
    void testSuperInterface() {
        Class<Person> personClass = Person.class;

        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
        // output
        // dev.local.data.Nameable
    }

}

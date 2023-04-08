package dev.local;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import dev.local.data.Person;

public class PrimitiveTypeTest {

    @Test
    void testClass() {
        Class<Integer> integerClass = int.class;
        Class<Long> longClass = long.class;
        Class<Boolean> booleanClass = boolean.class;

        System.out.println(integerClass.isPrimitive()); // true
        System.out.println(longClass.isPrimitive()); // true
        System.out.println(booleanClass.isPrimitive()); // true
    }

    @Test
    void testGetField() throws NoSuchFieldException, SecurityException {
        Class<Person> personClass = Person.class;
        Field age = personClass.getDeclaredField("age");

        System.out.println(age.getName()); // age
        System.out.println(age.getType()); // int
        System.out.println(age.getType().isPrimitive()); // true
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field age = personClass.getDeclaredField("age");

        age.setAccessible(true);

        Person person = new Person();
        person.setAge(25);

        System.out.println(age.getInt(person)); // 25
    }

    @Test
    void testInvokeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method setAge = personClass.getDeclaredMethod("setAge", int.class);

        Person person = new Person();
        setAge.invoke(person, 25);

        System.out.println(person);
        // Person(firstName=null, lastName=null, age=25)
    }
}

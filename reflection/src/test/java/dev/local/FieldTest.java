package dev.local;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class FieldTest {

    @Test
    void testField() {
        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
        // output
        // firstName : java.lang.String
        // lastName : java.lang.String
    }

    @Test
    void getFieldObject()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Person person = new Person("Lutfi", "Dendiansyah");

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Object firstNameValue = firstName.get(person);
        System.out.println(firstNameValue); // Lutfi
    }

    @Test
    void changeFieldObject()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Person person = new Person("Lutfi", "Dendiansyah");

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        firstName.set(person, "Lisa");
        System.out.println(person.getFirstName()); // Lisa
    }
}

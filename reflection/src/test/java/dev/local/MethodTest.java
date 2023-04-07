package dev.local;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class MethodTest {

    @Test
    void testMethod() {
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println("==============");
        }

        // output
        // toString
        // class java.lang.String
        // ==============
        // getLastName
        // class java.lang.String
        // ==============
        // getFirstName
        // class java.lang.String
        // ==============
        // setFirstName
        // void
        // ==============
        // setLastName
        // void
        // ==============
    }

    @Test
    void callMethodObbject() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Person person = new Person("Lutfi", "Dendiansyah");

        Class<Person> personClass = Person.class;
        Method getFirstName = personClass.getDeclaredMethod("getFirstName");
        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Object response = getFirstName.invoke(person);
        setFirstName.invoke(person, "Lisa");

        System.out.println(response); // Lutfi
        System.out.println(person.getFirstName()); // Lisa
    }
}

package dev.local;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.Test;

import dev.local.data.Person;

public class ParameterTest {

    @Test
    void testParameter() {
        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter Name: " + parameter.getName());
                System.out.println("Parameter Type: " + parameter.getType());
            }
            System.out.println("===============");
        }
        // output
        // toString
        // ===============
        // getFirstName
        // ===============
        // getLastName
        // ===============
        // setFirstName
        // Parameter Name: arg0
        // Parameter Type: class java.lang.String
        // ===============
        // setLastName
        // Parameter Name: arg0
        // Parameter Type: class java.lang.String
        // ===============
    }

    @Test
    void callMethodWithParameter() throws NoSuchMethodException, SecurityException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Class<Person> personClass = Person.class;

        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("Lutfi", "Dendiansyah");
        setFirstName.invoke(person, "Lisa");

        System.out.println(person.getFirstName()); // Lisa
    }
}

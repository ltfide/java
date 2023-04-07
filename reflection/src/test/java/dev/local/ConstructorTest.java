package dev.local;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

import org.junit.jupiter.api.Test;

import dev.local.data.Person;

public class ConstructorTest {

    @Test
    void testConstructor() {
        Class<Person> personClass = Person.class;

        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType());
            }
        }

        // output
        // dev.local.Person
        // dev.local.Person
        // arg0
        // class java.lang.String
        // arg1
        // class java.lang.String
    }

    @Test
    void createObjectWithConstructor() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<Person> personClass = Person.class;

        Constructor<Person> emptyConstructor = personClass.getConstructor();
        Constructor<Person> constructorParameters = personClass.getConstructor(String.class, String.class);

        Person person = emptyConstructor.newInstance();
        Person person2 = constructorParameters.newInstance("Lutfi", "Dendiansyah");

        System.out.println(person); // Person(firstName=null, lastName=null)
        System.out.println(person2); // Person(firstName=Lutfi, lastName=Dendiansyah)
    }
}

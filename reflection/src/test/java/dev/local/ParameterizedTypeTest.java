package dev.local;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import dev.local.data.Person;

public class ParameterizedTypeTest {

    @Test
    void testFieldGeneric() throws NoSuchFieldException, SecurityException {
        Class<Person> personClass = Person.class;
        Field hobbies = personClass.getDeclaredField("hobbies");
        hobbies.setAccessible(true);

        Type type = hobbies.getGenericType();
        System.out.println(type.getClass());
        // class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            System.out.println(parameterizedType.getRawType()); // interface java.util.List
            System.out.println(parameterizedType.getOwnerType()); // null
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            // [class java.lang.String]
        }
    }

    @Test
    void testGetMethodGeneric() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method getHobbies = personClass.getDeclaredMethod("getHobbies");

        Type type = getHobbies.getGenericReturnType();
        System.out.println(type.getClass());
        // class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            System.out.println(parameterizedType.getRawType()); // interface java.util.List
            System.out.println(parameterizedType.getOwnerType()); // null
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            // [class java.lang.String]
        }
    }

    @Test
    void testGetMethodParameterGeneric() throws NoSuchMethodException, SecurityException {
        Class<Person> personClass = Person.class;
        Method setHobbies = personClass.getDeclaredMethod("setHobbies", List.class);

        Type[] types = setHobbies.getGenericParameterTypes();
        for (Type type : types) {
            System.out.println(type.getClass());
            // class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl

            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println(parameterizedType.getRawType()); // interface java.util.List
                System.out.println(parameterizedType.getOwnerType()); // null
                System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
                // [class java.lang.String]
            }
        }
    }
}

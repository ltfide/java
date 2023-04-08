package dev.local;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dev.local.data.Gender;

public class EnumTest {

    @Test
    void testEnum() {
        Class<Gender> genderClass = Gender.class;

        boolean isEnum = genderClass.isEnum();
        Gender[] enumConstants = genderClass.getEnumConstants();
        Class<?> superclass = genderClass.getSuperclass();

        System.out.println(isEnum); // true
        System.out.println(Arrays.toString(enumConstants)); // [MALE, FEMALE]
        System.out.println(superclass); // class java.lang.Enum
    }
}

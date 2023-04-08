package dev.local;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArrayTest {

    @Test
    void testArrayClass() {
        Class<String[]> stringArray = String[].class;
        Class<int[][]> intArray = int[][].class;

        System.out.println(stringArray.isArray()); // true
        System.out.println(intArray.isArray()); // true
    }

    @Test
    void testArrayManipulation() {
        Class<String[]> stringArray = String[].class;
        System.out.println(stringArray.getComponentType()); // class java.lang.String

        String[] array = (String[]) Array.newInstance(stringArray.getComponentType(), 2);
        System.out.println(Arrays.toString(array)); // [null, null]

        Array.set(array, 0, "Lutfi");
        Array.set(array, 1, "Lisa");

        System.out.println(Arrays.toString(array)); // [Lutfi, Lisa]
        System.out.println(Array.get(array, 0)); // Lutfi
        System.out.println(Array.get(array, 1)); // Lisa
    }
}

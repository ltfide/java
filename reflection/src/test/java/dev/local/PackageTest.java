package dev.local;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dev.local.data.Person;

public class PackageTest {

    @Test
    void testPackage() {
        Class<Person> personClass = Person.class;

        Package aPackage = personClass.getPackage();
        System.out.println(aPackage.getName()); // dev.local.data
        System.out.println(Arrays.toString(aPackage.getAnnotations()));
        // [@dev.local.annotation.SampleAnnotation()]
    }
}

package dev.local;

import org.junit.jupiter.api.Test;

import dev.local.data.Person;
import dev.local.validation.Validator;

public class AnnotationTest {

    @Test
    void testValidateUsingAnnotation() throws IllegalArgumentException, IllegalAccessException {
        Person person = new Person("Lutfi", "");
        Validator.validateNotBlank(person); // java.lang.RuntimeException: lastName must not blank
    }
}

package com.validation;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.validation.data.Person;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

public class ExceptionTest extends AbstractValidatorTest {

    @Test
    void testException() {

        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            Set<ConstraintViolation<Person>> violations = validator.validate(person);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
        });

    }
}

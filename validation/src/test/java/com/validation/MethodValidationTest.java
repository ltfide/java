package com.validation;

import java.lang.reflect.Method;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.validation.data.Person;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;

public class MethodValidationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testParameter() throws NoSuchMethodException, SecurityException {
        ExecutableValidator executableValidator = validator.forExecutables();

        Person person = new Person();
        String name = "";

        Method sayHello = person.getClass().getMethod("sayHello", String.class);
        Set<ConstraintViolation<Person>> violations = executableValidator.validateParameters(person, sayHello,
                new Object[] { name });

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getPropertyPath()); // sayHello.name
            System.out.println(violation.getMessage()); // name must not blank
            System.out.println("===========");
        }
    }

    @Test
    void testReturnValue() throws NoSuchMethodException, SecurityException {
        ExecutableValidator executableValidator = validator.forExecutables();

        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");

        String returnValue = person.fullName();

        Method fullName = person.getClass().getMethod("fullName");
        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateReturnValue(person, fullName, returnValue);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getPropertyPath()); // fullName.<return value>
            System.out.println(violation.getMessage()); // fulname must not blank
            System.out.println("===========");
        }
    }
}

package com.validation;

import com.validation.data.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void testValidationFailedNotBlank() {
        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
        }

        // output
        // Message: First name cannot empty
        // Bean: Person(firstName=null, lastName=null)
        // Constraint : @jakarta.validation.constraints.NotEmpty(message="First name
        // cannot empty", payload={}, groups={})
        // Invalid Value : null
        // Path : firstName
        // Message: last name cannot empty
        // Bean: Person(firstName=null, lastName=null)
        // Constraint : @jakarta.validation.constraints.NotEmpty(message="last name
        // cannot empty", payload={}, groups={})
        // Invalid Value : null
        // Path : lastName
    }

    @Test
    void testValidationFailedSize() {
        Person person = new Person();
        person.setFirstName("LUTFILUTFILUTFILUTFILUTFILUTFILUTFI");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());
        }

        // output
        // Message: last name cannot empty
        // Bean: Person(firstName=LUTFILUTFILUTFILUTFILUTFILUTFILUTFI, lastName=null)
        // Constraint : @jakarta.validation.constraints.NotEmpty(message="last name
        // cannot empty", payload={}, groups={})
        // Invalid Value : null
        // Path : lastName
        // Message: first name length must be 2 - 6
        // Bean: Person(firstName=LUTFILUTFILUTFILUTFILUTFILUTFILUTFI, lastName=null)
        // Constraint : @jakarta.validation.constraints.Size(groups={}, min=2,
        // message="first name length must be 2 - 6", payload={}, max=6)
        // Invalid Value : LUTFILUTFILUTFILUTFILUTFILUTFILUTFI
        // Path : firstName
    }

    @Test
    void testConstraintViolationSuccess() {
        Person person = new Person();
        person.setFirstName("Lutfi");
        person.setLastName("aja");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(0, violations.size());
    }
}

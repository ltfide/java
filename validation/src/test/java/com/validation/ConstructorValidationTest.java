package com.validation;

import java.lang.reflect.Constructor;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.validation.data.Address;
import com.validation.data.Person;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;

public class ConstructorValidationTest {

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
    void testValidateConstructorParameter() throws NoSuchMethodException {
        ExecutableValidator executableValidator = validator.forExecutables();

        String firstName = "";
        String lastName = "";
        Address address = new Address();

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Object>> violations = executableValidator
                .validateConstructorParameters(constructor, new Object[] { firstName, lastName, address });
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===========");
        }

        // output
        // Person.address.street
        // street cannot blank
        // ===========
        // Person.address.city
        // city cannot blank
        // ===========
        // Person.firstName
        // First name cannot empty
        // ===========
        // Person.address.country
        // country cannot blank
        // ===========
        // Person.lastName
        // last name cannot empty
        // ===========
    }

    @Test
    void testValidateConstructorReturnValue() throws NoSuchMethodException {
        ExecutableValidator executableValidator = validator.forExecutables();

        String firstName = "";
        String lastName = "";
        Address address = new Address();

        Person person = new Person(firstName, lastName, address);

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Object>> violations = executableValidator
                .validateConstructorReturnValue(constructor, person);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===========");
        }

        // output
        // Person.<return value>.lastName
        // last name cannot empty
        // ===========
        // Person.<return value>.address.country
        // country cannot blank
        // ===========
        // Person.<return value>.address.city
        // city cannot blank
        // ===========
        // Person.<return value>.firstName
        // First name cannot empty
        // ===========
        // Person.<return value>.firstName
        // first name length must be 2 - 6
        // ===========
        // Person.<return value>.address.street
        // street cannot blank
        // ===========
        // Person.<return value>.lastName
        // last name length must be 2 - 6
        // ===========
    }
}

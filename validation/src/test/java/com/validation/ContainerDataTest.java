package com.validation;

import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.validation.data.Address;
import com.validation.data.Person;

import jakarta.validation.ConstraintViolation;

public class ContainerDataTest extends AbstractValidatorTest {

    @Test
    void testContainerData() {
        Person person = new Person();
        person.setFirstName("Lutfi");
        person.setLastName("Aja");
        person.setAddress(new Address("Jl. Rusak", "Jakarta", "Indonesia"));

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add(" ");
        person.getHobbies().add("  ");
        person.getHobbies().add("Gaming");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage()); // hobby can not blank
        }
    }
}

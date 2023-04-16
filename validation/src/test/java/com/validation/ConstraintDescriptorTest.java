package com.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.validation.data.Person;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;

public class ConstraintDescriptorTest extends AbstractValidatorTest {

    @Test
    void testConstraintDescriptor() {

        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            ConstraintDescriptor<?> descriptor = violation.getConstraintDescriptor();
            System.out.println(descriptor.getAnnotation());
            System.out.println(descriptor.getAttributes());
            System.out.println(descriptor.getPayload());
            System.out.println(descriptor.getGroups());
            System.out.println("============");
        }

        // output
        // @jakarta.validation.constraints.NotEmpty(message="last name cannot empty",
        // payload={}, groups={})
        // {groups=[Ljava.lang.Class;@5f7b97da, message=last name cannot empty,
        // payload=[Ljava.lang.Class;@18b0930f}
        // []
        // [interface jakarta.validation.groups.Default]
        // ============
        // @jakarta.validation.constraints.NotEmpty(message="First name cannot empty",
        // payload={}, groups={})
        // {groups=[Ljava.lang.Class;@5f7b97da, message=First name cannot empty,
        // payload=[Ljava.lang.Class;@18b0930f}
        // []
        // [interface jakarta.validation.groups.Default]
        // ============
        // @jakarta.validation.constraints.NotNull(message="address cannot null",
        // payload={}, groups={})
        // {groups=[Ljava.lang.Class;@6b7906b3, message=address cannot null,
        // payload=[Ljava.lang.Class;@3a1dd365}
        // []
        // [interface jakarta.validation.groups.Default]
        // ============
    }
}

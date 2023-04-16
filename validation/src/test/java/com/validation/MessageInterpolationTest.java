package com.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.validation.data.Payment;
import com.validation.data.Person;
import com.validation.data.group.CreditCardPaymentGroup;

import jakarta.validation.ConstraintViolation;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessageInterpolation() {
        Person person = new Person();
        person.setLastName("a");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage()); // last name length must be 2 - 6
            System.out.println(violation.getMessageTemplate()); // last name length must be 2 - 6
        }
    }

    @Test
    void testMIWithResourceBundle() {
        Payment payment = new Payment();
        payment.setOrderId("");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage()); // order id must not blank
            System.out.println(violation.getMessageTemplate()); // {order.id.notblank}
        }
    }

}

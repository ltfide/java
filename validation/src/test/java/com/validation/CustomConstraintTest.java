package com.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.validation.data.Payment;
import com.validation.data.group.CreditCardPaymentGroup;

import jakarta.validation.ConstraintViolation;

public class CustomConstraintTest extends AbstractValidatorTest {

    @Test
    void testCustomConstraint() {

        Payment payment = new Payment();
        payment.setOrderId("abc");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage()); // order id must UPPERCASE
        }
    }
}

package com.validation;

import com.validation.data.Payment;
import org.junit.jupiter.api.Test;

public class HibernateValidatorConstraintTest extends AbstractValidatorTest {

    @Test
    void testHibernateValidatorConstraintInvalid() {
        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setOrderId("0001");
        payment.setCreditCard("433");

        validate(payment);
    }
}

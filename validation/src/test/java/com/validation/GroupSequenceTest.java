package com.validation;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.validation.data.Payment;
import com.validation.data.group.PaymentGroup;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class GroupSequenceTest {

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
    void testGroupSequence() {
        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("41111");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, PaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage()); // virtual accoount must not blank
            System.out.println(violation.getLeafBean()); // Payment(orderId=001, amount=20000, creditCard=41111, virtualAccount=null)
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            // @jakarta.validation.constraints.NotBlank(message="virtual accoount must not blank", payload={}, groups={com.validation.data.group.VirtualAccountPaymentGroup.class})
            System.out.println(violation.getInvalidValue()); // null
            violation.getPropertyPath().forEach((node) -> System.out.println(node.getName())); // virtualAccount
        }
    }
}

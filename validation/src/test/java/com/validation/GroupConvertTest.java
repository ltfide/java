package com.validation;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.validation.data.Customer;
import com.validation.data.Payment;
import com.validation.data.group.CreditCardPaymentGroup;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class GroupConvertTest {

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
    void testGroupConvert() {
        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setCustomer(new Customer());

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getInvalidValue());
            violation.getPropertyPath().forEach((node) -> System.out.println(node.getName()));
        }

        // output
        // email must not blank
        // com.validation.data.Customer@3e14c16d
        // @jakarta.validation.constraints.NotBlank(message="email must not blank",
        // payload={}, groups={})
        // null
        // customer
        // email
        // name must not blank
        // com.validation.data.Customer@3e14c16d
        // @jakarta.validation.constraints.NotBlank(message="name must not blank",
        // payload={}, groups={})
        // null
    }
}

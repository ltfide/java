package com.validation;

import java.util.Locale;
import java.util.Set;

import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.validation.data.Payment;
import com.validation.data.group.CreditCardPaymentGroup;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class MessageInternationalizationTest {

    private ValidatorFactory validatorFactory;

    private Validator validator;

    private MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        messageInterpolator = validatorFactory.getMessageInterpolator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testI18N() {
        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("3240982394823904832049");
        payment.setAmount(10L);

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("===============");
        }

        // output
        // amount
        // jumlah karakter id pesanan harus antara 10000 dan 100000000
        // ===============
        // creditCard
        // credit card must not blank
        // ===============
        // customer
        // customer must not null
        // ===============
    }

    @Test
    void testMessageInterpolator() {
        Payment payment = new Payment();
        payment.setOrderId("3240982394823904832049");
        payment.setAmount(10L);

        Locale locale = new Locale("in", "ID");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true);

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale);
            System.out.println(message);

            System.out.println("===============");
        }

        // output
        // amount
        // {order.id.size}
        // jumlah karakter id pesanan harus antara 10000 dan 100000000
        // ===============
        // customer
        // customer must not null
        // customer must not null
        // ===============
        // creditCard
        // credit card must not blank
        // credit card must not blank
        // ===============
    }
}

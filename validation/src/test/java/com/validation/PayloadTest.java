package com.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.validation.data.Payment;
import com.validation.data.group.CreditCardPaymentGroup;
import com.validation.data.payload.EmailErrorPayload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class PayloadTest extends AbstractValidatorTest {

    @Test
    void testPayload() {
        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(20_000L);
        payment.setCreditCard("31111");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClass : payload) {
                if (payloadClass == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }

            System.out.println("===============");
        }

        // output
        // customer
        // customer must not null
        // ===============
        // creditCard
        // credit card must valid number
        // Send email error because: credit card must valid number
        // ===============
    }
}

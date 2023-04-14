package com.validation;

import org.junit.jupiter.api.Test;

import com.validation.data.Payment;
import com.validation.data.group.CreditCardPaymentGroup;
import com.validation.data.group.VirtualAccountPaymentGroup;

public class GroupTest extends AbstractValidatorTest {

    @Test
    void testCreditCardGroup() {
        Payment payment = new Payment();
        payment.setOrderId("0111");
        payment.setAmount(0L);
        payment.setCreditCard("123");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
        // output
        // amount
        // amount must between 10000 and 100000000
        // ===============
        // creditCard
        // credit card must valid number
        // ===============
    }

    @Test
    void testVirtualAccount() {
        Payment payment = new Payment();
        payment.setOrderId("0111");
        payment.setAmount(20_000L);
        payment.setVirtualAccount("");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
        // output
        // virtualAccount
        // virtual accoount must not blank
        // ===============
    }
}

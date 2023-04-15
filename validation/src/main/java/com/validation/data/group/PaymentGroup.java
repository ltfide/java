package com.validation.data.group;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({
        Default.class,
        CreditCardPaymentGroup.class,
        VirtualAccountPaymentGroup.class
})
public interface PaymentGroup {

}

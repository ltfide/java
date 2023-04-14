package com.validation.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

import com.validation.data.group.CreditCardPaymentGroup;
import com.validation.data.group.VirtualAccountPaymentGroup;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @NotBlank(groups = { CreditCardPaymentGroup.class,
            VirtualAccountPaymentGroup.class }, message = "order id must not blank")
    private String orderId;

    @NotNull(groups = { CreditCardPaymentGroup.class,
            VirtualAccountPaymentGroup.class }, message = "amount must not null")
    @Range(groups = { CreditCardPaymentGroup.class,
            VirtualAccountPaymentGroup.class }, min = 10_000L, max = 100_000_000L, message = "amount must between 10000 and 100000000")
    private Long amount;

    @NotBlank(groups = { CreditCardPaymentGroup.class }, message = "credit card must not blank")
    @LuhnCheck(groups = { CreditCardPaymentGroup.class }, message = "credit card must valid number")
    private String creditCard;

    @NotBlank(groups = { VirtualAccountPaymentGroup.class }, message = "virtual accoount must not blank")
    private String virtualAccount;

}

package com.validation.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @NotBlank(message = "order id must not blank")
    private String orderId;

    @NotNull(message = "amount must not null")
    @Range(min = 10_000L, max = 100_000_000L, message = "amount must between 10000 and 100000000")
    private Long amount;

    @NotNull(message = "credit card must not null")
    @LuhnCheck(message = "credit card must valid number")
    private String creditCard;

}

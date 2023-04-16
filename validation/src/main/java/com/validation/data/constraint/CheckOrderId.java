package com.validation.data.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.validation.data.enums.CaseMode;
import com.validation.data.group.CreditCardPaymentGroup;
import com.validation.data.group.VirtualAccountPaymentGroup;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@CheckCase(groups = { CreditCardPaymentGroup.class,
        VirtualAccountPaymentGroup.class }, mode = CaseMode.UPPER, message = "order id must UPPERCASE")
@NotBlank(groups = { CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class }, message = "{order.id.notblank}")
@Size(groups = { CreditCardPaymentGroup.class,
        VirtualAccountPaymentGroup.class }, min = 1, max = 10, message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
public @interface CheckOrderId {

    String message() default "invalid order id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

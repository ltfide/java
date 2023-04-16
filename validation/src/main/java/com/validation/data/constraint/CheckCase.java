package com.validation.data.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.validation.data.enums.CaseMode;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = { CheckCaseValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    CaseMode mode();

    String message() default "invalid case format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

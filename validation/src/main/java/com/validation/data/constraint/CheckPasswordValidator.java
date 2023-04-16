package com.validation.data.constraint;

import com.validation.data.Register;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if (value.getPassword() == null || value.getRetypePassword() == null) {
            return true; // skip validation
        }

        boolean isValid = value.getPassword().equals(value.getRetypePassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password")
                    .addConstraintViolation();

            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("retypePassword")
                    .addConstraintViolation();
        }

        return isValid;
    }

}

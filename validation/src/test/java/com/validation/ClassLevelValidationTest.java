package com.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.validation.data.Register;

import jakarta.validation.ConstraintViolation;

public class ClassLevelValidationTest extends AbstractValidatorTest {

    @Test
    void testClassLevel() {
        Register register = new Register();
        register.setUsername("ltfide");
        register.setPassword("123");
        register.setRetypePassword("abc");

        Set<ConstraintViolation<Register>> violations = validator.validate(register);
        for (ConstraintViolation<Register> violation : violations) {
            System.out.println(violation.getMessage()); // password and retype password must same
        }
    }
}

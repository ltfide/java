package com.validation;

import java.lang.reflect.Method;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.validation.data.service.UserService;

import jakarta.validation.ConstraintViolation;

public class CrossParameterValidationTest extends AbstractValidatorTest {

    @Test
    void testCrossParameter() throws NoSuchMethodException, SecurityException {
        UserService userService = new UserService();

        String username = "";
        String password = "123";
        String retypePassword = "abc";

        Method register = UserService.class.getMethod("register", String.class, String.class, String.class);

        Set<ConstraintViolation<UserService>> violations = executableValidator
                .validateParameters(userService, register, new Object[] { username, password, retypePassword });

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
        }

        // output
        // password and retype password must same
        // register.<cross-parameter>
        // username can not blank
        // register.username
    }
}

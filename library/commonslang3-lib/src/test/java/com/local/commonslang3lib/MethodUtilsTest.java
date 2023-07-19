package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.jupiter.api.Test;

import com.local.commonslang3lib.model.User;

public class MethodUtilsTest {

    @Test
    void testCalledGetAccessibleMethod() {
        assertInstanceOf(Method.class, MethodUtils
                .getAccessibleMethod(User.class, "getName"));
    }

    @Test
    void testCalledInvokeExactMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertEquals("Lutfi", MethodUtils
                .invokeExactMethod(new User("Lutfi", "lutfi@mail.com"), "getName"));
    }

    @Test
    void testCalledInvokeMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user = new User("Lutfi", "lutfi@mail.com");
        Object method = MethodUtils.invokeMethod(user, true, "setName", "Lutfi");

        assertEquals("Lutfi", user.getName());
    }
}

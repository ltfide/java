package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.junit.jupiter.api.Test;

import com.local.commonslang3lib.model.User;

public class ConstructorUtilsTest {

    @Test
    void testCalledGetAccessibleConstructor() {
        assertInstanceOf(Constructor.class,
                ConstructorUtils.getAccessibleConstructor(User.class, String.class, String.class));
    }

    @Test
    void testCalledInvokeConstructor()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        assertInstanceOf(User.class, ConstructorUtils.invokeConstructor(User.class, "name", "email"));
    }

    @Test
    void testCalledInvokeExactConstructor()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] args = { "name", "email" };
        Class[] parameterTypes = { String.class, String.class };

        assertInstanceOf(User.class, ConstructorUtils
                .invokeExactConstructor(User.class, args, parameterTypes));
    }
}

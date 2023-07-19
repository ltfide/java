package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.Test;

import com.local.commonslang3lib.model.User;

public class FieldUtilsTest {

    @Test
    void testCalledGetField() {
        assertEquals("name", FieldUtils.getField(User.class, "name", true).getName());
    }

    @Test
    void testCalledWriteField() throws IllegalAccessException {
        User user = new User();
        FieldUtils.writeField(user, "name", "lutfi", true);
        assertEquals("lutfi", FieldUtils.readField(user, "name", true));
        assertEquals("lutfi", user.getName());
    }
}

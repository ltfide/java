package com.local;

import org.junit.jupiter.api.Test;

public class ModifierTest {

    @Test
    void transientTest() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("password");

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}

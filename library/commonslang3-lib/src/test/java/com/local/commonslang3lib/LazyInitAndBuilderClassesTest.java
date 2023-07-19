package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.junit.jupiter.api.Test;

public class LazyInitAndBuilderClassesTest {

    public class User {

        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public class UserInitializer extends LazyInitializer<User> {

        @Override
        protected User initialize() throws ConcurrentException {
            return new User("Lutfi", "lutfi@mail.com");
        }
    }

    @Test
    void testCalled() throws ConcurrentException {
        UserInitializer initializer = new UserInitializer();

        System.out.println(initializer.get().getEmail()); // lutfi@mail.com
        assertInstanceOf(User.class, initializer.get());
    }
}

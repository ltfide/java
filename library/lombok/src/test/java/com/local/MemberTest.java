package com.local;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    @Test
    void testConstructorNull() {
        assertThrows(NullPointerException.class, () -> {
            var member = new Member(null, null);
        });
    }

    @Test
    void testSetterNull() {
        assertThrows(NullPointerException.class, () -> {
            var member = new Member("Lutfi", "Lutfi");
            member.setName(null);
        });
    }

    @Test
    void testMethodNull() {
        assertThrows(NullPointerException.class, () -> {
            var member = new Member("Lutfi", "Lutfi");
            member.sayHello(null);
        });
    }
}

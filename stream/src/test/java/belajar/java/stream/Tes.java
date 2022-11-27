package belajar.java.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tes {

    @Test
    @DisplayName("Test aja")
    public void testSuccess() {
        int x = 3;
        int y = 4;
        int result = x + y;
        int expected = x + y;

        assertEquals(expected, result);
        assertTrue(true);
    }

    @Test
    public void testPerson() {
        Person person = new Person("Lutfi");

        assertEquals("Lutfi", person.getName());
    }

}

package dev.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

public class PathTest {

    @Test
    void testPath() {
        Path path = Path.of("pom.xml");

        assertEquals("pom.xml", path.toString());
        assertFalse(path.isAbsolute());
        assertTrue(Files.exists(path));
    }

    @Test
    void usingFiles() throws IOException {
        Path path = Path.of("pom.xml");

        assertTrue(Files.exists(path));
        assertEquals(2672, Files.size(path));
    }
}

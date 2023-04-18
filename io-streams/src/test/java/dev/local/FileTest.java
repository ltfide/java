package dev.local;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FileTest {

    @Test
    void testFileClass() {
        File file = new File("file1.txt");

        assertEquals("file1.txt", file.getName());
        assertFalse(file.exists());
        assertEquals("D:\\Dev\\JAVA\\io-streams\\file1.txt", file.getAbsolutePath());
    }
}

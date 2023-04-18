package dev.local;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenOptionTest {

    @Test
    void testOpenOption() {
        Path path = Path.of("hello.txt");
        String content = "Hello \n";

        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

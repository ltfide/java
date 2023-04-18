package dev.local;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {

    @Test
    void write() {
        Path path = Path.of("writer.txt");
        String content = "Hello";
        try (Writer stream = Files.newBufferedWriter(path)) {
            stream.write(content);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

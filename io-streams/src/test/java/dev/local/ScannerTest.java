package dev.local;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerTest {

    @Test
    void scannerFile() {
        Path path = Path.of("print.txt");
        try (InputStream stream = Files.newInputStream(path);
             Scanner scanner = new Scanner(stream)) {

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            // output
            // Hello World
            // Hello World
            // Hello World
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package dev.local;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintStreamTest {

    @Test
    void printStream() {
        PrintStream stream = System.out;

        stream.println("Hello");
        stream.println("Hello");
    }

    @Test
    void printStreamFile() {
        Path path = Path.of("print.txt");
        try (OutputStream output = Files.newOutputStream(path);
            PrintStream stream = new PrintStream(output)) {

            stream.println("Hello World");
            stream.println("Hello World");
            stream.println("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPrint() throws FileNotFoundException {
        String data = "This is a text inside the file from printstream.";
        PrintStream printStream = new PrintStream("print.txt");

        printStream.print(data);
        printStream.close();
    }

    @Test
    void testPrintFromSys() {
        PrintStream sys = System.out;
        sys.print("Hello World"); // Hello World
    }

    @Test
    void testPrintf() {
        PrintStream print = System.out;

        String name = "Lutfi";
        print.printf("Hello %s \n", name); // Hello Lutfi

        int number = 100;
        print.printf("Number: %d\n", number); // Number: 100

        int discount = 10;
        print.printf("Discount: %d%%", discount); // Discount 10%
    }
}

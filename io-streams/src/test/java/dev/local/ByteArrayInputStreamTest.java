package dev.local;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayInputStreamTest {

    @Test
    void testReadFile() throws IOException {
        String text = "This is sample text";
        byte[] bytes = text.getBytes();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        String data = new String(inputStream.readAllBytes());
        System.out.println(data); // This is sample text

        inputStream.close();
    }

    @Test
    void testAvailableMethod() throws IOException {
        byte[] numbers = {1,2,3,4,5};

        ByteArrayInputStream input = new ByteArrayInputStream(numbers);

        // Returns the available number of bytes
        System.out.println("Available bytes at the beginning: " + input.available());

        // Reads 2 bytes from the input stream
        input.read();
        input.read();

        // Returns the available number of bytes
        System.out.println("Available bytes at the end: " + input.available());

        input.close();

        // output
        // Available bytes at the beginning: 5
        // Available bytes at the end: 3
    }

    @Test
    void testSkipMethod() throws IOException {
        byte[] numbers = {1,2,3,4,5};

        ByteArrayInputStream input = new ByteArrayInputStream(numbers);

        input.skip(2);

        System.out.print("Input stream after skipping 2 bytes: ");
        System.out.println(Arrays.toString(input.readAllBytes())); // 3, 4, 5

        input.close();
    }
}

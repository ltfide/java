package dev.local;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

    @Test
    void testReadFileWithByteArray() throws IOException {
        byte[] bytes = new byte[100];

        InputStream inputStream = new FileInputStream("input.txt");

        System.out.println("input available/length: " + inputStream.available());

        // Read byte from the input stream
        inputStream.read(bytes);

        // Convert byte array into string
        String data = new String(bytes);

        System.out.println(data);

        inputStream.close();
    }

    @Test
    void testReadFileWithReadAllBytes() throws IOException {
        InputStream inputStream = new FileInputStream("input.txt");

        System.out.println("input available/length: " + inputStream.available());

        String data = new String(inputStream.readAllBytes());

        System.out.println(data);

        inputStream.close();
    }

    @Test
    void testReadFileWithRead() throws IOException {
        InputStream inputStream = new FileInputStream("input.txt");

        String result = "";
        int data;

        while ((data = inputStream.read()) != -1) {
            result += (char) data;
        }

        System.out.println(result.trim()); // this is sample txt
        System.out.println(result.length()); // 18

        inputStream.close();
    }
}

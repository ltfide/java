package dev.local;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamTest {

    @Test
    void readFile() throws IOException {
        FileInputStream inputStream = new FileInputStream("input.txt");
        BufferedInputStream buffer = new BufferedInputStream(inputStream);

        byte[] bytes = buffer.readAllBytes();
        String data = new String(bytes);

        System.out.println(data); // this is sample txt

        buffer.close();
        inputStream.close();
    }
}

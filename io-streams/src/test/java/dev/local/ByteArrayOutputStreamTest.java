package dev.local;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {

    @Test
    void testFromASCII() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(72);
        bos.write(101);
        bos.write(108);
        bos.write(108);
        bos.write(111);
        byte[] byteArray = bos.toByteArray();
        for (byte b : byteArray) {
            System.out.print((char) b);
        }
        bos.close();
    }

    @Test
    void writeFromString() throws IOException {
        String data = "This is simple text";

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        byte[] bytes = data.getBytes();

        output.write(bytes);

        String streamData = output.toString();
        System.out.println(streamData);

        output.close();
    }
}

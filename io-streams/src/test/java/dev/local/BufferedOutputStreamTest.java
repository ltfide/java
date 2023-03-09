package dev.local;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

    @Test
    void testWriteFile() throws IOException {
        FileOutputStream output = new FileOutputStream("flush.txt");
        BufferedOutputStream outputStream = new BufferedOutputStream(output);

        String text = "This is a demo of the flush method";
        byte[] textBytes = text.getBytes();
        outputStream.write(textBytes);

        outputStream.flush();

        outputStream.close();
        output.close();
    }

    @Test
    void arraytest() {
        byte[] i = new byte[]{116, 104};
        System.out.println(new String(i)); // th
    }
}

package dev.local;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputStreamTest {

    @Test
    void testWriteFile() throws Exception {
        String text = "This is a line of text inside the file.";

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        byte[] bytes = text.getBytes();
        outputStream.write(bytes);

        outputStream.close();
    }

    @Test
    void testWriteFileWithOutputStreamWriter() throws Exception {
        String text = "This is a line of text inside the file2.";

        FileOutputStream outputStream = new FileOutputStream("output2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);

        osw.write(text);
        osw.close();
    }

    @Test
    void testWriteImageFromURL() throws Exception {
        String source = "https://spring.io/img/spring.svg";
        URL imageURL = new URL(source);

        InputStream inputStream = imageURL.openStream();
        String filename = source.substring(source.lastIndexOf('/') + 1);
        FileOutputStream outputStream = new FileOutputStream(filename);

        outputStream.write(inputStream.readAllBytes());
        // memastikan bahwa semua data yang ada di dalam buffer OutputStream dikirimkan ke target output
        outputStream.flush();
        outputStream.close();
    }

    @Test
    void testOutputStream() throws IOException {
        Path path = Path.of("hello.txt");
        String content = "Hello World \n";
        try (java.io.OutputStream stream = Files.newOutputStream(path)) {
            for (int i = 0; i < 10; i++) {
                stream.write(content.getBytes());
                stream.flush();
            }
        }
    }
}

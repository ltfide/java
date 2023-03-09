package dev.local;

import org.junit.jupiter.api.Test;

import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.net.URL;

public class OutputStream {

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
}

package dev.local;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {

    @Test
    void testWriteFile() throws IOException {
        FileOutputStream output = new FileOutputStream("file.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(output);

        outputStream.writeInt(10);
        outputStream.writeBoolean(true);
        outputStream.writeObject(new String("Test"));

        // file.txt
        // ¬í w
        // t Test

        // Memastikan data yang masih tertunda di tulis
        // kedalam stream sebelum ditutup
        output.flush();

        outputStream.close();
        output.close();
    }
}

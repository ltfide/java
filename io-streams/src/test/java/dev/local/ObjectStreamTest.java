package dev.local;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamTest {

    @Test
    void savePerson() {
        Person person = new Person();
        person.setId("01");
        person.setName("Lutfi");

        Path path = Path.of("lutfi.person");

        try (OutputStream stream = Files.newOutputStream(path);
             ObjectOutputStream outputStream = new ObjectOutputStream(stream)) {
            outputStream.writeObject(person);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPerson() {
        Path path = Path.of("lutfi.person");

        try (InputStream inputStream = Files.newInputStream(path);
             ObjectInputStream stream = new ObjectInputStream(inputStream)) {

            Person person = (Person) stream.readObject();
            System.out.println(person.getId());
            System.out.println(person.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

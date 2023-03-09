package dev.local;

import org.junit.jupiter.api.Test;

import java.io.*;

public class ObjectInputStreamTest {

    public static class Person implements Serializable {
        public String firstName;
        public String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    @Test
    void readFile() throws IOException, ClassNotFoundException {
        int data1 = 5;
        String data2 = "This is programiz";

        FileOutputStream file = new FileOutputStream("file.txt");
        ObjectOutputStream output = new ObjectOutputStream(file);

        // Writing to the file using ObjectOutputStream
        // Serialization
        output.writeInt(data1);
        output.writeObject(data2);

        FileInputStream fileStream = new FileInputStream("file.txt");
        // Creating an object input stream
        ObjectInputStream objStream = new ObjectInputStream(fileStream);

        // Using the readInt() method
        // Deserialization
        System.out.println("Integer data :" + objStream.readInt());

        // Using the readObject() method
        System.out.println("String data: " + objStream.readObject());

        output.close();
        objStream.close();
    }

    @Test
    void readFileFromObject() throws IOException, ClassNotFoundException {
        // Creates an object of Person Class
        Person person = new Person("Lutfi", "Dendiansyah");

        FileOutputStream output = new FileOutputStream("file.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(output);

        // Serialization
        outputStream.writeObject(person);

        // file.txt
        // ¬í sr &dev.local.ObjectInputStreamTest$PersonÙ:ätê L
        // firstNamet Ljava/lang/String;L lastNameq ~ xpt Lutfit Dendiansyah

        FileInputStream input = new FileInputStream("file.txt");
        ObjectInputStream inputStream = new ObjectInputStream(input);

        // Deserialization
        Person newPerson = (Person) inputStream.readObject();

        System.out.println("Firstname: " + newPerson.firstName);
        System.out.println("Lastname: " + newPerson.lastName);

        input.close();
        output.close();
        inputStream.close();
        outputStream.close();

        // output
        // Firstname: Lutfi
        // Lastname: Dendiansyah
    }
}

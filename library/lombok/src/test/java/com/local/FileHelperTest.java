package com.local;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileHelperTest {

    @Test
    void testPom() throws Exception {
        String text = FileHelper.loadFile("pom.xml");
        System.out.println(text);
    }

    @Test
    void testFileNotFound() {
        assertThrows(FileNotFoundException.class, () -> {
            FileHelper.loadFile("tidakada.txt");
        });
    }
}
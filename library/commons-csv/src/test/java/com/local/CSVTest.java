package com.local;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

public class CSVTest {

    @Test
    void createCSV() throws IOException {
        StringWriter writer = new StringWriter();

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("lutfi", "teknik", 100);
        printer.printRecord("lisa", "marketing", 100);
        printer.printRecord("lili", "dokter", 100);
        printer.flush();
        printer.close();

        String csv = writer.getBuffer().toString();
        System.out.println(csv);
        // lutfi,teknik,100
        // lisa,marketing,100
        // lili,dokter,100
    }

    @Test
    void readCSV() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord record : parser) {
            System.out.println("First Name : " + record.get(0));
            System.out.println("Last Name : " + record.get(1));
            System.out.println("Value : " + record.get(2));
        }

        reader.close();
        parser.close();

        // output
        // First Name : lutfi
        // Last Name : teknik
        // Value : 100
        // First Name : lisa
        // Last Name : marketing
        // Value : 100
        // First Name : lili
        // Last Name : dokter
        // Value : 100
    }
}

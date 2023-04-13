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

    @Test
    void testReadCSVWithHeader() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().build();
        CSVParser parser = new CSVParser(reader, format);
        for (CSVRecord record : parser) {
            System.out.println("Name: " + record.get("Name"));
            System.out.println("Study: " + record.get("Study"));
            System.out.println("Grade: " + record.get("Grade"));
        }

        reader.close();
        parser.close();

        // output
        // Name: lutfi
        // Study: teknik
        // Grade: 100
        // Name: lisa
        // Study: marketing
        // Grade: 100
        // Name: lili
        // Study: dokter
        // Grade: 100
    }

    @Test
    void createCSVWithHeader() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("Name", "Study", "Grade").build();
        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("lutfi", "teknik", 100);
        printer.printRecord("lisa", "marketing", 100);
        printer.printRecord("lili", "dokter", 100);

        String csv = writer.getBuffer().toString();
        System.out.println(csv);

        writer.close();
        printer.flush();
        printer.close();

        // output
        // Name,Study,Grade
        // lutfi,teknik,100
        // lisa,marketing,100
        // lili,dokter,100
    }

    @Test
    void createCSVWithCustomFormat() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.newFormat('*').builder()
                .setHeader("First Name", "Last Name", "Value")
                .build();
        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("Lutfi", "Dendiansyah", 100);
        printer.flush();

        String csv = writer.getBuffer().toString();
        System.out.println(csv); // First Name*Last Name*ValueLutfi*Dendiansyah*100

        writer.close();
        printer.close();
    }

    @Test
    void createCSVWithTab() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.TDF.builder()
                .setHeader("First Name", "Last Name", "Value")
                .build();
        CSVPrinter printer = new CSVPrinter(writer, format);
        printer.printRecord("Lutfi", "Dendiansyah", 100);
        printer.flush();

        String csv = writer.getBuffer().toString();
        System.out.println(csv);
        // First Name Last Name Value
        // Lutfi Dendiansyah 100

        writer.close();
        printer.close();
    }
}

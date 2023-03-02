package belajar.java.i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

    @Test
    void testNumberFormat() {
        var usa = new Locale("en", "US");
        var numberFormat = NumberFormat.getInstance(usa);
        var format = numberFormat.format(100000000.255);
        System.out.println(format); // 100,000,000.255
    }

    @Test
    void testNumberFormatIndonesia() {
        var indonesia = new Locale("in", "ID");
        var numberFormat = NumberFormat.getInstance(indonesia);
        var format = numberFormat.format(100000000.255);
        System.out.println(format); // 100.000.000,255
    }

    @Test
    void testNumberFormatParseIndonesia() {
        var indonesia = new Locale("in", "ID");
        var numberFormat = NumberFormat.getInstance(indonesia);

        try {
            var result = numberFormat.parse("10.000.000,255").doubleValue();
            System.out.println(result); // 1.0000000255E7
        } catch (ParseException e) {
            System.out.println("ERROR PARSE: " + e.getMessage());
        }
    }

}

package belajar.java.i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {

    @Test
    void testCurrencyIndonesia() {
        var indonesia = new Locale("in", "ID");
        Currency currency = Currency.getInstance(indonesia);

        System.out.println(currency.getDisplayName()); // Indonesia Rupiah
        System.out.println(currency.getSymbol()); // IDR
        System.out.println(currency.getCurrencyCode()); // IDR
        System.out.println(currency.getSymbol(indonesia)); // Rp
    }

    @Test
    void testCurrencyUSA() {
        var usa = new Locale("en", "US");
        Currency currency = Currency.getInstance(usa);

        System.out.println(currency.getDisplayName()); // US Dollar
        System.out.println(currency.getCurrencyCode()); // USD
        System.out.println(currency.getSymbol(usa)); // $
    }

    @Test
    void testNumberFormatCurrencyIndonesia() {
        var indonesia = new Locale("in", "ID");
        var numberFormat = NumberFormat.getCurrencyInstance(indonesia);

        var format = numberFormat.format(100000000.33);
        System.out.println(format); // Rp100.000.000,33
    }

    @Test
    void testNumberFormatCurrencyParseIndonesia() {
        var indonesia = new Locale("in", "ID");
        var numberFormat = NumberFormat.getCurrencyInstance(indonesia);

        try {
            var parse = numberFormat.parse("Rp100.000.000,33").doubleValue();
            System.out.println(parse); // 1.0000000033E8
        } catch (ParseException e) {
            System.out.println("ERROR PARSE: " + e.getMessage());
        }
    }

}

package belajar.java.i18n;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

    @Test
    void testDateFormat() {
        var pattern = "EEEE dd MMMM yyyy";
        var dateFormat = new SimpleDateFormat(pattern);

        var format = dateFormat.format(new Date());
        System.out.println(format); // Kamis 02 Maret 2023
    }

    @Test
    void testDateFormatIndonesia() {
        var pattern = "EEEE dd MMMM yyyy";
        var indonesia = new Locale("in", "ID");
        var dateFormat = new SimpleDateFormat(pattern, indonesia);

        var format = dateFormat.format(new Date());
        System.out.println(format); // Kamis 02 Maret 2023
    }

    @Test
    void testDateFormatJapan() {
        var pattern = "EEEE dd MMMM yyyy";
        var japan = new Locale("ja", "JP");
        var dateFormat = new SimpleDateFormat(pattern, japan);

        var format = dateFormat.format(new Date());
        System.out.println(japan.getCountry()); // JP
        System.out.println(japan.getLanguage()); // ja
        System.out.println(japan.getDisplayLanguage()); // Japanese
        System.out.println(japan.getDisplayCountry()); // Japan
        System.out.println(format); // 木曜日 02 3月 2023
    }

    @Test
    void testDateFormatParseIndonesia() {
        var pattern = "EEEE dd MMMM yyyy";
        var indonesia = new Locale("ja", "JP");
        var dateFormat = new SimpleDateFormat(pattern, indonesia);

        try {
            var date = dateFormat.parse("木曜日 02 3月 2023");
            System.out.println(date); // Thu Mar 02 00:00:00 WIB 2023
        } catch (ParseException e) {
            System.out.println("ERROR PARSE: " + e.getMessage());
        }
    }

}

package belajar.java.i18n;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class LocaleTest {

    @Test
    void testNewLocale() {
        var language = "in";
        var country = "ID";
        var locale = new Locale(language, country);

        System.out.println(locale.getLanguage()); // id
        System.out.println(locale.getCountry()); // ID

        System.out.println(locale.getDisplayLanguage()); // Indonesian
        System.out.println(locale.getDisplayCountry()); // Indonesia
    }

    @Test
    void testNewLocaleUS() {
        var language = "en";
        var country = "US";
        var locale = new Locale(language, country);

        System.out.println(locale.getLanguage()); // en
        System.out.println(locale.getCountry()); // US

        System.out.println(locale.getDisplayLanguage()); // English
        System.out.println(locale.getDisplayCountry()); // United States
    }

}

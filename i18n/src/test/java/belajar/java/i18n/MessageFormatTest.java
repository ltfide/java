package belajar.java.i18n;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTest {

    @Test
    void testMessageFormat() {
        var pattern = "Hi {0}, Anda bisa mencari data Anda dengan mengetikkan \"{0}\" di pencarian.";
        var messageFormat = new MessageFormat(pattern);

        var format = messageFormat.format(new Object[] {
                "Lutfi"
        });
        System.out.println(format);
        // output
        // Hi Lutfi, Anda bisa mencari data Anda dengan mengetikkan "Lutfi" di
        // pencarian.
    }

    @Test
    void testMessageFormatResourceBundle() {
        var locale = new Locale("in", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("welcome.message");

        var messageFormat = new MessageFormat(pattern);
        var format = messageFormat.format(new Object[] {
                "Lutfi", "Indonesia"
        });
        System.out.println(format); // Hi Lutfi, Selamat datang di Indonesia
    }

}

package belajar.java.i18n;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTypeTest {

    @Test
    void testMessageFormatType() {
        var locale = new Locale("in", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("status");

        var messageFormat = new MessageFormat(pattern, locale);
        var format = messageFormat.format(new Object[] {
                "Lutfi", new Date(), 1000000
        });
        System.out.println(format);
        // output
        // Halo Lutfi, Sekarang Kamis, 02 Maret 2023, saldo Anda adalah Rp1.000.000,00
    }

    @Test
    void testMessageFormatTypeAmerica() {
        var locale = new Locale("en", "US");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("status");

        var messageFormat = new MessageFormat(pattern, locale);
        var format = messageFormat.format(new Object[] {
                "Lutfi", new Date(), 1000000
        });
        System.out.println(format);
        // output
        // Hi Lutfi, Now Thursday, 02 March 2023, your balance is $1,000,000.00
    }

}

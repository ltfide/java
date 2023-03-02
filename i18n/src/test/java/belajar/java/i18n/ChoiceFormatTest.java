package belajar.java.i18n;

import org.junit.jupiter.api.Test;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChoiceFormatTest {

    @Test
    void testChoiceFormat() {
        var pattern = "-1#negatif | 0#kosong | 1#satu | 1<banyak";
        var choiceFormat = new ChoiceFormat(pattern);

        System.out.println(choiceFormat.format(-2)); // negatif
        System.out.println(choiceFormat.format(-1)); // negatif
        System.out.println(choiceFormat.format(0)); // kosong
        System.out.println(choiceFormat.format(1)); // satu
        System.out.println(choiceFormat.format(2)); // banyak
        System.out.println(choiceFormat.format(3)); // banyak
    }

    @Test
    void testChoiceFormatInMessageFormat() {
        var locale = new Locale("in", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("balance");

        var messageFormat = new MessageFormat(pattern, locale);
        // Total Saldo: -curreny 10000000 Hutang
        System.out.println(messageFormat.format(new Object[] { -10000000 }));
        // Total Saldo: curreny 0 Kosong
        System.out.println(messageFormat.format(new Object[] { 0 }));
        // Total Saldo: curreny 100000000 Tersedia
        System.out.println(messageFormat.format(new Object[] { 100000000 }));
    }

    @Test
    void testChoiceFormatInMessageFormatUSA() {
        var locale = new Locale("en", "US");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("balance");

        var messageFormat = new MessageFormat(pattern, locale);
        // Total Balance: -curreny10000000 Debt
        System.out.println(messageFormat.format(new Object[] { -10000000 }));
        // Total Balance: curreny0 Zero
        System.out.println(messageFormat.format(new Object[] { 0 }));
        // Total Balance: curreny100000000 Available
        System.out.println(messageFormat.format(new Object[] { 100000000 }));
    }

}

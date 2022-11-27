package belajar.unit.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class StringMethodTest {

    @Test
    void testEquals() {
        String name = "OK TWO";
        String nameTwo = name;
        String nameFour = new String("OK");
        Boolean nameThree = name == nameFour;

        LocalDate myObj = LocalDate.now();
        Date data = new Date();

        System.out.println(myObj);
        System.out.println(data.getTime());
        System.out.println(nameThree);

        for (String n : name.split(" ")) {
            System.out.println(n);
        }

        assertSame(name, nameTwo);

    }

}

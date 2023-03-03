package belajar.date.time;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTest {

    @Test
    void create() {
        var date1 = new Date();
        var date2 = new Date(System.currentTimeMillis());
        var date3 = new Date(1665396369000L);

        System.out.println(date1); // Fri Mar 03 06:30:41 WIB 2023
        System.out.println(date2); // Fri Mar 03 06:30:41 WIB 2023
        System.out.println(date3); // Mon Oct 10 17:06:09 WIB 2022
    }

}

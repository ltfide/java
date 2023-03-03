package belajar.date.time;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    @Test
    void testCreate() {
        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();
        System.out.println(date); // Fri Mar 03 06:34:24 WIB 2023
    }

    @Test
    void testModifyCalendar() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, 1998);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 06);
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 40);
        calendar.set(Calendar.MILLISECOND, 100);

        Date date = calendar.getTime();
        System.out.println(date); // Wed May 06 15:50:40 WIB 1998
        System.out.println(date.getTime()); // 894444640100
    }

    @Test
    void getCalendar() {
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.YEAR)); // 2023
        System.out.println(calendar.get(Calendar.MONTH)); // 2
        System.out.println(calendar.get(Calendar.DATE)); // 3
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 3
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); // 6
        System.out.println(calendar.get(Calendar.HOUR)); // 6
    }

}

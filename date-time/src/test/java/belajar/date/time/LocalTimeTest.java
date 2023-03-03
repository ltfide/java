package belajar.date.time;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class LocalTimeTest {

    @Test
    void create() {

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(10, 10, 10);
        LocalTime localTime3 = LocalTime.parse("08:08");

        System.out.println(localTime1); // 07:22:42.671832900
        System.out.println(localTime2); // 10:10:10
        System.out.println(localTime3); // 08:08

    }

    @Test
    void change() {

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localTime1.withHour(10);
        LocalTime localTime3 = localTime1.withHour(5).withMinute(10).withSecond(0);

        System.out.println(localTime1); // 07:28:31.590397200
        System.out.println(localTime2); // 10:28:31.590397200
        System.out.println(localTime3); // 05:10:00.590397200

    }

    @Test
    void modify() {

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = localTime1.plusHours(10);
        LocalTime localTime3 = localTime1.plusHours(5).minusMinutes(10).minusSeconds(5);

        System.out.println(localTime1); // 07:29:03.782595100
        System.out.println(localTime2); // 17:29:03.782595100
        System.out.println(localTime3); // 12:18:58.782595100

    }

    @Test
    void get() {
        LocalTime localTime = LocalTime.now();

        System.out.println(localTime.getHour()); // 7
        System.out.println(localTime.getMinute()); // 29
        System.out.println(localTime.getSecond()); // 55
        System.out.println(localTime.getNano()); // 540021800
    }
}

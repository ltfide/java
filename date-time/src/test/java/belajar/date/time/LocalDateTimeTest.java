package belajar.date.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class LocalDateTimeTest {

   @Test
   void create() {
      LocalDateTime localDateTime = LocalDateTime.now();
      LocalDateTime localDateTime2 = LocalDateTime.of(1990, 10, 3, 10, 23, 43);
      LocalDateTime localDateTime3 = LocalDateTime.parse("1990-10-03T10:23:43");

      System.out.println(localDateTime); // 2023-03-03T07:40:58.076581300
      System.out.println(localDateTime2); // 1990-10-03T10:23:43
      System.out.println(localDateTime3); // 1990-10-03T10:23:43
   }

   @Test
   void with() {
      LocalDateTime localDateTime = LocalDateTime.now();
      LocalDateTime localDateTime2 = localDateTime.withYear(1990).withMonth(5);
      LocalDateTime localDateTime3 = localDateTime.withYear(2003).withHour(2);

      System.out.println(localDateTime); // 2023-03-03T07:41:37.724765900
      System.out.println(localDateTime2); // 1990-05-03T07:41:37.724765900
      System.out.println(localDateTime3); // 2003-03-03T02:41:37.724765900
   }

   @Test
   void modify() {
      LocalDateTime localDateTime1 = LocalDateTime.now();
      LocalDateTime localDateTime2 = localDateTime1.withYear(2020).minusMonths(2);
      LocalDateTime localDateTime3 = localDateTime1.withYear(2003).plusMonths(10);

      System.out.println(localDateTime1); // 2023-03-03T07:42:05.330211600
      System.out.println(localDateTime2); // 2020-01-03T07:42:05.330211600
      System.out.println(localDateTime3); // 2004-01-03T07:42:05.330211600
   }

   @Test
   void get() {
      LocalDateTime localDateTime = LocalDateTime.now();

      System.out.println(localDateTime.getYear()); // 2023
      System.out.println(localDateTime.getMonth()); // MARCH
      System.out.println(localDateTime.getMonthValue()); // 3
      System.out.println(localDateTime.getDayOfMonth()); // 3
      System.out.println(localDateTime.getDayOfWeek()); // FRIDAY
      System.out.println(localDateTime.getHour()); // 7
      System.out.println(localDateTime.getMinute()); // 42
      System.out.println(localDateTime.getSecond()); // 24
      System.out.println(localDateTime.getNano()); // 243743800
   }

   @Test
   void date() {
      LocalDateTime localDateTime = LocalDateTime.now();
      System.out.println(localDateTime); // 2023-03-03T07:44:43.351284300

      LocalDate localDate = localDateTime.toLocalDate();
      System.out.println(localDate); // 2023-03-03

      LocalDateTime result = localDate.atTime(10, 10, 10, 10);
      System.out.println(result); // 2023-03-03T10:10:10.000000010
   }

   @Test
   void time() {
      LocalDateTime localDateTime = LocalDateTime.now();
      System.out.println(localDateTime); // 2023-03-03T07:45:28.920631800

      LocalTime localTime = localDateTime.toLocalTime();
      System.out.println(localTime); // 07:45:28.920631800

      LocalDateTime result = localTime.atDate(LocalDate.now());
      System.out.println(result); // 2023-03-03T07:45:28.920631800
   }

}

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

      System.out.println(localDateTime);
      System.out.println(localDateTime2);
      System.out.println(localDateTime3);
   }

   @Test
   void with() {
      LocalDateTime localDateTime = LocalDateTime.now();
      LocalDateTime localDateTime2 = localDateTime.withYear(1990).withMonth(5);
      LocalDateTime localDateTime3 = localDateTime.withYear(2003).withHour(2);

      System.out.println(localDateTime);
      System.out.println(localDateTime2);
      System.out.println(localDateTime3);
   }

   @Test
   void modify() {
      LocalDateTime localDateTime1 = LocalDateTime.now();
      LocalDateTime localDateTime2 = localDateTime1.withYear(2020).minusMonths(2);
      LocalDateTime localDateTime3 = localDateTime1.withYear(2003).plusMonths(10);

      System.out.println(localDateTime1);
      System.out.println(localDateTime2);
      System.out.println(localDateTime3);
   }

   @Test
   void get() {
      LocalDateTime localDateTime = LocalDateTime.now();

      System.out.println(localDateTime.getYear());
      System.out.println(localDateTime.getMonth());
      System.out.println(localDateTime.getMonthValue());
      System.out.println(localDateTime.getDayOfMonth());
      System.out.println(localDateTime.getDayOfWeek());
      System.out.println(localDateTime.getHour());
      System.out.println(localDateTime.getMinute());
      System.out.println(localDateTime.getSecond());
      System.out.println(localDateTime.getNano());
   }

   @Test
   void date() {
      LocalDateTime localDateTime = LocalDateTime.now();
      System.out.println(localDateTime);

      LocalDate localDate = localDateTime.toLocalDate();
      System.out.println(localDate);

      LocalDateTime result = localDate.atTime(10,10,10,10);
      System.out.println(result);
   }  
   
   @Test
   void time() {
      LocalDateTime localDateTime = LocalDateTime.now();
      System.out.println(localDateTime);

      LocalTime localTime = localDateTime.toLocalTime();
      System.out.println(localTime);

      LocalDateTime result = localTime.atDate(LocalDate.now()); 
      System.out.println(result);
   }  

}

package belajar.date.time;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalDateTest {
   
   @Test
   void testCreate() {
      LocalDate localDate1 = LocalDate.now();
      LocalDate localDate2 = LocalDate.of(1999, 1, 10);
      LocalDate localDate3 = LocalDate.parse("1990-01-10");

      System.out.println(localDate1);
      System.out.println(localDate2);
      System.out.println(localDate3);
   }

   @Test
   void testWith() {
      LocalDate localDate1 = LocalDate.now();
      LocalDate localDate2 = localDate1.withYear(1999);
      LocalDate localDate3 = localDate1.withYear(1990).withMonth(1);

      System.out.println(localDate1);
      System.out.println(localDate2);
      System.out.println(localDate3);
   }

   @Test
   void modify() {
      LocalDate localDate1 = LocalDate.now();
      LocalDate localDate2 = localDate1.plusYears(10);
      LocalDate localDate3 = localDate1.minusYears(2);

      System.out.println(localDate1);
      System.out.println(localDate2);
      System.out.println(localDate3);
   }

   @Test
   @DisplayName("Get detail date")
   void get() {
      LocalDate localDate1 = LocalDate.now();

      System.out.println(localDate1.getYear());
      System.out.println(localDate1.getMonth());
      System.out.println(localDate1.getMonthValue());
      System.out.println(localDate1.getDayOfWeek());
      System.out.println(localDate1.getDayOfYear());
   }

}

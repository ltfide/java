package belajar.date.time;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.Test;

public class PeriodTest {

   @Test
   void create() {
      Period period1 = Period.ofDays(10);
      Period period2 = Period.ofWeeks(10);
      Period period3 = Period.ofMonths(10);
      Period period4 = Period.ofYears(10);
      Period period5 = Period.of(10, 10, 10);

      System.out.println(period1); // P10D
      System.out.println(period2); // P70D
      System.out.println(period3); // P10M
      System.out.println(period4); // P10Y
      System.out.println(period5); // P10Y10M10D
   }

   @Test
   void get() {
      Period period = Period.of(10, 10, 10);

      System.out.println(period.getYears()); // 10
      System.out.println(period.getMonths()); // 10
      System.out.println(period.getDays()); // 10
   }

   @Test
   void between() {
      Period period = Period.between(
            LocalDate.of(1998, 5, 6),
            LocalDate.now());

      System.out.println(period.getYears()); // 24
      System.out.println(period.getMonths()); // 9
      System.out.println(period.getDays()); // 26
   }

}

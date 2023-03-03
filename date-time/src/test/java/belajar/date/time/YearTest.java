package belajar.date.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

import org.junit.jupiter.api.Test;

public class YearTest {

   @Test
   void create() {
      Year year1 = Year.now();
      Year year2 = Year.of(1998);
      Year year3 = Year.parse("2020");

      System.out.println(year1); // 2023
      System.out.println(year2); // 1998
      System.out.println(year3); // 2020

      YearMonth yearMonth1 = YearMonth.now();
      YearMonth yearMonth2 = YearMonth.of(1990, Month.MARCH);
      YearMonth yearMonth3 = YearMonth.parse("2020-09");

      System.out.println(yearMonth1); // 2023-03
      System.out.println(yearMonth2); // 1990-03
      System.out.println(yearMonth3); // 2020-09

      MonthDay monthDay1 = MonthDay.now();
      MonthDay monthDay2 = MonthDay.of(05, 11);
      MonthDay monthDay3 = MonthDay.parse("--10-09");

      System.out.println(monthDay1); // --03-04
      System.out.println(monthDay2); // --05-11
      System.out.println(monthDay3); // --10-09
   }

   @Test
   void name() {
      Year year = Year.of(1998);
      System.out.println(year); // 1998

      LocalDate localDate = year.atMonth(Month.MAY).atDay(06);
      System.out.println(localDate); // 1998-05-06

      MonthDay monthDay = MonthDay.from(localDate);
      System.out.println(monthDay); // --05-06
   }

   @Test
   void get() {
      Year year = Year.now();
      YearMonth yearMonth = YearMonth.now();
      MonthDay monthDay = MonthDay.now();

      System.out.println(year.getValue()); // 2023
      System.out.println(yearMonth.getYear()); // 2023
      System.out.println(yearMonth.getMonth()); // MARCH
      System.out.println(monthDay.getMonth()); // MARCH
      System.out.println(monthDay.getDayOfMonth()); // 4
   }

}

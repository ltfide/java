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

      System.out.println(year1);
      System.out.println(year2);
      System.out.println(year3);

      YearMonth yearMonth1 = YearMonth.now();
      YearMonth yearMonth2 = YearMonth.of(1990, Month.MARCH);
      YearMonth yearMonth3 = YearMonth.parse("2020-09");

      System.out.println(yearMonth1);
      System.out.println(yearMonth2);
      System.out.println(yearMonth3);

      MonthDay monthDay1 = MonthDay.now();
      MonthDay monthDay2 = MonthDay.of(05, 11);
      MonthDay monthDay3 = MonthDay.parse("--10-09");

      System.out.println(monthDay1);
      System.out.println(monthDay2);
      System.out.println(monthDay3);
   }

   @Test
   void name() {
      Year year = Year.of(1998);
      System.out.println(year);

      LocalDate localDate = year.atMonth(Month.MAY).atDay(06);
      System.out.println(localDate);

      MonthDay monthDay = MonthDay.from(localDate);
      System.out.println(monthDay);
   }

   @Test
   void get() {
      Year year = Year.now();
      YearMonth yearMonth = YearMonth.now();
      MonthDay monthDay = MonthDay.now();

      System.out.println(year.getValue());
      System.out.println(yearMonth.getYear());
      System.out.println(yearMonth.getMonth());
      System.out.println(monthDay.getMonth());
      System.out.println(monthDay.getDayOfMonth());
   }

}

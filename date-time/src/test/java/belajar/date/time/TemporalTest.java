package belajar.date.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.Year;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TemporalTest {

   @Test
   void temporal() {
      Temporal temporal1 = LocalDate.now();
      Temporal temporal2 = LocalTime.now();
      Temporal temporal3 = ZonedDateTime.now();
      Temporal temporal4 = Year.now();

      System.out.println(temporal1); // 2023-03-04
      System.out.println(temporal2); // 08:15:02.279534100
      System.out.println(temporal3); // 2023-03-04T08:15:02.280531500+07:00[Asia/Jakarta]
      System.out.println(temporal4); // 2023
   }

   @Test
   void temporalAmount() {
      Temporal temporal1 = LocalDateTime.now();
      Temporal temporal2 = temporal1.plus(Duration.ofHours(10));
      Temporal temporal3 = temporal1.plus(Period.ofDays(10));

      System.out.println(temporal1); // 2023-03-04T08:15:57.246266200
      System.out.println(temporal2); // 2023-03-04T18:15:57.246266200
      System.out.println(temporal3); // 2023-03-14T08:15:57.246266200
   }

   @Test
   void temporalUnit() {
      long temporalUnit1 = ChronoUnit.DAYS.between(LocalDateTime.now(), LocalDateTime.now().plusHours(10));

      System.out.println(temporalUnit1); // 0
   }

   @Test
   void temporalField() {
      LocalDateTime temporal = LocalDateTime.now();

      System.out.println(temporal.get(ChronoField.YEAR)); // 2023
      System.out.println(temporal.get(ChronoField.MONTH_OF_YEAR)); // 3
      System.out.println(temporal.get(ChronoField.DAY_OF_MONTH)); // 4
      System.out.println(temporal.get(ChronoField.HOUR_OF_DAY)); // 8
      System.out.println(temporal.get(ChronoField.MINUTE_OF_HOUR)); // 16
      System.out.println(temporal.get(ChronoField.SECOND_OF_MINUTE)); // 41
      System.out.println(temporal.get(ChronoField.MILLI_OF_SECOND)); // 897
      System.out.println(temporal.get(ChronoField.MICRO_OF_SECOND)); // 897632
      System.out.println(temporal.get(ChronoField.NANO_OF_SECOND)); // 897632100
   }

   @Test
   void temporalQuery() {
      Temporal temporal = LocalDateTime.now();

      List<Integer> integers = temporal.query(new TemporalQuery<List<Integer>>() {
         @Override
         public List<Integer> queryFrom(TemporalAccessor temporal) {
            ArrayList<Integer> list = new ArrayList<>();

            list.add(temporal.get(ChronoField.YEAR));
            list.add(temporal.get(ChronoField.MONTH_OF_YEAR));
            list.add(temporal.get(ChronoField.DAY_OF_MONTH));

            return list;
         }
      });

      System.out.println(integers); // [2023, 3, 4]
   }

   @Test
   void temporalAdjuster() {
      Temporal temporal1 = LocalDate.now();
      System.out.println(temporal1); // 2023-03-04

      Temporal temporal2 = temporal1.with(new TemporalAdjuster() {
         @Override
         public Temporal adjustInto(Temporal temporal) {
            return LocalDate.of(
                  temporal.get(ChronoField.YEAR),
                  temporal.get(ChronoField.MONTH_OF_YEAR),
                  1);
         }
      });
      System.out.println(temporal2); // 2023-03-01

      Temporal temporal3 = temporal1.with(TemporalAdjusters.firstDayOfMonth());
      System.out.println(temporal3); // 2023-03-01
      Temporal temporal4 = temporal1.with(TemporalAdjusters.lastDayOfMonth());
      System.out.println(temporal4); // 2023-03-31
   }

}

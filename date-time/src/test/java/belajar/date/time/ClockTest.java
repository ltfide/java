package belajar.date.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

public class ClockTest {

   @Test
   void create() {
      Clock clock1 = Clock.systemUTC();
      System.out.println(clock1); // SystemClock[Z]

      Clock clock2 = Clock.systemDefaultZone();
      System.out.println(clock2); // SystemClock[Asia/Jakarta]

      Clock clock3 = Clock.system(ZoneId.of("Asia/Jakarta"));
      System.out.println(clock3); // SystemClock[Asia/Jakarta]
   }

   @Test
   void instant() throws InterruptedException {
      Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));

      Instant instant1 = clock.instant();
      System.out.println(instant1); // 2023-03-04T00:17:56.760747200Z

      Thread.sleep(10_000);

      Instant instant2 = clock.instant();
      System.out.println(instant2); // 2023-03-04T00:18:06.779919700Z
   }

   @Test
   void fromClock() {
      Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));

      Year year = Year.now(clock);
      System.out.println(year); // 2023

      YearMonth yearMonth = YearMonth.now(clock);
      MonthDay monthDay = MonthDay.now(clock);
      LocalTime localTime = LocalTime.now(clock);
      LocalDateTime localDateTime = LocalDateTime.now(clock);
      OffsetTime offsetTime = OffsetTime.now(clock);
      OffsetDateTime offsetDateTime = OffsetDateTime.now(clock);
      ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);

      System.out.println(yearMonth); // 2023-03
      System.out.println(monthDay); // --03-04
      System.out.println(localTime); // 07:18:49.572692300
      System.out.println(localDateTime); // 2023-03-04T07:18:49.572692300
      System.out.println(zonedDateTime); // 2023-03-04T07:18:49.578679500+07:00[Asia/Jakarta]
      System.out.println(offsetDateTime); // 2023-03-04T07:18:49.575684200+07:00
      System.out.println(offsetTime); // 07:18:49.573688700+07:00
   }

}

package belajar.date.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

public class LegacyTest {

   @Test
   void fromLegacy() {
      Date date = new Date();
      System.out.println(date); // Sat Mar 04 09:21:50 WIB 2023
      Instant instant = date.toInstant();
      System.out.println(instant); // 2023-03-04T02:21:50.712Z

      Calendar calendar = Calendar.getInstance();
      System.out.println(calendar); // java.util.GregorianCalendar[time=1677896510768 ...
      Instant instant1 = calendar.toInstant();
      System.out.println(instant1); // 2023-03-04T02:21:50.768Z

      TimeZone timeZone = TimeZone.getDefault();
      System.out.println(timeZone); // sun.util.calendar.ZoneInfo[id="Asia/Jakarta" ...
      ZoneId zoneId = timeZone.toZoneId();
      System.out.println(zoneId); // Asia/Jakarta
   }

   @Test
   void toLegacy() {
      ZonedDateTime zonedDateTime = ZonedDateTime.now();

      Date date = Date.from(zonedDateTime.toInstant());

      Calendar calendar = GregorianCalendar.from(zonedDateTime);

      ZoneId zoneId = ZoneId.systemDefault();
      TimeZone timeZone = TimeZone.getTimeZone(zoneId);

      System.out.println(date); // Sat Mar 04 09:23:24 WIB 2023
      System.out.println(calendar); // java.util.GregorianCalendar[time=1677896604408...
      System.out.println(timeZone); // sun.util.calendar.ZoneInfo[id="Asia/Jakarta"...
   }

}

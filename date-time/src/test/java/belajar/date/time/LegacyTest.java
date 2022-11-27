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
      System.out.println(date);
      Instant instant = date.toInstant();
      System.out.println(instant);

      Calendar calendar = Calendar.getInstance();
      System.out.println(calendar);
      Instant instant1 = calendar.toInstant();
      System.out.println(instant1);

      TimeZone timeZone = TimeZone.getDefault();
      System.out.println(timeZone);
      ZoneId zoneId = timeZone.toZoneId();
      System.out.println(zoneId);
   }

   @Test
   void toLegacy() {
      ZonedDateTime zonedDateTime = ZonedDateTime.now();

      Date date = Date.from(zonedDateTime.toInstant());

      Calendar calendar = GregorianCalendar.from(zonedDateTime);

      ZoneId zoneId = ZoneId.systemDefault();
      TimeZone timeZone = TimeZone.getTimeZone(zoneId);

      System.out.println(date);
      System.out.println(calendar);
      System.out.println(timeZone);
   }

}

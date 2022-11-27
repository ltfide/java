package belajar.date.time;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.jupiter.api.Test;

public class TimeZoneTest {

   @Test
   void testTimeZone() {
      Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
      System.out.println(calendar.get(Calendar.HOUR_OF_DAY));

      TimeZone timeZone = TimeZone.getDefault();
      System.out.println(timeZone);

      String[] availableIDs = TimeZone.getAvailableIDs();
      Arrays.asList(availableIDs).forEach(zoneId -> System.out.println(zoneId));
   }

   @Test 
   void testDate() {
      Date date = new Date();

      System.out.println(date.toString());
      // System.out.println(date.toGMTString()); // Deprecated
   }

   @Test
   void calendar() {
      Calendar calendarJakarta = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
      Calendar calendarGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

      System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
      System.out.println(calendarGMT.get(Calendar.HOUR_OF_DAY));

      calendarJakarta.setTimeZone(TimeZone.getTimeZone("GMT"));
      System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
   }

}
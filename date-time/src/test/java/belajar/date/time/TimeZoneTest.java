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
      System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); // 6

      TimeZone timeZone = TimeZone.getDefault();
      // sun.util.calendar.ZoneInfo[id="Asia/Jakarta",offset=25200000,dstSavings=0,useDaylight=false,transitions=9,lastRule=null]
      System.out.println(timeZone);

      String[] availableIDs = TimeZone.getAvailableIDs();
      Arrays.asList(availableIDs).forEach(zoneId -> System.out.println(zoneId)); // list time zone
   }

   @Test
   void testDate() {
      Date date = new Date();

      System.out.println(date.toString()); // Fri Mar 03 06:47:21 WIB 2023
      // Deprecated
      System.out.println(date.toGMTString()); // 2 Mar 2023 23:47:21 GMT
   }

   @Test
   void calendar() {
      Calendar calendarJakarta = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
      Calendar calendarGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

      System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY)); // 6
      System.out.println(calendarGMT.get(Calendar.HOUR_OF_DAY)); // 23

      calendarJakarta.setTimeZone(TimeZone.getTimeZone("GMT"));
      System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY)); // 23
   }

}
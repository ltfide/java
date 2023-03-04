package belajar.date.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

public class InstantTest {

   @Test
   void create() {
      Instant instant1 = Instant.now();
      System.out.println(instant1); // 2023-03-04T00:01:10.433712Z

      Instant instant2 = Instant.ofEpochMilli(1665468854431L);
      System.out.println(instant2); // 2022-10-11T06:14:14.431Z
   }

   @Test
   void modify() {
      Instant instant1 = Instant.now();
      Instant instant2 = instant1.plusMillis(1000);
      Instant instant3 = instant1.minusMillis(1000);

      System.out.println(instant1); // 2023-03-04T00:01:56.492843300Z
      System.out.println(instant2); // 2023-03-04T00:01:57.492843300Z
      System.out.println(instant3); // 2023-03-04T00:01:55.492843300Z
   }

   @Test
   void get() {
      Instant instant = Instant.now();

      System.out.println(instant.toEpochMilli()); // 1677888138385
      System.out.println(instant.getEpochSecond()); // 1677888138
      System.out.println(instant.getNano()); // 385971900
   }

   @Test
   void fromInstant() {
      Instant instant = Instant.now();

      ZoneId zoneId = ZoneId.of("Asia/Jakarta");

      LocalTime localTime = LocalTime.ofInstant(instant, zoneId);
      System.out.println(localTime); // 07:02:39.106194600

      LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
      System.out.println(localDateTime); // 2023-03-04T07:02:39.106194600

      ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
      System.out.println(zonedDateTime); // 2023-03-04T07:02:39.106194600+07:00[Asia/Jakarta]

      OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, zoneId);
      System.out.println(offsetDateTime); // 2023-03-04T07:02:39.106194600+07:00
   }

   @Test
   void toInstant() {
      Instant instant1 = LocalDateTime.now().toInstant(ZoneOffset.ofHours(7));
      System.out.println(instant1); // 2023-03-04T00:03:23.399777500Z

      Instant instant2 = ZonedDateTime.now().toInstant();
      System.out.println(instant2); // 2023-03-04T00:03:23.422717Z

      Instant instant3 = OffsetDateTime.now().toInstant();
      System.out.println(instant3); // 2023-03-04T00:03:23.423714500Z
   }

}

package belajar.date.time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

public class OffsetTimeTest {

   @Test
   void create() {
      OffsetTime offsetTime1 = OffsetTime.now();
      OffsetTime offsetTime2 = OffsetTime.now(ZoneId.of("Asia/Jakarta"));
      OffsetTime offsetTime3 = OffsetTime.of(10, 10, 10, 10, ZoneOffset.ofHours(7));
      OffsetTime offsetTime4 = OffsetTime.parse("09:09:09.100+07:00");

      System.out.println(offsetTime1); // 06:53:53.098980400+07:00
      System.out.println(offsetTime2); // 06:53:53.099977500+07:00
      System.out.println(offsetTime3); // 10:10:10.000000010+07:00
      System.out.println(offsetTime4); // 09:09:09.100+07:00

      OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
      OffsetDateTime offsetDateTime2 = OffsetDateTime.now(ZoneId.of("Asia/Jakarta"));
      OffsetDateTime offsetDateTime3 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(7));
      OffsetDateTime offsetDateTime4 = OffsetDateTime.parse("1980-09-17T10:10:10.100+05:00");

      System.out.println(offsetDateTime1); // 2023-03-04T06:53:53.128899900+07:00
      System.out.println(offsetDateTime2); // 2023-03-04T06:53:53.128899900+07:00
      System.out.println(offsetDateTime3); // 2023-03-04T06:53:53.128899900+07:00
      System.out.println(offsetDateTime4); // 1980-09-17T10:10:10.100+05:00
   }

   @Test
   void toLocalTime() {
      LocalTime localTime = LocalTime.now();
      System.out.println(localTime); // 06:54:39.436492100

      OffsetTime offsetTime = localTime.atOffset(ZoneOffset.ofHours(7));
      System.out.println(offsetTime); // 06:54:39.436492100+07:00

      LocalTime localTime2 = offsetTime.toLocalTime();
      System.out.println(localTime2); // 06:54:39.436492100
   }

   @Test
   void toLocalDateTime() {
      LocalDateTime localDateTime = LocalDateTime.now();
      System.out.println(localDateTime); // 2023-03-04T06:55:04.915618400

      OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(7));
      System.out.println(offsetDateTime); // 2023-03-04T06:55:04.915618400+07:00

      LocalDateTime localDateTime2 = offsetDateTime.toLocalDateTime();
      System.out.println(localDateTime2); // 2023-03-04T06:55:04.915618400
   }

}

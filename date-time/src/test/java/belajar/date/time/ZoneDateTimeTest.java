package belajar.date.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

public class ZoneDateTimeTest {

   @Test
   void create() {
      ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
      ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Jakarta"));
      ZonedDateTime zonedDateTime3 = ZonedDateTime.now(ZoneId.of("GMT"));
      ZonedDateTime zonedDateTime4 = ZonedDateTime.now(ZoneOffset.ofHours(5));

      System.out.println(zonedDateTime1); // 2023-03-04T06:46:29.408771200+07:00[Asia/Jakarta]
      System.out.println(zonedDateTime2); // 2023-03-04T06:46:29.410771300+07:00[Asia/Jakarta]
      System.out.println(zonedDateTime3); // 2023-03-03T23:46:29.410771300Z[GMT]
      System.out.println(zonedDateTime4); // 2023-03-04T04:46:29.410771300+05:00
   }

   @Test
   void parsing() {
      ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("2022-10-11T12:47:47.561633200+07:00[Asia/Jakarta]");
      ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2022-10-11T10:47:47.562635+05:00");

      System.out.println(zonedDateTime1); // 2022-10-11T12:47:47.561633200+07:00[Asia/Jakarta]
      System.out.println(zonedDateTime2); // 2022-10-11T10:47:47.562635+05:00
   }

   @Test
   void changeZoneId() {
      ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
      System.out.println(zonedDateTime1); // 2023-03-04T06:47:13.264524900+07:00[Asia/Jakarta]

      ZonedDateTime zonedDateTime2 = zonedDateTime1.withZoneSameLocal(ZoneId.of("GMT"));
      ZonedDateTime zonedDateTime3 = zonedDateTime1.withZoneSameInstant(ZoneId.of("GMT"));

      System.out.println(zonedDateTime2); // 2023-03-04T06:47:13.264524900Z[GMT]
      System.out.println(zonedDateTime3); // 2023-03-03T23:47:13.264524900Z[GMT]
   }

}

package belajar.date.time;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class DurationTest {

   @Test
   void create() {
      Duration duration1 = Duration.ofHours(10);
      Duration duration2 = Duration.ofMinutes(10);
      Duration duration3 = Duration.ofMillis(10);

      System.out.println(duration1); // PT10H
      System.out.println(duration2); // PT10M
      System.out.println(duration3); // PT0.01S
   }

   @Test
   void get() {
      Duration duration = Duration.ofHours(50);

      System.out.println(duration.toDays()); // 2
      System.out.println(duration.toHours()); // 50
      System.out.println(duration.toMinutes()); // 3000
      System.out.println(duration.toSeconds()); // 180000
      System.out.println(duration.toMillis()); // 180000000
      System.out.println(duration.toNanos()); // 180000000000000
   }

   @Test
   void between() {
      Duration duration1 = Duration.between(LocalDateTime.now().minusDays(3).minusHours(3),
            LocalDateTime.now().plusHours(10));
      System.out.println(duration1.toHours()); // 85
      System.out.println(duration1.toMinutes()); // 5100
      System.out.println(duration1.toDays()); // 3

      Duration duration2 = Duration.between(LocalDateTime.now().plusHours(10), LocalDateTime.now());
      System.out.println(duration2.toHours()); // -10
      System.out.println(duration2.toMinutes()); // -600
   }

}

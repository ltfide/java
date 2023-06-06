package dev.local;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadLocalRandomTest {

    @Test
    void test() throws InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                int number = ThreadLocalRandom.current().nextInt();
                System.out.println(number);
            });
        }

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void stream() throws InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        IntStream intStream = ThreadLocalRandom.current().ints(1000, 0, 1000);
        intStream.forEach(System.out::println);

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

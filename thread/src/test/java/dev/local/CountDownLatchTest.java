package dev.local;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    @Test
    void test() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("Start Task");
                    Thread.sleep(2000L);
                    System.out.println("Finish Task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countDownLatch.await();
                System.out.println("Finish all task");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

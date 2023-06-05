package dev.local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Semaphore;

import org.junit.jupiter.api.Test;

public class SemaphoreTest {

    @Test
    void semaphore() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000L);
                    System.out.println("Finish");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

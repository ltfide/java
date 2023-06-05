package dev.local;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class CyclicBearerTest {

    @Test
    void test() throws InterruptedException {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("Waiting");
                    cyclicBarrier.await();
                    System.out.println("Done Waiting");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

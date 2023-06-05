package dev.local;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest {

    @Test
    void countDownLatch() throws InterruptedException {
        final Phaser phaser = new Phaser();
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("Start task");
                    Thread.sleep(3000L);
                    System.out.println("Finish task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    phaser.arrive();
                }
            });
        }

        executor.execute(() -> {
            phaser.awaitAdvance(0);
            System.out.println("All task done");
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void cyclicBarrier() throws InterruptedException {
        final Phaser phaser = new Phaser();
        final ExecutorService executor = Executors.newFixedThreadPool(15);

        phaser.bulkRegister(5);
        phaser.bulkRegister(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                phaser.arriveAndAwaitAdvance();
                System.out.println("DONE");
            });
        }

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

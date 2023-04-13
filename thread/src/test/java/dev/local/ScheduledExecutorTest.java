package dev.local;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class ScheduledExecutorTest {

    @Test
    void test() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            // kode tugas yang akan dijalankan secara periodik
            System.out.println("Hello, world!");
        }, 0, 5, TimeUnit.SECONDS);

        Thread.sleep(10000);
    }

    @Test
    void delayedJob() throws InterruptedException {
        var executor = Executors.newScheduledThreadPool(10);
        var future = executor.schedule(() -> System.out.println("Hello Scheduled"), 5, TimeUnit.SECONDS);

        System.out.println(future.getDelay(TimeUnit.MILLISECONDS)); // 4999
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void periodicJob() throws InterruptedException {
        var executor = Executors.newScheduledThreadPool(10);
        var future = executor.scheduleAtFixedRate(() -> System.out.println("Hello Scheduled"), 2, 2, TimeUnit.SECONDS);

        System.out.println(future.getDelay(TimeUnit.MILLISECONDS));
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

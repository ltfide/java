package dev.local;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTest {

    @Test
    void test() throws InterruptedException {
        final Exchanger<String> exchanger = new Exchanger<>();
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            try {
                System.out.println("Thread 1: send: First");
                Thread.sleep(1000L);
                String result = exchanger.exchange("First");
                System.out.println("Thread 1: receive: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                System.out.println("Thread 2: send: Second");
                Thread.sleep(2000L);
                String result = exchanger.exchange("Second");
                System.out.println("Thread 2: receive: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

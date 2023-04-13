package dev.local;

import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class CompletionServiceTest {

    private Random random = new Random();

    @Test
    void test() throws InterruptedException {
        // Membuat CompletionService
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);

        // submit task
        // Mengirim Task ke CompletionService
        Executors.newSingleThreadExecutor().execute(() -> {
            for (int i = 0; i < 100; i++) {
                final int index = i;
                completionService.submit(() -> {
                    Thread.sleep(random.nextInt(2000));
                    return "Task-" + index;
                });
            }
        });

        // pool task
        // Mengambil Task di CompletionService
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    Future<String> future = completionService.poll(5, TimeUnit.SECONDS);
                    if (future == null) {
                        break;
                    } else {
                        System.out.println(future.get());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

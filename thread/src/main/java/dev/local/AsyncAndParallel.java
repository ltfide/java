package dev.local;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncAndParallel {

    public static void async() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1_000L);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            return 1;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2_000L);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            return 2;
        });

        future1.thenAccept(result -> {
            System.out.println("Hasil dari future1" + result);
        });

        future2.thenAccept(result -> {
            System.out.println("Hasil dari future2" + result);
        });

        System.out.println("Running");

        int result1 = future1.get();
        int result2 = future2.get();

        System.out.println("Hasil akhir: " + (result1 + result2));
    }

    public static void parallel() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executorService.submit(() -> {
            Thread.sleep(2_000L);
            return 1;
        });

        Future<Integer> future2 = executorService.submit(() -> {
            Thread.sleep(4_000L);
            return 2;
        });

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        executorService.shutdown();

        System.out.println("Hasil akhir: " + (result1 + result2));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // async();
        parallel();
    }
}

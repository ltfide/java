package dev.local;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

public class CompletableFutureTest {

    private ExecutorService executor = Executors.newFixedThreadPool(10);

    private Random random = new Random();

    public CompletableFuture<String> getValue() {
        CompletableFuture<String> future = new CompletableFuture<>();

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                future.complete("Completed");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }

    @Test
    void create() throws InterruptedException, ExecutionException {
        Future<String> future = getValue();
        System.out.println(future.get()); // COMPLETED
    }

    private void execute(CompletableFuture<String> future, String value) {
        executor.execute(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(5000));
                future.complete(value);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
    }

    public Future<String> getFastest() {
        CompletableFuture<String> future = new CompletableFuture<>();

        execute(future, "Thread 1");
        execute(future, "Thread 2");
        execute(future, "Thread 3");

        return future;
    }

    @Test
    void testFastest() throws ExecutionException, InterruptedException {
        System.out.println(getFastest().get()); // thread secara acak
    }

    @Test
    void completionStage() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = getValue();

        CompletableFuture<String[]> future2 = future
                .thenApply(string -> string.toUpperCase())
                .thenApply(string -> string.split(" "));

        String[] strings = future2.get();
        for (var value : strings) {
            System.out.println(value); // COMPLETED
        }
    }
}

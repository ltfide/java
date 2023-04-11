package dev.local;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class FutureTest {

    @Test
    void testFuture() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            Thread.sleep(5000);
            return "Hello";
        };
        Future<String> future = executor.submit(callable);
        System.out.println("Finish result");

        while (!future.isDone()) {
            System.out.println("Waiting result");
            Thread.sleep(1000);
        }

        System.out.println(future.get());
        // output
        // Finish result
        // Waiting result
        // Waiting result
        // Waiting result
        // Waiting result
        // Waiting result
        // Hello
    }

    @Test
    void testFutureCancel() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            Thread.sleep(5000);
            return "Hello";
        };
        Future<String> future = executor.submit(callable);
        System.out.println("Finish result");

        Thread.sleep(2000);
        future.cancel(true);

        System.out.println(future.isCancelled());
        String value = future.get();
        System.out.println(value);

        // output
        // Finish result
        // true
        // java.util.concurrent.CancellationException
    }

    @Test
    void testInvokeAll() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>) () -> {
            Thread.sleep(value * 500);
            return String.valueOf(value);
        }).collect(Collectors.toList());

        List<Future<String>> futures = executor.invokeAll(callables);

        for (Future<String> future : futures) {
            System.out.println(future.get()); // 1 -> 10
        }
    }

    @Test
    void testInvokeAny() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>) () -> {
            Thread.sleep(value * 500);
            return String.valueOf(value);
        }).collect(Collectors.toList());

        String result = executor.invokeAny(callables);
        System.out.println(result); // 1
    }
}

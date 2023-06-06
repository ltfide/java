package dev.local;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamTest {

    @Test
    void parallel() {
        Stream<Integer> stream = IntStream.range(0, 100).boxed();
        stream.parallel().forEach(integer ->
                System.out.println(Thread.currentThread().getName() + ": " + integer));
    }

    @Test
    void customPool() {
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<?> task = pool.submit(() -> {
            Stream<Integer> stream = IntStream.range(0, 100).boxed();
            stream.parallel().forEach(integer ->
                    System.out.println(Thread.currentThread().getName() + ": " + integer));
        });

        task.join();
    }
}

package com.example;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadTest {

    private Runnable runnable() {
        return () -> {
            System.out.println("Hello World!");
        };
    }

    @Test
    void createVT() throws InterruptedException {
        Thread thread = Thread.ofVirtual().start(runnable());
        thread.join();
    }

    @Test
    void builderVT() throws InterruptedException {
        Thread.Builder vt1 = Thread.ofVirtual().name("Vt-1");
        Thread t = vt1.start(runnable());
        System.out.println("Thread name: " + t.getName());
        t.join();
    }

    @Test
    void executorsMethod() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        Future<?> future = executor.submit(runnable());
        future.get();
        System.out.println("Task completed");
        executor.close();
    }
}

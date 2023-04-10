package dev.local;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class ThreadpoolTest {

    @Test
    void create() {
        int minThread = 10;
        int maxThread = 50;
        int alive = 1;
        TimeUnit aliveTime = TimeUnit.MINUTES;
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);

        ThreadPoolExecutor threadpool = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);
    }

    @Test
    void executeRunnable() throws InterruptedException {
        int minThread = 10;
        int maxThread = 50;
        int alive = 1;
        TimeUnit aliveTime = TimeUnit.MINUTES;
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);

        ThreadPoolExecutor threadpool = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);

        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("Runnable from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        threadpool.execute(runnable); // Runnable from thread : pool-1-thread-1
        Thread.sleep(6000);
    }

    @Test
    void shutdown() throws InterruptedException {
        int minThread = 10;
        int maxThread = 50;
        int alive = 1;
        TimeUnit aliveTime = TimeUnit.MINUTES;
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(1000);

        ThreadPoolExecutor threadpool = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue);

        for (int i = 0; i < 1000; i++) {
            final var task = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task " + task + " from thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            threadpool.execute(runnable);
        }

        // threadpool.shutdown();
        threadpool.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void rejected() throws InterruptedException {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;
        var queue = new ArrayBlockingQueue<Runnable>(10);
        var rejectedHandler = new LogRejectedExecutionHandler();

        var executor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue, rejectedHandler);

        for (int i = 0; i < 1000; i++) {
            final var task = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task " + task + " from thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executor.execute(runnable);
        }

        // executor.shutdownNow();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    public static class LogRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task " + r + " is rejected");
        }
    }
}

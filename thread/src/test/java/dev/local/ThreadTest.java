package dev.local;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void mainThread() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName); // main
    }

    @Test
    void createThread() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        thread.start(); // thread-0
    }

    @Test
    void threadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start(); // thread-0
        Thread.sleep(3_000L);
    }

    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000L);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start(); // thread-0
        thread.join();
    }

    @Test
    void wrongThreadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000L);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();
        System.out.println("Program selesai");
    }

    @Test
    void correctThreadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                // interrupt thread manual
                // if (Thread.interrupted()) {
                // return;
                // }

                System.out.println(i);

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000L);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();
        System.out.println("Program selesai");

        // output
        // 0
        // 1
        // 2
        // 3
        // 4
        // Menunggu selesai
        // Program selesai
    }

    @Test
    void threadName() {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        thread.setName("Lutfi");
        thread.start(); // Lutfi
    }

    @Test
    void threadState() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getState());
        };

        Thread thread = new Thread(runnable);
        System.out.println(thread.getState()); // NEW

        thread.start(); // RUNNABLE
        thread.join();

        System.out.println(thread.getState()); // TERMINATED
    }

}
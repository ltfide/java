package dev.local;

import org.junit.jupiter.api.Test;

public class DeadlockTest {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    @Test
    void test() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: acquired lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                synchronized (lock2) {
                    System.out.println("Thread 1: acquired lock 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: acquired lock 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                synchronized (lock1) {
                    System.out.println("Thread 2: acquired lock 1");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Test
    void transfer() throws InterruptedException {
        Balance balance1 = new Balance(10_000L);
        Balance balance2 = new Balance(10_000L);

        Thread thread1 = new Thread(() -> {
            try {
                Balance.transfer(balance1, balance2, 2_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Balance.transfer(balance2, balance1, 2_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(balance1.getValue()); // 10000
        System.out.println(balance2.getValue()); // 10000
    }
}

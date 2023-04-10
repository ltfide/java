package dev.local;

import org.junit.jupiter.api.Test;

public class SynchronizationTest {

    @Test
    void testSynchronization() throws InterruptedException {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        // karena dijalankan diunit test
        // maka harus menggunakan thread join
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter.getValue()); // 3000
    }
}

package dev.local;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void testThread() throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("Lutfi");
        thread1.start();
        System.out.println("Test");

        Thread.sleep(2000L);
    }

}

package dev.local;

public class NewThread {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        };

        Runnable runnable2 = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        thread.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread2.join();
        thread3.join();
        System.out.println("Main thread is done");
    }
}

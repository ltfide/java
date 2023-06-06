package dev.local;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueTest {

    @Test
    void arrayBlockingQueue() throws InterruptedException {
        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
        final ExecutorService executor = Executors.newFixedThreadPool(15);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    queue.put("Data-" + index);
                    System.out.println("Finish push data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    String result = queue.take();
                    System.out.println("Result: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void linkedBlockingQueue() throws InterruptedException {
        final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        final ExecutorService executor = Executors.newFixedThreadPool(15);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    queue.put("Data-" + index);
                    System.out.println("Finish push data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    String result = queue.take();
                    System.out.println("Result: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void priorityBlockingQueue() throws InterruptedException {
        final PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10, Comparator.reverseOrder());
        final ExecutorService executor = Executors.newFixedThreadPool(15);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> {
                queue.put(index);
                System.out.println("Finish push data: " + index);
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    Integer result = queue.take();
                    System.out.println("Result: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void delayedQueue() throws InterruptedException {
        final DelayQueue<ScheduledFuture<String>> queue = new DelayQueue<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);
        final ScheduledExecutorService executorScheduled = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            queue.put(executorScheduled.schedule(() -> "Data " + index, i, TimeUnit.SECONDS));
        }

        executor.execute(() -> {
            while (true) {
                try {
                    ScheduledFuture<String> future = queue.take();
                    System.out.println("Result: " + future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void synchronousQueue() throws InterruptedException {
        final SynchronousQueue<String> queue = new SynchronousQueue<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    queue.put("Data-" + index);
                    System.out.println("Finish push data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    String result = queue.take();
                    System.out.println("Result: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void blockingDeque() throws InterruptedException {
        final BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    queue.putLast("Data-" + index);
                    System.out.println("Finish push data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    String result = queue.takeFirst();
                    System.out.println("Result: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void transferQueue() throws InterruptedException {
        final TransferQueue<String> queue = new LinkedTransferQueue<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    queue.transfer("Data-" + index);
                    System.out.println("Finish push data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    String result = queue.take();
                    System.out.println("Result: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}

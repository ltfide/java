package dev.local;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentMapTest {

    @Test
    void concurrentMap() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        final ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
        final ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    map.putIfAbsent(index, "Data- " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countDownLatch.await();
                map.forEach(((integer, s) -> System.out.println(integer + ": " + s)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void testCollection() {
        List<String> name = List.of("Lutfi", "Dendiansyah");
        List<String> synchronizedList = Collections.synchronizedList(name);
    }
}

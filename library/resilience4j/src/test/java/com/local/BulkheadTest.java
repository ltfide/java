package com.local;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BulkheadTest {

    private AtomicLong counter = new AtomicLong(0L);

    @SneakyThrows
    void slow() {
        long value = counter.incrementAndGet();
        log.info("Value : {}", value);
        Thread.sleep(1_000L);
    }

    @Test
    void testSemaphore() throws InterruptedException {
        Bulkhead bulkhead = Bulkhead.ofDefaults("local");

        for (int i = 0; i < 1000; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> slow());
            new Thread(runnable).start();
        }

        Thread.sleep(10_000L);
        // output
        // 20:31:56.112 [Thread-16] INFO com.local.BulkheadTest -- Value : 1 - 25
        // io.github.resilience4j.bulkhead.BulkheadFullException: Bulkhead 'local' is
        // full and does not permit further calls
    }

    @Test
    void testThreadPool() {
        ThreadPoolBulkhead bulkhead = ThreadPoolBulkhead.ofDefaults("local");

        for (int i = 0; i < 1000; i++) {
            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> slow());
            supplier.get();
        }

        // output
        // io.github.resilience4j.bulkhead.BulkheadFullException: Bulkhead 'local' is
        // full and does not permit further calls
        // 20:39:36.329 [bulkhead-local-7] INFO com.local.BulkheadTest -- Value : 7
        // 20:39:36.328 [bulkhead-local-4] INFO com.local.BulkheadTest -- Value : 5
        // 20:39:36.328 [bulkhead-local-6] INFO com.local.BulkheadTest -- Value : 6
        // 20:39:36.329 [bulkhead-local-8] INFO com.local.BulkheadTest -- Value : 8
        // 20:39:36.328 [bulkhead-local-5] INFO com.local.BulkheadTest -- Value : 4
        // 20:39:36.328 [bulkhead-local-2] INFO com.local.BulkheadTest -- Value : 1
        // 20:39:36.328 [bulkhead-local-3] INFO com.local.BulkheadTest -- Value : 2
        // 20:39:36.328 [bulkhead-local-1] INFO com.local.BulkheadTest -- Value : 3
    }
}

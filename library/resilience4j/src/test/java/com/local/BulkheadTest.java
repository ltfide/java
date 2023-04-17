package com.local;

import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadConfig;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadRegistry;
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

    @Test
    void testSemaphoreConfig() throws InterruptedException {
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(5)
                .maxWaitDuration(Duration.ofSeconds(5))
                .build();

        Bulkhead bulkhead = Bulkhead.of("local", config);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> slow());
            new Thread(runnable).start();
        }

        Thread.sleep(10_000L);

        // // output
        // 20:56:52.506 [Thread-0] INFO com.local.BulkheadTest -- Value : 5
        // 20:56:52.506 [Thread-3] INFO com.local.BulkheadTest -- Value : 3
        // 20:56:52.506 [Thread-1] INFO com.local.BulkheadTest -- Value : 4
        // 20:56:52.506 [Thread-2] INFO com.local.BulkheadTest -- Value : 2
        // 20:56:52.506 [Thread-5] INFO com.local.BulkheadTest -- Value : 1
        // 20:56:53.524 [Thread-7] INFO com.local.BulkheadTest -- Value : 6
        // 20:56:53.526 [Thread-9] INFO com.local.BulkheadTest -- Value : 8
        // 20:56:53.526 [Thread-8] INFO com.local.BulkheadTest -- Value : 7
        // 20:56:53.527 [Thread-4] INFO com.local.BulkheadTest -- Value : 9
        // 20:56:53.528 [Thread-6] INFO com.local.BulkheadTest -- Value : 10
    }

    @Test
    void testThreadPoolConfig() throws InterruptedException {
        ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(5)
                .coreThreadPoolSize(5)
                .queueCapacity(1)
                .build();

        log.info(String.valueOf(Runtime.getRuntime().availableProcessors())); // 8

        ThreadPoolBulkhead bulkhead = ThreadPoolBulkhead.of("local", config);

        for (int i = 0; i < 20; i++) {
            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> slow());
            supplier.get();
        }

        Thread.sleep(10_000L);

        // output
        // 20:47:45.728 [bulkhead-local-2] INFO com.local.BulkheadTest -- Value : 1
        // 20:47:45.728 [bulkhead-local-3] INFO com.local.BulkheadTest -- Value : 3
        // 20:47:45.728 [bulkhead-local-4] INFO com.local.BulkheadTest -- Value : 4
        // 20:47:45.728 [bulkhead-local-1] INFO com.local.BulkheadTest -- Value : 2
        // 20:47:45.728 [bulkhead-local-5] INFO com.local.BulkheadTest -- Value : 5
        // io.github.resilience4j.bulkhead.BulkheadFullException: Bulkhead 'local' is
        // full and does not permit further calls
    }

    @Test
    void testSemaphoreRegistry() throws InterruptedException {
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(5)
                .maxWaitDuration(Duration.ofSeconds(5))
                .build();

        BulkheadRegistry registry = BulkheadRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        Bulkhead bulkhead = registry.bulkhead("local", "config");

        for (int i = 0; i < 10; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> slow());
            new Thread(runnable).start();
        }

        Thread.sleep(10_000L);

        // output
        // 21:06:36.101 [Thread-2] INFO com.local.BulkheadTest -- Value : 2
        // 21:06:36.101 [Thread-1] INFO com.local.BulkheadTest -- Value : 1
        // 21:06:36.101 [Thread-4] INFO com.local.BulkheadTest -- Value : 4
        // 21:06:36.101 [Thread-0] INFO com.local.BulkheadTest -- Value : 5
        // 21:06:36.101 [Thread-3] INFO com.local.BulkheadTest -- Value : 3
        // 21:06:37.113 [Thread-5] INFO com.local.BulkheadTest -- Value : 6
        // 21:06:37.115 [Thread-8] INFO com.local.BulkheadTest -- Value : 7
        // 21:06:37.115 [Thread-6] INFO com.local.BulkheadTest -- Value : 9
        // 21:06:37.115 [Thread-9] INFO com.local.BulkheadTest -- Value : 10
        // 21:06:37.115 [Thread-7] INFO com.local.BulkheadTest -- Value : 8
    }

    @Test
    void testThreadPoolRegistry() throws InterruptedException {
        ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(5)
                .coreThreadPoolSize(5)
                .queueCapacity(1)
                .build();

        log.info(String.valueOf(Runtime.getRuntime().availableProcessors()));

        ThreadPoolBulkheadRegistry registry = ThreadPoolBulkheadRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        ThreadPoolBulkhead bulkhead = registry.bulkhead("local", "config");

        for (int i = 0; i < 20; i++) {
            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> slow());
            supplier.get();
        }

        Thread.sleep(10_000L);

        // output
        // 21:07:03.427 [bulkhead-local-1] INFO com.local.BulkheadTest -- Value : 1
        // 21:07:03.439 [bulkhead-local-4] INFO com.local.BulkheadTest -- Value : 2
        // 21:07:03.444 [bulkhead-local-3] INFO com.local.BulkheadTest -- Value : 3
        // 21:07:03.444 [bulkhead-local-2] INFO com.local.BulkheadTest -- Value : 4
        // 21:07:03.445 [bulkhead-local-5] INFO com.local.BulkheadTest -- Value : 5
        // io.github.resilience4j.bulkhead.BulkheadFullException: Bulkhead 'local' is
        // full and does not permit further calls
    }
}

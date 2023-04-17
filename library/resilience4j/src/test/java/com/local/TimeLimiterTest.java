package com.local;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLimiterTest {

    @SneakyThrows
    public Long slow() {
        log.info("start slow");
        Thread.sleep(10_000L);
        log.info("end slow");
        return 10_000L;
    }

    @Test
    void testTimeLimiter() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> future = executorService.submit(() -> slow());

        TimeLimiter timeLimiter = TimeLimiter.ofDefaults("local");

        Callable<Long> callable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);
        callable.call();

        // output
        // 21:39:01.109 [pool-1-thread-1] INFO com.local.TimeLimiterTest -- start slow
        // java.util.concurrent.TimeoutException: TimeLimiter 'local' recorded a timeout
        // exception.
    }

    @Test
    void timeLimiterConfig() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> future = executorService.submit(() -> slow());

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(10))
                .cancelRunningFuture(true)
                .build();

        TimeLimiter timeLimiter = TimeLimiter.of("local", config);
        Callable<Long> callable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);

        callable.call();

        // output
        // 21:46:40.324 [pool-1-thread-1] INFO com.local.TimeLimiterTest -- start slow
        // 21:46:50.339 [pool-1-thread-1] INFO com.local.TimeLimiterTest -- end slow
    }

    @Test
    void timeLimiterRegistry() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> future = executorService.submit(() -> slow());

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(10))
                .cancelRunningFuture(true)
                .build();

        TimeLimiterRegistry registry = TimeLimiterRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        TimeLimiter timeLimiter = registry.timeLimiter("local", "config");
        Callable<Long> callable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);

        callable.call();

        // 21:50:13.143 [pool-1-thread-1] INFO com.local.TimeLimiterTest -- start slow
        // 21:50:23.160 [pool-1-thread-1] INFO com.local.TimeLimiterTest -- end slow
    }
}

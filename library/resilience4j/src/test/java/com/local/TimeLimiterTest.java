package com.local;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.timelimiter.TimeLimiter;
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
}

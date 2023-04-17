package com.local;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateLimiterConfigTest {

    private final AtomicLong counter = new AtomicLong(0L);

    @Test
    void testRateLimiterConfig() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .timeoutDuration(Duration.ofSeconds(2))
                .build();

        RateLimiter limiter = RateLimiter.of("local", config);

        for (int i = 0; i < 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(limiter, () -> {
                long result = counter.incrementAndGet();
                log.info("Result {}", result);
            });
            runnable.run();
        }
        // output
        // 10:44:14.290 [main] INFO com.local.RateLimiterConfigTest -- Result 1 - 100
        // io.github.resilience4j.ratelimiter.RequestNotPermitted: RateLimiter 'local'
        // does not permit further calls
    }
}

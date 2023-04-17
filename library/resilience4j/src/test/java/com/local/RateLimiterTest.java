package com.local;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateLimiterTest {

    private final AtomicLong counter = new AtomicLong(0L);

    @Test
    void test() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .limitForPeriod(5)
                .timeoutDuration(Duration.ofMillis(500))
                .build();

        RateLimiter rateLimiter = RateLimiter.of("rateLimiterName", config);
        rateLimiter.acquirePermission();
    }

    @Test
    void testRateLimiter() {
        RateLimiter limiter = RateLimiter.ofDefaults("local");

        for (int i = 0; i < 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(limiter, () -> {
                long result = counter.incrementAndGet();
                log.info("Result {}", result);
            });
            runnable.run();
        }
        // 10:26:23.556 [main] INFO com.local.RateLimiterTest -- Result 1 - 10000
    }
}

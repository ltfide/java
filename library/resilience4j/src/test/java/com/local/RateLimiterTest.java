package com.local;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
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

    @Test
    void rateLimiter1() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .timeoutDuration(Duration.ofMillis(2000))
                .build();

        RateLimiterRegistry registry = RateLimiterRegistry.of(config);
        RateLimiter rateLimiter = registry.rateLimiter("rateLimiter1");

        Supplier<String> supplier = RateLimiter.decorateSupplier(rateLimiter, () -> {
            System.out.println("calling external service, request: " + counter.incrementAndGet() + " time: " + LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
            return "success";
        });

        for (int i = 0; i < 10; i++) {
            try {
                String result = supplier.get();
                //System.out.println("result: " + result);
            } catch (RequestNotPermitted e) {
                System.out.println("rejected by rate limiter, request: " + counter.incrementAndGet() + " time: " + LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
            }

//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
        }
    }
}

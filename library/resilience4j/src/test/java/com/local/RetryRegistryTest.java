package com.local;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryRegistryTest {

    void callMe() {
        log.info("call me");
        throw new IllegalArgumentException("ERROR");
    }

    @Test
    void retryRegistry() {
        RetryRegistry registry = RetryRegistry.ofDefaults();

        Retry retry1 = registry.retry("local");
        Retry retry2 = registry.retry("local");

        assertSame(retry1, retry2);
    }

    @Test
    void retryRegistryWithConfig() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(2))
                .build();

        RetryRegistry registry = RetryRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        Retry retry = registry.retry("local", "config");

        Runnable runnable = Retry.decorateRunnable(retry, () -> callMe());
        runnable.run();

        // output
        // 10:11:21.058 [main] INFO com.local.RetryRegistryTest -- call me
        // 10:11:23.088 [main] INFO com.local.RetryRegistryTest -- call me
        // 10:11:25.089 [main] INFO com.local.RetryRegistryTest -- call me
        // 10:11:27.091 [main] INFO com.local.RetryRegistryTest -- call me
        // 10:11:29.093 [main] INFO com.local.RetryRegistryTest -- call me
        // java.lang.IllegalArgumentException: ERROR
    }
}

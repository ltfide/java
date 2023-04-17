package com.local;

import java.time.Duration;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryConfigTest {

    private String callMe() {
        log.info("call me");
        throw new IllegalArgumentException("ERROR");
    }

    @Test
    void createRetryConfig() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(2))
                .retryExceptions(IllegalArgumentException.class)
                .build();

        Retry retry = Retry.of("local", config);

        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> callMe());
        supplier.get();
    }
}

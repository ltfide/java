package com.local;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventPublisherTest {

    private String hello() {
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void retry() {
        Retry retry = Retry.ofDefaults("pzn");
        retry.getEventPublisher().onRetry(event -> {
            log.info("try to retry");
        });
        // 05:23:27.196 [main] INFO com.local.EventPublishedTest -- try to retry
        // 05:23:27.720 [main] INFO com.local.EventPublishedTest -- try to retry

        try {
            Supplier<String> supplier = Retry.decorateSupplier(retry, () -> hello());
            supplier.get();
        } catch (Exception e) {
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithRetryAttempt()); // 1
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithoutRetryAttempt()); // 0
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithRetryAttempt()); // 0
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithoutRetryAttempt()); // 0
        }
    }

    @Test
    void registry() {
        RetryRegistry registry = RetryRegistry.ofDefaults();
        registry.getEventPublisher().onEntryAdded(event -> {
            log.info("Add new entry {}", event.getAddedEntry().getName());
        });

        registry.retry("local");
        registry.retry("local");
        registry.retry("local2");

        // 05:30:31.993 [main] INFO com.local.EventPublisherTest -- Add new entry local
        // 05:30:32.010 [main] INFO com.local.EventPublisherTest -- Add new entry local2
    }
}

package com.local;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.retry.Retry;

public class MetricTest {

    @Test
    void retry() {
        Retry retry = Retry.ofDefaults("local");

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

    private String hello() {
        throw new IllegalArgumentException("Ups");
    }
}

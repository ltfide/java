package com.local;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.event.CircuitBreakerOnCallNotPermittedEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

@Slf4j
public class CircuitBreakerTest {

    public void callMe() {
        log.info("Call Me");
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void circuitBreaker() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("local");

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Exception e) {
                log.error("Error : {}", e.getMessage());
            }
        }
    }

    @Test
    void circuitBreakerConfig() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .failureRateThreshold(10f)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("local", config);

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Exception e) {
                log.error("Error : {}", e.getMessage());
            }
        }
    }

    @Test
    void circuitBreakerRegistry() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .failureRateThreshold(10f)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        CircuitBreaker circuitBreaker = registry.circuitBreaker("local", "config");

        for (int i = 0; i < 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callMe());
                runnable.run();
            } catch (Exception e) {
                log.error("Error : {}", e.getMessage());
            }
        }
    }

    private String callApi() {
        System.out.println("attempting to call api" + LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
        if (Math.random() < 0.8) {
            throw new RuntimeException("api is down!");
        }
        return "success";
    }

    @Test
    void circuitBreaker1() {
        CircuitBreakerConfig cbConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .slowCallRateThreshold(100)
                .slowCallDurationThreshold(Duration.ofSeconds(1))
                .waitDurationInOpenState(Duration.ofSeconds(5))
                .permittedNumberOfCallsInHalfOpenState(2)
                .minimumNumberOfCalls(5)
                .recordExceptions(RuntimeException.class)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(cbConfig);
        CircuitBreaker circuitBreaker = registry.circuitBreaker("callApi");

        Supplier<String> tSupplier = CircuitBreaker.decorateSupplier(circuitBreaker, this::callApi);

        for (int i = 0; i < 100; i++) {
            try {
                String result = tSupplier.get();
                System.out.println("Result: " + result + " (State: " + circuitBreaker.getState() + ")");
            } catch (Exception e) {
                System.err.println("Call failed: " + e.getMessage() + " (State: " + circuitBreaker.getState() + ")");
            }

            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private String externalServiceFallback(Throwable t) {
        System.err.println("Fallback dijalankan: " + t.getMessage());
        return "Respons fallback: Layanan sedang bermasalah.";
    }

    @Test
    @DisplayName("handle fallback")
    void circuitBreaker2() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .minimumNumberOfCalls(5)
                .slowCallRateThreshold(100)
                .slowCallDurationThreshold(Duration.ofSeconds(1L))
                .waitDurationInOpenState(Duration.ofSeconds(5))
                .permittedNumberOfCallsInHalfOpenState(2)
                .recordExceptions(RuntimeException.class)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
        CircuitBreaker circuitBreaker = registry.circuitBreaker("handleFallback");

        Supplier<String> tSupplier = CircuitBreaker.decorateSupplier(circuitBreaker, this::callApi);

        for (int i = 0; i < 100; i++) {
            try {
                String result = tSupplier.get();
                System.out.println("Result: " + result + " (State: " + circuitBreaker.getState() + ")");
            } catch (CallNotPermittedException e) {
                String fallbackResult = externalServiceFallback(e);
                System.out.println("Hasil (Fallback - Circuit Open): " + fallbackResult + " (State: " + circuitBreaker.getState() + ")");
            } catch (RuntimeException e) {
                String fallbackResult = externalServiceFallback(e);
                System.out.println("Hasil (Fallback - Call Failed): " + fallbackResult + " (State: " + circuitBreaker.getState() + ")");
            }

            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

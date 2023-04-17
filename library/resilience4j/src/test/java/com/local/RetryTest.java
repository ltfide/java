package com.local;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import io.github.resilience4j.retry.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryTest {

    private Integer counter = 0;

    void callMe() {
        log.info("call me");
        throw new IllegalArgumentException("ERROR");
    }

    @Test
    void testCreateNewRetry() {
        Retry retry = Retry.ofDefaults("local");

        Runnable runnable = Retry.decorateRunnable(retry, () -> callMe());
        runnable.run();
    }

    private String sayHello() {
        log.info("call say hello");
        counter++;

        if (counter == 3) {
            return "HELLO";
        }
        throw new IllegalArgumentException("ERROR");
    }

    @Test
    void testExecuteSupplier() {
        Retry retry = Retry.ofDefaults("local");

        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> sayHello());
        String result = supplier.get();
        System.out.println(result);

        // output
        // 09:43:43.008 [main] INFO com.local.RetryTest -- call say hello
        // 09:43:43.527 [main] INFO com.local.RetryTest -- call say hello
        // 09:43:44.028 [main] INFO com.local.RetryTest -- call say hello
        // HELLO
    }
}

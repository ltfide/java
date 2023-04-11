package com.local;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {

    private static final Logger Log = LoggerFactory.getLogger(MainTest.class);

    @Test
    void testLog() {
        Log.info("Hello Logging");
        Log.info("Learn Java Logging");

        // output
        // 15:29:59.462 [main] INFO com.local.MainTest -- Hello Logging
        // 15:29:59.481 [main] INFO com.local.MainTest -- Learn Java Logging
    }

    @Test
    void testLevel() {
        Log.trace("TRACE");
        Log.debug("DEBUG");
        Log.info("INFO");
        Log.warn("WARN");
        Log.error("ERROR");

        // output
        // 15:56:41.722 [main] DEBUG com.local.MainTest -- DEBUG
        // 15:56:41.731 [main] INFO com.local.MainTest -- INFO
        // 15:56:41.732 [main] WARN com.local.MainTest -- WARN
        // 15:56:41.732 [main] ERROR com.local.MainTest -- ERROR
    }
}

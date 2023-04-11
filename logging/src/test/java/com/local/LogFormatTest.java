package com.local;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFormatTest {

    private static final Logger Log = LoggerFactory.getLogger(LogFormatTest.class);

    @Test
    void testFormat() {
        Log.info("Your name is : {}", "Lutfi");
        Log.info("{} + {} = {}", 10, 10, (10 + 10));
        Log.error("Error: {}", new NullPointerException());

        // output
        // 04:59:16.363 [main] INFO com.local.LogFormatTest -- Your name is : Lutfi
        // 04:59:16.370 [main] INFO com.local.LogFormatTest -- 10 + 10 = 20
        // 04:59:16.371 [main] ERROR com.local.LogFormatTest -- Error: {}
        // java.lang.NullPointerException: null
    }
}

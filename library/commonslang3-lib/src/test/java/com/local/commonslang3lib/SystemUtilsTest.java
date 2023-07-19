package com.local.commonslang3lib;

import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.Test;

public class SystemUtilsTest {

    @Test
    void tests() {
        // C:\Program Files\Java\jdk-17
        System.out.println(SystemUtils.getJavaHome());

        // C:\Users\Lutfi
        System.out.println(SystemUtils.getUserHome());

        // true
        System.out.println(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_RECENT));
    }
}

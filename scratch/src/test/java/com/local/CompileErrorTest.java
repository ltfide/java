package com.local;

import org.junit.jupiter.api.Test;

public class CompileErrorTest {

    @Test
    void test() {
        String s = "Hello";
        long l = 99;
        double d = 1.11;
        int i = 1;
        int j = i;
    }
}

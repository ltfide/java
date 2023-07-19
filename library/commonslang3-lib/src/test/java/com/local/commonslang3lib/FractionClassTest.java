package com.local.commonslang3lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.apache.commons.lang3.math.Fraction;
import org.junit.jupiter.api.Test;

public class FractionClassTest {

    @Test
    void testGetFraction() {
        assertInstanceOf(Fraction.class, Fraction.getFraction(5, 6));
    }

    @Test
    void testTwoFractionInstances() {
        Fraction fraction1 = Fraction.getFraction(1, 4);
        Fraction fraction2 = Fraction.getFraction(3, 4);

        assertEquals("1/1", fraction1.add(fraction2).toString());
        assertEquals("1/2", fraction2.subtract(fraction1).toString());
        assertEquals("3/16", fraction2.multiplyBy(fraction1).toString());
        assertEquals("3/1", fraction2.divideBy(fraction1).toString());
    }
}
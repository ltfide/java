package com.local;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ScratchTest {

    @Test
    void mathFloorTest() {
        System.out.println(Math.floor(-2.1)); // -3.0
    }

    @Test
    void bitwiseOr() {
        System.out.println(010 | 4); // 12
    }

    @Test
    void concenationTest() {
        String s = "Hello";
        int i = 10;
        s += i;
        System.out.println(s); // Hello10
    }

    @Test
    void implicitCase() {
        byte b = 10;
        b += 10;
        System.out.println(b);
    }

    @Test
    void legalIdentifiers() {
        // String 2variable = "asdsa"; // wrong
        String Variable2 = "TEst";
        String _asdasdasdas = "ASDASD";
        String _3_ = "ASasdasd";
        String $anontherVar = "ASdas";
        // String #myFar = "ASdas"; // wrong
    }

    @Test
    void testList() {
        List<String> list = new ArrayList<String>();
        list.add("Dhanbad");
        list.add(0, "New York");
        list.add("Mumbai");
        list.add(2, "Sydney");
        System.out.println(list);
    }

    @Test
    void testComment() {
        /*** sadasdas */
        String name = "!23"; /* dsadas ****/

    }
}

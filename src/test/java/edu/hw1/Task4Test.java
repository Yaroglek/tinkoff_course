package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task4Test {

    @Test
    void fixString1() {
        Assertions.assertEquals("214365", Task4.fixString("123456"));
    }

    @Test
    void fixString2() {
        Assertions.assertEquals("abcde", Task4.fixString("badce"));
    }

    @Test
    void fixString3() {

        Assertions.assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
    }
}

package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task4Test {

    @Test
    void fixString1() {
        Assertions.assertEquals(Task4.fixString("123456"), "214365");
    }

    @Test
    void fixString2() {
        Assertions.assertEquals(Task4.fixString("badce"), "abcde");
    }

    @Test
    void fixString3() {

        Assertions.assertEquals(Task4.fixString("hTsii  s aimex dpus rtni.g"), "This is a mixed up string.");
    }
}

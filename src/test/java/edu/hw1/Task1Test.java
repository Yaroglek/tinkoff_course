package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {

    @Test
    void test1() {
        Assertions.assertEquals(60, Task1.minutesToSeconds("01:00"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(836, Task1.minutesToSeconds("13:56"));
    }

    @Test
    void test3() {
        Assertions.assertEquals(-1, Task1.minutesToSeconds("10:60"));
    }

    @Test
    void test4() {
        Assertions.assertEquals(59881, Task1.minutesToSeconds("998:01"));
    }

    @Test
    void test5() {
        Assertions.assertEquals(0, Task1.minutesToSeconds("00:00"));
    }

}

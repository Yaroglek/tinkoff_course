package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {

    @Test
    void test1() {
        Assertions.assertEquals(Task1.minutesToSeconds("01:00"), 60);
    }

    @Test
    void test2() {
        Assertions.assertEquals(Task1.minutesToSeconds("13:56"), 836);
    }

    @Test
    void test3() {
        Assertions.assertEquals(Task1.minutesToSeconds("10:60"), -1);
    }

    @Test
    void test4() {
        Assertions.assertEquals(Task1.minutesToSeconds("998:01"), 59881);
    }

    @Test
    void test5() {
        Assertions.assertEquals(Task1.minutesToSeconds("00:00"), 0);
    }

}

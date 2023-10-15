package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task6Test {

    @Test
    void countK1() {
        Assertions.assertEquals(Task6.countK(6621), 5);
    }

    @Test
    void countK2() {
        Assertions.assertEquals(Task6.countK(6554), 4);
    }

    @Test
    void countK3() {
        Assertions.assertEquals(Task6.countK(1234), 3);
    }
}

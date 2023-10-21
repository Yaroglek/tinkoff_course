package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task7Test {

    @Test
    void rotateRight1() {
        Assertions.assertEquals(4, Task7.rotateRight(8, 1));
    }

    @Test
    void rotateRight2() {
        Assertions.assertEquals(8, Task7.rotateRight(8, 32));
    }

    @Test
    void rotateLeft1() {
        Assertions.assertEquals(22, Task7.rotateLeft(26, 3));
    }

    @Test
    void rotateLeft2() {
        Assertions.assertEquals(6, Task7.rotateLeft(17, 2));
    }
}

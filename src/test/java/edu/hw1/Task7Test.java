package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task7Test {

    @Test
    void rotateRight1() {
        Assertions.assertEquals(Task7.rotateRight(8, 1), 4);
    }

    @Test
    void rotateRight2() {
        Assertions.assertEquals(Task7.rotateRight(8, 32), 8);
    }

    @Test
    void rotateLeft1() {
        Assertions.assertEquals(22, Task7.rotateLeft(26, 3));
    }

    @Test
    void rotateLeft2() {
        Assertions.assertEquals(Task7.rotateLeft(17, 2), 6);
    }
}

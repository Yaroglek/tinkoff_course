package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void isNestable1() {
        assertTrue(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 6}));
    }

    @Test
    void isNestable2() {
        assertTrue(Task3.isNestable(new int[]{3, 1}, new int[]{4, 0}));
    }

    @Test
    void isNestable3() {
        assertFalse(Task3.isNestable(new int[]{9, 9, 8}, new int[]{8, 9}));
    }

    @Test
    void isNestable4() {
        assertFalse(Task3.isNestable(new int[]{1, 2, 3, 4}, new int[]{2, 3}));
    }
}

package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void hasSpecialSymbols1() {
        assertTrue(Task4.hasSpecialSymbols("pa$$word"));
    }

    @Test
    void hasSpecialSymbols2() {
        assertTrue(Task4.hasSpecialSymbols("pa%word|"));
    }

    @Test
    void hasSpecialSymbols3() {
        assertTrue(Task4.hasSpecialSymbols("pa^@word"));
    }

    @Test
    void hasSpecialSymbols4() {
        assertFalse(Task4.hasSpecialSymbols(""));
    }

    @Test
    void hasSpecialSymbols5() {
        assertFalse(Task4.hasSpecialSymbols("password ni//er"));
    }
}

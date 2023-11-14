package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void isCorrectCarPlate1() {
        assertTrue(Task5.isCorrectCarPlate("А123ВЕ777"));
    }

    @Test
    void isCorrectCarPlate2() {
        assertTrue(Task5.isCorrectCarPlate("О777ОО177"));
    }

    @Test
    void isCorrectCarPlate3() {
        assertFalse(Task5.isCorrectCarPlate("123АВЕ777"));
    }

    @Test
    void isCorrectCarPlate4() {
        assertFalse(Task5.isCorrectCarPlate("А123ВГ77"));
    }

    @Test
    void isCorrectCarPlate5() {
        assertFalse(Task5.isCorrectCarPlate("А123ВЕ7777"));
    }
}

package edu.hw3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void convertToRoman1() {
        assertEquals("II", Task4.convertToRoman(2));
    }

    @Test
    void convertToRoman2() {
        assertEquals("XII", Task4.convertToRoman(12));
    }

    @Test
    void convertToRoman3() {
        assertEquals("XVI", Task4.convertToRoman(16));
    }

    @Test
    void convertToRoman4() {
        assertEquals("CXCIV", Task4.convertToRoman(194));
    }

    @Test
    void convertToRoman5() {
        assertEquals("CCXXVIII", Task4.convertToRoman(228));
    }

    @Test
    void convertToRoman6() {
        assertEquals("MCDLXXXVIII", Task4.convertToRoman(1488));
    }

    @Test
    void convertToRoman7() {
        assertNull(Task4.convertToRoman(100000));
    }
}

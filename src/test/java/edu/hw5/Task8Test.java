package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @Test
    void hasOddLength1() {
        assertTrue(Task8.hasOddLength("10001"));
    }

    @Test
    void hasOddLength2() {
        assertFalse(Task8.hasOddLength("1000"));
    }

    @Test
    void hasOddLength3() {
        assertFalse(Task8.hasOddLength("abba"));
    }

    @Test
    void hasOddOrEvenLength() {
        assertTrue(Task8.hasOddOrEvenLength("01111"));
    }

    @Test
    void hasOddOrEvenLength2() {
        assertTrue(Task8.hasOddOrEvenLength("1101"));
    }

    @Test
    void hasOddOrEvenLength3() {
        assertFalse(Task8.hasOddOrEvenLength("1sdasd"));
    }

    @Test
    void hasOddOrEvenLength4() {
        assertFalse(Task8.hasOddOrEvenLength("100"));
    }

    @Test
    void hasOddOrEvenLength5() {
        assertFalse(Task8.hasOddOrEvenLength("00"));
    }

    @Test
    void isEveryOddCharOne1() {
        assertTrue(Task8.isEveryOddCharOne("1010101"));
    }

    @Test
    void isEveryOddCharOne2() {
        assertFalse(Task8.isEveryOddCharOne("1010100"));
    }

    @Test
    void isEveryOddCharOne3() {
        assertFalse(Task8.isEveryOddCharOne("1a1a1a1"));
    }

    @Test
    void isNot11Or111_1() {
        assertFalse(Task8.isNot11Or111("11"));
    }

    @Test
    void isNot11Or111_2() {
        assertFalse(Task8.isNot11Or111("111"));
    }

    @Test
    void isNot11Or111_3() {
        assertTrue(Task8.isNot11Or111("1111111"));
    }

    @Test
    void isNot11Or111_4() {
        assertFalse(Task8.isNot11Or111("asdasd"));
    }
}

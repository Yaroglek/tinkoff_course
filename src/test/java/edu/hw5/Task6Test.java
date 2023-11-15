package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void isSubsequence1() {
        assertTrue(Task6.isSubsequence("abc", "achfdbaabgabcaabg"));
    }
    @Test
    void isSubsequence2() {
        assertTrue(Task6.isSubsequence("gnom", "jsdfgnldfnggnomdfgdz"));
    }
    @Test
    void isSubsequence3() {
        assertFalse(Task6.isSubsequence("n", "abcde"));
    }
}

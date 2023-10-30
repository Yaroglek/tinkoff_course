package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task5Test {

    @Test
    void isPalindromeDescendant1() {
        Assertions.assertTrue(Task5.isPalindromeDescendant("11211230"));
    }

    @Test
    void isPalindromeDescendant2() {
        Assertions.assertTrue(Task5.isPalindromeDescendant("13001120"));
    }

    @Test
    void isPalindromeDescendant3() {
        Assertions.assertTrue(Task5.isPalindromeDescendant("23336014"));
    }

    @Test
    void isPalindromeDescendant4() {
        Assertions.assertTrue(Task5.isPalindromeDescendant("11"));
    }

    @Test
    void isPalindromeDescendant5() {
        Assertions.assertTrue(Task5.isPalindromeDescendant("123312"));
    }
}

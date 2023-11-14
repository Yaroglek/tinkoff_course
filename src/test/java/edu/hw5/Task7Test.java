package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void firstRegex1() {
        assertTrue(Task7.firstRegex("11001"));
    }

    @Test
    void firstRegex2() {
        assertFalse(Task7.firstRegex("1110"));
    }

    @Test
    void firstRegex3() {
        assertFalse(Task7.firstRegex("110"));
    }

    @Test
    void firstRegex4() {
        assertFalse(Task7.firstRegex("asdasd"));
    }

    @Test
    void secondRegex1() {
        assertTrue(Task7.secondRegex("010010"));
    }

    @Test
    void secondRegex2() {
        assertTrue(Task7.secondRegex("100101"));
    }

    @Test
    void secondRegex3() {
        assertFalse(Task7.secondRegex("010101"));
    }

    @Test
    void secondRegex4() {
        assertFalse(Task7.secondRegex("010dasdd101"));
    }

    @Test
    void thirdRegex1() {
        assertTrue(Task7.thirdRegex("100"));
    }

    @Test
    void thirdRegex2() {
        assertFalse(Task7.thirdRegex("1000"));
    }

    @Test
    void thirdRegex3() {
        assertFalse(Task7.thirdRegex(""));
    }

    @Test
    void thirdRegex4() {
        assertFalse(Task7.thirdRegex("abc"));
    }

}

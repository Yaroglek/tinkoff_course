package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void clusterize1() {
        assertEquals(new ArrayList<String>(
            Arrays.asList("()", "()", "()")), Task2.clusterize("()()()"));
    }
    @Test
    void clusterize2() {
        assertEquals(new ArrayList<String>(
            Arrays.asList("((()))")), Task2.clusterize("((()))"));
    }
    @Test
    void clusterize3() {
        assertEquals(new ArrayList<String>(
            Arrays.asList("((()))", "(())", "()", "()", "(()())")), Task2.clusterize("((()))(())()()(()())"));
    }
    @Test
    void clusterize4() {
        assertEquals(new ArrayList<String>(
            Arrays.asList("((())())", "(()(()()))")), Task2.clusterize("((())())(()(()()))"));
    }
}

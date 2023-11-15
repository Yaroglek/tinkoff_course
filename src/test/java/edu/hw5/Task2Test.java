package edu.hw5;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void findAllFridaysThirteen1() {
        assertEquals(List.of("1925-02-13", "1925-03-13", "1925-11-13"), Task2.findAllFridaysThirteen(1925));
    }

    @Test
    void findAllFridaysThirteen2() {
        assertEquals(List.of("2024-09-13", "2024-12-13"), Task2.findAllFridaysThirteen(2024));
    }

    @Test
    void findNextFriday13() {
        assertEquals("2023-10-13", Task2.findNextFridayThirteen("2023-05-09"));
    }
}

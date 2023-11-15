package edu.hw5;

import edu.hw1.Task6;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void averageTime() {
        var sessions = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20",
            "2022-05-03, 21:00 - 2022-05-03, 22:00",
            "2022-03-05, 23:30 - 2022-03-06, 01:00",
            "2022-02-07, 21:20 - 2022-02-08, 02:30");

        assertEquals("3ч 0м", Task1.averageTime(sessions));
    }
}

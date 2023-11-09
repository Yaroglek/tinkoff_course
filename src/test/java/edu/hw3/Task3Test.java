package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void freqDict1() {
        assertEquals(Map.of("bb", 2, "a", 2), Task3.freqDict(new String[] {"a", "bb", "a", "bb"}));
    }

    @Test
    void freqDict2() {
        assertEquals(
            Map.of("that", 1, "and", 2, "this", 1),
            Task3.freqDict(new String[] {"this", "and", "that", "and"})
        );
    }

    @Test
    void freqDict3() {
        assertEquals(Map.of("код", 3, "bug", 1), Task3.freqDict(new String[] {"код", "код", "код", "bug"}));
    }

    @Test
    void freqDict4() {
        assertEquals(Map.of(1, 2, 2, 2), Task3.freqDict(new Integer[] {1, 1, 2, 2}));
    }

    @Test
    void freqDict5() {
        assertEquals(Map.of(), Task3.freqDict(new Integer[0]));
    }
}

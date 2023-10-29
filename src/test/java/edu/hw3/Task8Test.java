package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @Test
    void hasNext() {
        var it = new BackwardIterator<>(Arrays.asList(1, 2, 3));
        var result = new ArrayList<>();
        while (it.hasNext()) {
            result.add(it.next());
        }

        assertEquals(Arrays.asList(3, 2, 1), result);
    }
}

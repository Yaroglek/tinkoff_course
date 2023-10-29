package edu.hw3;

import edu.hw3.Task7.NullComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void compare() {
        var tree = new TreeMap<String, String>(new NullComparator());
        tree.put(null, "test");
        assertTrue(tree.containsKey(null));
    }
}

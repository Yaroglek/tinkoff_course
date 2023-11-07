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

    @Test
    void compare1() {
        var tree = new TreeMap<String, Integer>(new NullComparator());
        tree.put(null, 1);
        tree.put("gnom", 5);
        tree.put("nibba", 7);
        assertTrue(tree.containsKey(null));
    }
}

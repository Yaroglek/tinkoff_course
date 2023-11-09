package edu.hw3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void parseContacts1() {
        assertEquals(
            new ArrayList<>(Arrays.asList("Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke")),
            Task5.parseContacts(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, Task5.Order.ASC)
        );
    }

    @Test
    void parseContacts2() {
        assertEquals(
            new ArrayList<>(Arrays.asList("Carl Gauss", "Leonhard Euler", "Paul Erdos")),
            Task5.parseContacts(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, Task5.Order.DESC)
        );
    }

    @Test
    void parseContacts3() {
        assertEquals(
            new ArrayList<>(),
            Task5.parseContacts(new String[] {}, Task5.Order.DESC)
        );
    }

    @Test
    void parseContacts4() {
        assertEquals(
            new ArrayList<>(),
            Task5.parseContacts(null, Task5.Order.DESC)
        );
    }

    @Test
    void parseContacts5() {
        assertEquals(
            new ArrayList<>(Arrays.asList("Paul", "Leonhard", "Carl Gauss")),
            Task5.parseContacts(new String[] {"Paul", "Leonhard", "Carl Gauss"}, Task5.Order.DESC)
        );
    }

    @Test
    void parseContacts6() {
        assertEquals(
            new ArrayList<>(Arrays.asList("Brad", "Carl", "Hank", "James")),
            Task5.parseContacts(new String[] {"Carl", "Hank", "Brad", "James"}, Task5.Order.ASC)
        );
    }
}

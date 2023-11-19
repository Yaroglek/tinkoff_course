package edu.hw6;

import edu.hw6.Task5.HackerNews;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void hackerNewsTopStories() {
        assertNotEquals(new long[] {}, new HackerNews().hackerNewsTopStories());
    }

    @Test
    void news1() {
        assertEquals("JDK 21 Release Notes", new HackerNews().news(37570037));
    }

    @Test
    void news2() {
        assertEquals("My YC app: Dropbox - Throw away your USB drive", new HackerNews().news(8863));
    }
}

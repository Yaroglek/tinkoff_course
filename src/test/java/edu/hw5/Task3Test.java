package edu.hw5;

import edu.hw5.Task3.Task3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void parseDate1() {
        var expected = Optional.of(LocalDate.parse("2020-10-10"));
        Assertions.assertEquals(expected, Task3.parseDate("2020-10-10"));
    }
    @Test
    void parseDate2() {
        var expected = Optional.of(LocalDate.parse("2020-12-02"));
        assertEquals(expected, Task3.parseDate("2020-12-2"));
    }
    @Test
    void parseDate3() {
        var expected = Optional.of(LocalDate.parse("1976-03-01"));
        assertEquals(expected, Task3.parseDate("1/3/1976"));
    }
    @Test
    void parseDate4() {
        var expected = Optional.of(LocalDate.parse("2020-03-01"));
        assertEquals(expected, Task3.parseDate("1/3/20"));
    }
    @Test
    void parseDate5() {
        var expected = Optional.of(LocalDate.now());
        assertEquals(expected, Task3.parseDate("today"));
    }
    @Test
    void parseDate6() {
        var expected = Optional.of(LocalDate.now().plusDays(1));
        assertEquals(expected, Task3.parseDate("tomorrow"));
    }
    @Test
    void parseDate7() {
        var expected = Optional.of(LocalDate.now().minusDays(1));
        assertEquals(expected, Task3.parseDate("yesterday"));
    }
    @Test
    void parseDate8() {
        var expected = Optional.of(LocalDate.now().minusDays(1));
        assertEquals(expected, Task3.parseDate("1 day ago"));
    }
    @Test
    void parseDate9() {
        var expected = Optional.of(LocalDate.now().minusDays(2234));
        assertEquals(expected, Task3.parseDate("2234 days ago"));
    }
    @Test
    void parseDate10() {
        var expected = Optional.empty();
        assertEquals(expected, Task3.parseDate(""));
    }
}

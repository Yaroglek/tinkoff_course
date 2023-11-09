package edu.project1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleHangmanTest {

    @Test
    void incorrectLength() throws Exception {
        var game = new ConsoleHangman(new Session("", 5));
        GuessingException exception = assertThrows(GuessingException.class, game::run);
        assertEquals("Error message: Incorrect length.", exception.getMessage());
    }
}

package edu.hw6;

import edu.hw6.Task4.Task4;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void composition() throws IOException {
        Path path = Paths.get("src/main/java/edu/hw6/Task4/output.txt");
        Task4.composition(path);
        String text = Files.readAllLines(path).get(0);
        assertEquals(text, "Programming is learned by writing programs. ― Brian Kernighan");
        Files.deleteIfExists(path);
    }
}

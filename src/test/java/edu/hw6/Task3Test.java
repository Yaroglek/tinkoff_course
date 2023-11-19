package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static edu.hw6.Task3.AbstractFilter.*;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test void filter() throws IOException {
        Path path = Paths.get("C:\\Users\\kreml\\IdeaProjects\\tinkoff\\src\\main\\java\\edu\\hw6\\Task3");

        DirectoryStream.Filter<Path> filter = regularFile()
            .and(readable())
            .and(largerThan(100))
            .and(magicNumber(0x89, 'P', 'N', 'G'))
            .and(globMatches("*.png"))
            .and(regexContains("[_]"));

        List<String> actual = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            entries.forEach(p -> actual.add(p.getFileName().toString()));
        }

        assertEquals(List.of("Alfabank_logo.png"), actual);
    }
}

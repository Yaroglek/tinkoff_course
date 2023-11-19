package edu.hw6;

import edu.hw6.Task2.Task2;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void cloneFile() throws IOException {
        Path path =
            Paths.get("C:\\Users\\kreml\\IdeaProjects\\tinkoff\\src\\main\\java\\edu\\hw6\\Task2\\files\\data.txt");
        Task2.cloneFile(path);
        Task2.cloneFile(path);
        Task2.cloneFile(path);

        List<String> actual = new ArrayList<>();
        try (Stream<Path> result = Files.walk(path.getParent())) {
            result
                .filter(Files::isRegularFile)
                .map(p -> p.getFileName().toString())
                .forEach(actual::add);
        }

        assertEquals(List.of("data — копия (2).txt", "data — копия.txt", "data.txt"), actual);

        try (Stream<Path> files = Files.walk(path.getParent())) {
            files
                .filter(Files::isRegularFile)
                .forEach(path1 -> {
                    try {
                        Files.deleteIfExists(path1);
                    } catch (IOException e) {
                        Logger.getLogger("Task2test").warning("error");
                    }
                });
        }
    }
}

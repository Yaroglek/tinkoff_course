package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    private Task2() {

    }

    public static void cloneFile(Path path) {
        boolean flag = true;
        while (flag) {
            if (!Files.exists(path)) {
                try {
                    Files.createFile(path);
                    flag = false;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else {
                String fileName = path.getFileName().toString();


            }
        }
    }
}

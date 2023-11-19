package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    private Task2() {

    }

    public static void cloneFile(Path path) {
        while (true) {
            if (!Files.exists(path)) {
                try {
                    Files.createFile(path);
                    break;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                String parent = path.getParent().toString();
                String[] parts = path.getFileName().toString().split("\\.");
                String name = parts[0];
                String extension = parts[1];
                Pattern pattern = Pattern.compile("^.+ — копия \\((\\d+)\\)$");
                Matcher matcher = pattern.matcher(name);

                if (matcher.matches()) {
                    int oldNum = Integer.parseInt(matcher.group(1));
                    String newName = name.replaceFirst("\\(" + oldNum + "\\)", "(" + oldNum + 1 + ")");
                    path = Paths.get(parent, newName + "." + extension);
                } else {
                    path = Paths.get(parent, name + " — копия (1)" + "." + extension);
                }
            }
        }
    }
}

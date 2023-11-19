package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"ParameterAssignment", "MultipleStringLiterals"})
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
                    throw new RuntimeException(ex);
                }
            } else {
                String parent = path.getParent().toString();
                String[] parts = path.getFileName().toString().split("\\.");
                String name = parts[0];
                String extension = parts[1];
                Matcher matcher = Pattern.compile("^.+ — копия( \\((\\d+)\\))?$").matcher(name);

                if (!matcher.matches()) {
                    path = Paths.get(parent, name + " — копия" + "." + extension);
                } else if (name.endsWith(" — копия")) {
                    path = Paths.get(parent, name + " (2)." + extension);
                } else {
                    int oldNum = Integer.parseInt(matcher.group(2));
                    String newName = name.replaceFirst("\\(" + oldNum + "\\)", "(" + (oldNum + 1) + ")");
                    path = Paths.get(parent, newName + "." + extension);
                }
            }
        }
    }
}

package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;

@SuppressWarnings("MagicNumber")
public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and(AbstractFilter other) {
        return path -> this.accept(path) && other.accept(path);
    }

    static AbstractFilter regularFile() {
        return Files::isRegularFile;
    }

    static AbstractFilter readable() {
        return Files::isReadable;
    }

    static AbstractFilter largerThan(long size) {
        return path -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static AbstractFilter magicNumber(int... magicNumbers) {
        return path -> {
            byte[] bytes = Files.readAllBytes(path);
            if (bytes.length < magicNumbers.length) {
                return false;
            }
            for (int i = 0; i < magicNumbers.length; i++) {
                if ((bytes[i] & 0xFF) != magicNumbers[i]) {
                    return false;
                }
            }
            return true;
        };
    }

    static AbstractFilter globMatches(String globPattern) {
        return path -> {
            PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + globPattern);
            Path fileName = path.getFileName();
            return fileName != null && matcher.matches(fileName);
        };
    }

    static AbstractFilter regexContains(String regex) {
        return path -> {
            Path fileName = path.getFileName();
            return fileName != null & Pattern.compile(regex).matcher(path.getFileName().toString()).find();
        };
    }

    @Override
    boolean accept(Path entry) throws IOException;
}

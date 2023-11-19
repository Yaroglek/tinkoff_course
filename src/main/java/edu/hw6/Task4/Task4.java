package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Task4 {
    private Task4() {

    }

    public static void composition(Path path) throws IOException {
        try (
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new CheckedOutputStream(
                Files.newOutputStream(path),
                new Adler32()
            )), StandardCharsets.UTF_8.newEncoder()));) {
            printWriter.write("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

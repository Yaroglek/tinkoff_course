package edu.project1;

import java.io.IOException;

public class Main {
    private Main() {
    }

    public static void main(String[] args) throws IOException {
        var dict = new GameDictionary();
        var ch = new ConsoleHangman(new Session(dict.randomWord(), 3));
        ch.run();
    }
}

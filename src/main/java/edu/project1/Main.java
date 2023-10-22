package edu.project1;

public class Main {

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) throws Exception {
        var dict = new Dictionary.GameDictionary();
        var game = new ConsoleHangman(new Session(dict.randomWord(), 5));
        game.run();
    }
}

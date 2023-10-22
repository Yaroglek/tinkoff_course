package edu.project1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;
import static java.lang.System.out;

interface Dictionary {
    @NotNull String randomWord();
}

class GameDictionary implements Dictionary {
    private final String[] words = {"nigger", "gnome", "dwarf"};
    @Override
    public @NotNull String randomWord() {
        var index = new Random().nextInt(words.length);
        return words[index];
    }
}

class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        var userAns = new char[answer.length()];
        for (var i = 0; i < answer.length(); i++) {
            userAns[i] = '*';
        }
        this.userAnswer = userAns;
    }

    public char[] getUserAnswer() {
        return userAnswer;
    }

    @NotNull GuessResult guess(String guess) throws Exception {

        if (answer.contains(guess) && !new String(userAnswer).contains(guess)) {
            var indexes = new ArrayList<Integer>();
            for (var i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == guess.charAt(0)) {
                    indexes.add(i);
                }
            }
            for (var index : indexes) {
                userAnswer[index] = guess.charAt(0);
            }

            if (new String(userAnswer).equals(answer)) {
                return new GuessResult.Win(userAnswer, attempts, maxAttempts);
            }
            return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts);
        }

        if (answer.contains(guess) && new String(userAnswer).contains(guess)){
            return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts);
        }

        if (!answer.contains(guess)) {
            attempts++;
            if (attempts == maxAttempts) {
                return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
            }

            return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
        }

        throw new Exception("Something wrong");
    }

    @NotNull GuessResult giveUp() {
        return null;
    }
}

sealed interface GuessResult {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

    record Defeat(char[] state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "You lost!";
        }
    }

    record Win(char[] state, int attempt, int maxAttempts) implements GuessResult {

        @Override
        public @NotNull String message() {
            return "You won!";
        }
    }

    record SuccessfulGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Hit!";
        }
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return String.format("Missed, mistake %s out of %s.", attempt, maxAttempts);
        }
    }
}

class ConsoleHangman {

    private final Session session;

    public ConsoleHangman(Session session) {
        this.session = session;
    }

    public void run() throws IOException {
        Scanner in = new Scanner(System.in);
        while (true) {
            out.println("Guess a letter:");
            var res = tryGuess(session, in.nextLine());
            if (res == null) {
                continue;
            }
            printState(res);
            if (res.getClass() == GuessResult.Win.class || res.getClass() == GuessResult.Defeat.class) {
                break;
            }
            out.println("The word: " + new String(session.getUserAnswer()));
        }

        in.close();
    }

    private GuessResult tryGuess(Session session, String input) {
        if (input.length() != 1) {
            return null;
        }
        try {
            return session.guess(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void printState(GuessResult guessResult) {
        out.println(guessResult.message());
    }
}

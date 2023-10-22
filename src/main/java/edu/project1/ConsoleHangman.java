package edu.project1;

import java.util.Scanner;

@SuppressWarnings("RegexpSinglelineJava")
public class ConsoleHangman {

    private final Session session;

    public ConsoleHangman(Session session) {
        this.session = session;
    }

    public void run() throws Exception {
        if (session.getAnswer().isEmpty()) {
            throw new Exception("Incorrect length");
        }
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Guess a letter:");
            var guess = tryGuess(session, in.nextLine());
            if (guess == null) {
                continue;
            }
            printState(guess);
            if (isGameOver(guess)) {
                break;
            }
            System.out.println("The word: " + new String(session.getUserAnswer()));
        }

        in.close();
    }

    private static boolean isGameOver(GuessResult guess) {
        return guess.getClass() == GuessResult.Win.class || guess.getClass() == GuessResult.Defeat.class;
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
        System.out.println(guessResult.message());
    }
}

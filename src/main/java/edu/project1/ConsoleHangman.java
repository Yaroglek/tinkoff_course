package edu.project1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleHangman {

    private final Session session;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public ConsoleHangman(Session session) {
        this.session = session;
    }

    public void run() throws Exception {
        if (session.getAnswer().isEmpty()) {
            throw new GuessingException("Incorrect length");
        }

        Scanner in = new Scanner(System.in);
        System.setProperty(
            "java.util.logging.SimpleFormatter.format",
            "%4$s: %5$s%n"
        );
        logger.info("If you want to surrender, press CTRL+D:");

        while (true) {
            logger.info("Guess a letter:");
            String input;

            try {
                input = in.nextLine();
            } catch (NoSuchElementException ignored) {
                input = "";
            }
            var guess = !input.isEmpty() ? tryGuess(session, input) : session.giveUp();
            if (guess == null) {
                continue;
            }
            printState(guess);
            if (isGameOver(guess)) {
                break;
            }

            logger.info("The word: " + new String(session.getUserAnswer()) + "\n");
        }

        in.close();
    }

    private static boolean isGameOver(GuessResult guess) {
        return guess.getClass() == GuessResult.Win.class || guess.getClass() == GuessResult.Defeat.class;
    }

    private GuessResult tryGuess(Session session, String input) {
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            return null;
        }
        try {
            return session.guess(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void printState(GuessResult guessResult) {
        logger.info(guessResult.message());
    }
}

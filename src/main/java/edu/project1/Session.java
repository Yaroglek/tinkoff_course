package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Session {
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

    public String getAnswer() {
        return answer;
    }

    @NotNull GuessResult guess(String input) throws Exception {
        String guess = input.toLowerCase();
        if (answer.contains(guess) && !new String(userAnswer).contains(guess)) {
            for (var i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == guess.charAt(0)) {
                    userAnswer[i] = guess.charAt(0);
                }
            }

            if (new String(userAnswer).equals(answer)) {
                return new GuessResult.Win(userAnswer, attempts, maxAttempts);
            }
            return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts);
        }

        if (!answer.contains(guess)) {
            attempts++;
            if (attempts == maxAttempts) {
                return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
            }

            return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
        }

        throw new GuessingException("Incorrect input");
    }

    @NotNull GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts);
    }
}
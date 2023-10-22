package edu.project1;

import java.util.ArrayList;
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

        if (answer.contains(guess) && new String(userAnswer).contains(guess)) {
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

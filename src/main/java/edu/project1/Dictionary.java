package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public interface Dictionary {
    @NotNull String randomWord();

    class GameDictionary implements Dictionary {
        private final String[] words = {"hello", "world"};

        private static final Random random = new Random();
        @Override
        public @NotNull String randomWord() {
            var index = random.nextInt(0, words.length);
            return words[index];
        }
    }
}

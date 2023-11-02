package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public interface Dictionary {
    @NotNull String randomWord();

    class GameDictionary implements Dictionary {
        private final String[] words = {"hello", "world"};

        @Override
        public @NotNull String randomWord() {
            var index = new Random().nextInt(0, words.length);
            return words[index];
        }
    }
}

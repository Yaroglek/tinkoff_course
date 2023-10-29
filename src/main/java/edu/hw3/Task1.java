package edu.hw3;

@SuppressWarnings("MagicNumber")
public class Task1 {
    private Task1() {
    }

    public static String atbash(String input) {
        var chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char el = chars[i];
            if (isEnglishLetter(el)) {
                if (Character.isUpperCase(el)) {
                    chars[i] = (char) (65 - el + 90);
                } else {
                    chars[i] = (char) (97 - el + 122);
                }
            }
        }

        return new String(chars);
    }

    private static boolean isEnglishLetter(char letter) {
        return (letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z');
    }
}

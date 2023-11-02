package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(String number) {
        if (number.length() < 2) {
            return false;
        }
        if (number.equals(new StringBuilder(number).reverse().toString())) {
            return true;
        }
        var child = getChild(number);
        return isPalindromeDescendant(child);
    }

    private static String getChild(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i += 2) {
            int digit1 = Character.getNumericValue(str.charAt(i));
            if (i + 1 < str.length()) {
                int digit2 = Character.getNumericValue(str.charAt(i + 1));
                result.append(digit1 + digit2);
            } else {
                result.append(digit1);
            }
        }

        return result.toString();
    }
}

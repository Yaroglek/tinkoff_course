package edu.hw1;

public class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        if (number < 10) {
            return false;
        }
        if (isPalindrome(number)) {
            return true;
        }

        String numStr = String.valueOf(number);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numStr.length(); i += 2) {
            int digit1 = Character.getNumericValue(numStr.charAt(i));
            if (i + 1 < numStr.length()) {
                int digit2 = Character.getNumericValue(numStr.charAt(i + 1));
                result.append(digit1 + digit2);
            } else {
                result.append(digit1);
            }
        }

        return isPalindromeDescendant(Integer.parseInt(result.toString()));
    }

    private static boolean isPalindrome(int number) {
        int result = 0, temp = number;
        while (temp > 0) {
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        return result == number;
    }
}

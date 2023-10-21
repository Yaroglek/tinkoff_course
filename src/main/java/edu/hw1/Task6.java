package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    private Task6() {
    }

    private static final int KAPREKAR = 6174;

    public static int countK(int number) {
        if (number < 1000 || number > 9999 || checkSameDigits(number)) {
            return -1;
        }
        var list = new ArrayList<>(Arrays.asList(String.valueOf(number).split("")));
        Collections.sort(list);
        Collections.reverse(list);
        var descNum = Integer.parseInt(String.join("", list));
        var diff = descNum - reverseNumber(descNum);

        if (diff == KAPREKAR) {
            return 1;
        }
        return 1 + countK(diff);
    }

    private static int reverseNumber(int number) {
        int result = 0;

        while (number != 0) {
            int digit = number % 10;
            result = result * 10 + digit;
            number = number / 10;
        }

        return result;
    }

    private static boolean checkSameDigits(int number) {
        String str = Integer.toString(number);
        char firstDigit = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != firstDigit) {
                return false;
            }
        }

        return true;
    }
}

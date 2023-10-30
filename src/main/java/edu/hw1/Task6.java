package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class Task6 {
    private Task6() {
    }

    private static final int KAPREKAR = 6174;
    private static final int LOWER_BOUND = 1000;
    private static final int UPPER_BOUND = 9999;
    private static final int SAME_DIGITS = 1111;

    public static int countK(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND || number % SAME_DIGITS == 0) {
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

    @SuppressWarnings({"MagicNumber", "ParameterAssignment"})
    private static int reverseNumber(int number) {
        int result = 0;

        while (number != 0) {
            int digit = number % 10;
            result = result * 10 + digit;
            number = number / 10;
        }

        return result;
    }
}

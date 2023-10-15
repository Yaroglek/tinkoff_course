package edu.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task6 {
    public static int countK(int number){
        if (number < 1000 || number > 9999)
            return -1;

        var list = new ArrayList<>(Arrays.asList(String.valueOf(number).split("")));
        Collections.sort(list);
        Collections.reverse(list);
        var descNum = Integer.parseInt(String.join("", list));
        var diff = descNum - reverseNumber(descNum);

        if (diff == 6174)
            return 1;
        return 1 + countK(diff);
    }

    public static int reverseNumber(int number) {
        int result = 0;
        while (number != 0) {
            int digit = number % 10;
            result = result * 10 + digit;
            number = number / 10;
        }
        return result;
    }
}

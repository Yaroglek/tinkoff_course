package edu.hw1;

import static java.lang.Math.abs;

public class Task2 {
    private Task2() {
    }

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;

        while (abs(number) > 0) {
            number /= 10;
            count += 1;
        }

        return count;
    }
}

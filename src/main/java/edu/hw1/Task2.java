package edu.hw1;

import static java.lang.Math.abs;

public final class Task2 {
    private Task2() {
    }

    @SuppressWarnings({"MagicNumber", "ParameterAssignment"})
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;

        while (abs(number) > 0) {
            number /= 10;
            count++;
        }

        return count;
    }
}

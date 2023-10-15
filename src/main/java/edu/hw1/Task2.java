package edu.hw1;

public class Task2 {
    public static int countDigits(int number) {
        if (number < 10) {
            return 1;
        }
        return 1 + countDigits(number / 10);
    }
}

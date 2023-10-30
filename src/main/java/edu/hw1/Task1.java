package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 60;

    public static int minutesToSeconds(String str) {
        var list = str.split(":");
        int min = Integer.parseInt(list[0]);
        int sec = Integer.parseInt(list[1]);
        if (sec >= UPPER_BOUND || sec < LOWER_BOUND || min < LOWER_BOUND) {
            return -1;
        }
        return min * UPPER_BOUND + sec;
    }
}

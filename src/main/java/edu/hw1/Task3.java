package edu.hw1;

import java.util.Arrays;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        return getMin(array1) > getMin(array2)
            & getMax(array1) < getMax(array2);
    }

    private static int getMin(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }

    private static int getMax(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }
}

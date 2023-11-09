package edu.hw3;

import java.util.HashMap;

public class Task3 {
    private Task3() {
    }

    public static <T> HashMap<T, Integer> freqDict(T[] array) {
        var result = new HashMap<T, Integer>();

        for (var el : array) {
            result.putIfAbsent(el, 0);
            result.put(el, result.get(el) + 1);
        }

        return result;
    }
}

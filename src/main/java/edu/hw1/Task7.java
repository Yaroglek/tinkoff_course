package edu.hw1;

import java.util.Arrays;
import java.util.stream.Stream;

public final class Task7 {
    private Task7() {
    }

    public static int rotateRight(int number, int shift) {
        var byteNumber = Integer.toBinaryString(number);
        var trueShift = shift % byteNumber.length();
        var byteArray = byteNumber.split("");
        var n = Stream.concat(
            Arrays.stream(byteArray).skip(byteNumber.length() - trueShift),
            Arrays.stream(byteArray).limit(byteNumber.length() - trueShift)
        ).toList();
        return Integer.parseInt(String.join("", n), 2);
    }

    public static int rotateLeft(int number, int shift) {
        return rotateRight(number, Integer.toBinaryString(number).length() - shift);
    }
}

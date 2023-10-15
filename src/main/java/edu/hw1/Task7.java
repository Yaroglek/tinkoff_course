package edu.hw1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Task7 {
    public static int rotateRight(int number, int shift){
        var byteNumber = Integer.toBinaryString(number);
        shift = shift % byteNumber.length();
        var byteArray = byteNumber.split("");
        var n = Stream.concat(Arrays.stream(byteArray).skip(byteNumber.length() - shift),
                Arrays.stream(byteArray).limit(byteNumber.length() - shift)).toList();
        return Integer.parseInt(String.join("", n), 2);
    }

    public static int rotateLeft(int number, int shift){
        var byteNumber = Integer.toBinaryString(number);
        shift = shift % byteNumber.length();
        var byteArray = byteNumber.split("");
        var n = Stream.concat(Arrays.stream(byteArray).skip(shift), Arrays.stream(byteArray).limit(shift)).toList();
        return Integer.parseInt(String.join("", n), 2);
    }
}

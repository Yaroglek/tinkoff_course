package edu.hw7;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Task2 {
    private Task2() {

    }

    public static BigInteger getFactorial(int factorial) {
        return LongStream.rangeClosed(1, factorial).parallel()
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger::multiply)
            .orElse(null);
    }
}

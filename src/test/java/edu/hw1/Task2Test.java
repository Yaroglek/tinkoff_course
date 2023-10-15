package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {
    @Test
    void countDigits1() {
        Assertions.assertEquals(Task2.countDigits(4666), 4);
    }

    @Test
    void countDigits2(){
        Assertions.assertEquals(Task2.countDigits(544), 3);
    }

    @Test
    void countDigits3(){
        Assertions.assertEquals(Task2.countDigits(0), 1);
    }

    @Test
    void countDigits4(){
        Assertions.assertEquals(Task2.countDigits(54), 2);
    }

    @Test
    void countDigits5(){
        Assertions.assertEquals(Task2.countDigits(14881), 5);
    }
}

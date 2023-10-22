package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task4.Info.*;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void callingInfo1() {
        CallingInfo info = callingInfo();
        assertEquals("edu.hw2.Task4.Info", info.className());
    }

    @Test
    void callingInfo2() {
        CallingInfo info = callingInfo();
        assertEquals("callingInfo", info.methodName());
    }

}

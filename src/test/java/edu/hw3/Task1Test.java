package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void atbash1() {
        assertEquals("Svool dliow!", Task1.atbash("Hello world!"));
    }

    @Test
    void atbash2() {
        assertEquals("", Task1.atbash(""));
    }

    @Test
    void atbash3() {
        assertEquals(
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler",
            Task1.atbash(
                "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi")
        );
    }

    @Test
    void atbash4() {
        assertEquals("гном-mrttvi", Task1.atbash("гном-nigger"));
    }
}

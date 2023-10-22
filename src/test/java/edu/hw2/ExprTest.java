package edu.hw2;

import edu.hw2.Task1.Expr.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExprTest {

    @Test
    void evaluate1() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        assertEquals(37.0, res.evaluate());
    }

    @Test
    void evaluate2() {
        var seven = new Constant(7);
        var ten = new Constant(10);
        var negSix = new Negate(new Constant(6));
        var mult = new Multiplication(seven, ten);
        var sum = new Addition(mult, negSix);
        var res = new Exponent(sum, 0.5);

        assertEquals(8.0, res.evaluate());
    }

    @Test
    void evaluate3() {
        var one = new Constant(1);
        var three = new Constant(3);
        var negTwo = new Negate(new Constant(2));
        var mult = new Multiplication(negTwo, three);
        var sum = new Addition(mult, one);
        var res = new Exponent(sum, 2);

        assertEquals(25.0, res.evaluate());
    }
}

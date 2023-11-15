package edu.hw2;

import static org.junit.jupiter.api.Assertions.*;
import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    void rectangleArea1() {
        var rect = new Rectangle();
        rect.setWidth(30);
        rect.setHeight(20);

        assertEquals(600.0, rect.area());
    }

    @Test
    void rectangleArea2() {
        var rect = new Rectangle();
        rect.setWidth(7);
        rect.setHeight(7);

        assertEquals(49.0, rect.area());
    }

    @Test
    void rectangleArea3() {
        var rect = new Rectangle();
        rect.setWidth(0);
        rect.setHeight(2);

        assertEquals(0.0, rect.area());
    }

    @Test
    void squareArea1() {
        var square = new Square();
        square.setWidth(2);
        square.setHeight(10);

        assertEquals(100, square.area());
    }

    @Test
    void squareArea2() {
        var square = new Square();
        square.setSize(6);
        assertEquals(36, square.area());
    }

    @Test
    void squareArea3() {
        var square = new Square();
        square.setHeight(11);
        assertEquals(121, square.area());
    }
}

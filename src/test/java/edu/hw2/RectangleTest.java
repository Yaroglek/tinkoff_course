package edu.hw2;

import edu.hw2.Task2.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;


public class RectangleTest {
    static Arguments[] rectangles() {
        return new Arguments[]{
                Arguments.of(new Rectangle()),
                Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea1(Rectangle rect) {
        rect.setWidth(20);
        rect.setHeight(10);

        assertEquals(200.0, rect.area());
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea2(Rectangle rect) {
        rect.setWidth(4);
        rect.setHeight(4);

        assertEquals(16.0, rect.area());
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea3(Rectangle rect) {
        rect.setWidth(0);
        rect.setHeight(4);

        assertEquals(0.0, rect.area());
    }
}

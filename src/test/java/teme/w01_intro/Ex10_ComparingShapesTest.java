package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w01_intro.Ex10_ComparingShapes.*;

/**
 * MAX GRADE: 14p
 */
@RunWith(GradeRunner.class)
public class Ex10_ComparingShapesTest {

    private static final double DELTA = 0.0001; //precision to use when comparing double values in asserts

    @Test
    @Grade(2)
    public void testCircleArea() {
        assertEquals(50.2654, circleArea(4), DELTA);
        assertEquals(78.5398, circleArea(5), DELTA);
        assertEquals(113.0973, circleArea(6), DELTA);
        assertEquals(0.78539, circleArea(0.5), DELTA);
    }

    @Test
    @Grade(2)
    public void testCircleLength() {
        assertEquals(25.1327, circleLength(4), DELTA);
        assertEquals(31.4159, circleLength(5), DELTA);
        assertEquals(37.6991, circleLength(6), DELTA);
        assertEquals(3.14159, circleLength(0.5), DELTA);
    }

    @Test
    @Grade(2)
    public void testRectangleArea() {
        assertEquals(64.0, squareArea(8), DELTA);
        assertEquals(0.64, squareArea(0.8), DELTA);
    }

    @Test
    @Grade(2)
    public void testRectanglePerimeter() {
        assertEquals(32.0, squarePerimeter(8), DELTA);
        assertEquals(3.2, squarePerimeter(0.8), DELTA);
    }

    @Test
    @Grade(3)
    public void testGreaterArea() {
        assertEquals("circle", whichHasGreaterArea(5, 8).toLowerCase());
        assertEquals("square", whichHasGreaterArea(4, 8).toLowerCase());
    }

    @Test
    @Grade(3)
    public void testGreaterPerimeter() {
        assertEquals("circle", whichHasGreaterPerimeter(4, 6).toLowerCase());
        assertEquals("square", whichHasGreaterPerimeter(5, 8).toLowerCase());
    }
}

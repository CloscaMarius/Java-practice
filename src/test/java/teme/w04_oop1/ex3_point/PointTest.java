package teme.w04_oop1.ex3_point;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 14p
 */
@RunWith(GradeRunner.class)
public class PointTest {

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        assertEquals("", "");
        assertTrue(true);
        fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    /*
    private static final double PRECISION = 0.001; //precision to use when checking equality on double values (as they may loose some precision/cannot be represented exactly in binary)
    private static final Point[] samplePoints = {new Point(0, 0), new Point(0, 4), new Point(0, -4), new Point(9, 0), new Point(-9, 0), new Point(1, 1), new Point(1, -4), new Point(-16, 9), new Point(-4, -9)};
    private static final double[] expectedDistances = {0.0, 4.0, 4.0, 9.0, 9.0, 1.4142135623730951, 4.123105625617661, 18.35755975068582, 9.848857801796104, 4.0, 0.0, 8.0, 9.848857801796104, 9.848857801796104, 3.1622776601683795, 8.06225774829855, 16.76305461424021, 13.601470508735444, 4.0, 8.0, 0.0, 9.848857801796104, 9.848857801796104, 5.0990195135927845, 1.0, 20.615528128088304, 6.4031242374328485, 9.0, 9.848857801796104, 9.848857801796104, 0.0, 18.0, 8.06225774829855, 8.94427190999916, 26.570660511172846, 15.811388300841896, 9.0, 9.848857801796104, 9.848857801796104, 18.0, 0.0, 10.04987562112089, 10.770329614269007, 11.40175425099138, 10.295630140987, 1.4142135623730951, 3.1622776601683795, 5.0990195135927845, 8.06225774829855, 10.04987562112089, 0.0, 5.0, 18.788294228055936, 11.180339887498949, 4.123105625617661, 8.06225774829855, 1.0, 8.94427190999916, 10.770329614269007, 5.0, 0.0, 21.400934559032695, 7.0710678118654755, 18.35755975068582, 16.76305461424021, 20.615528128088304, 26.570660511172846, 11.40175425099138, 18.788294228055936, 21.400934559032695, 0.0, 21.633307652783937, 9.848857801796104, 13.601470508735444, 6.4031242374328485, 15.811388300841896, 10.295630140987, 11.180339887498949, 7.0710678118654755, 21.633307652783937, 0.0};

    @Test
    @Grade(1)
    public void testCreate_returnsNewInstances() {
        assertNotSame(new Point(1, 1), new Point(1, 1));
    }

    @Test
    @Grade(1)
    public void testCreateAndToString() {
        for (double x : new double[]{-2.5, -0.1, 0, 0.5, 14.25}) {
            for (double y : new double[]{-4.25, -0.2, 0, 1.125, 7.5}) {
                String s = new Point(x, y).toString();
                assertTrue(s.contains(String.valueOf(x)));
                assertTrue(s.contains(String.valueOf(y)));
            }
        }
    }

    @Test
    @Grade(1)
    public void testDistanceTo_self_isZero() {
        for (Point p : samplePoints) {
            assertEquals("distance to itself is NOT zero, for point: [" + p + "]",
                    0, p.distanceTo(p), PRECISION);
        }
    }

    @Test
    @Grade(1)
    public void testDistanceTo_isSymmetrical() {
        for (Point p1 : samplePoints) {
            for (Point p2 : samplePoints) {
                assertEquals("distance NOT SYMMETRICAL: for p1=[" + p1 + "], p2=[" + p2 + "], distance p1->p2 is DIFFERENT from p2->p1: ",
                        p1.distanceTo(p2), p2.distanceTo(p1), PRECISION);
            }
        }
    }

    @Test
    @Grade(2)
    public void testDistanceTo_computedCorrectly() {
        int i = 0;
        for (Point p1 : samplePoints) {
            for (Point p2 : samplePoints) {
                assertEquals("distance from [" + p1 + "] to [" + p2 + "]: ",
                        expectedDistances[i++], p1.distanceTo(p2), PRECISION);
            }
        }
    }

    @Test
    @Grade(2)
    public void testCanFormTriangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 4);
        Point p3 = new Point(3, 0);

        Point p4 = new Point(0, 2);

        assertTrue(Point.canFormTriangle(p1, p2, p3));
        assertTrue(Point.canFormTriangle(p1, p3, p2));
        assertTrue(Point.canFormTriangle(p3, p2, p1));

        assertFalse(Point.canFormTriangle(p1, p2, p4));
        assertFalse(Point.canFormTriangle(p1, p4, p2));
        assertFalse(Point.canFormTriangle(p4, p2, p1));
    }

    @Test
    @Grade(2)
    public void testCanFormRightAngledTriangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 4);
        Point p3 = new Point(3, 0);

        Point p4 = new Point(0, 2);

        Point p5 = new Point(4, 2);

        assertTrue(Point.canFormRightAngledTriangle(p1, p2, p3));
        assertTrue(Point.canFormRightAngledTriangle(p1, p3, p2));
        assertTrue(Point.canFormRightAngledTriangle(p3, p2, p1));

        assertFalse(Point.canFormRightAngledTriangle(p1, p2, p4));
        assertFalse(Point.canFormRightAngledTriangle(p1, p4, p2));
        assertFalse(Point.canFormRightAngledTriangle(p4, p2, p1));

        assertFalse(Point.canFormRightAngledTriangle(p1, p2, p5));
        assertFalse(Point.canFormRightAngledTriangle(p1, p5, p2));
        assertFalse(Point.canFormRightAngledTriangle(p5, p2, p1));
    }

    @Test
    @Grade(2)
    public void testCanFormTriangle_trickyCases() {
        Point p1 = new Point(2.5, 2.5);
        Point p2 = new Point(3.2, 3.2);

        //triangle of just 1 point
        assertFalse(Point.canFormTriangle(p1, p1, p1));
        assertFalse(Point.canFormRightAngledTriangle(p1, p1, p1));

        //triangle of just 2 points
        assertFalse(Point.canFormTriangle(p1, p2, p2));
        assertFalse(Point.canFormRightAngledTriangle(p1, p2, p2));
    }

    @Test
    @Grade(1)
    public void testMove() {
        Point p0 = new Point(0, 0);

        Point p1 = new Point(3, 4);
        assertEquals(5, p1.distanceTo(p0), PRECISION);

        p1.move(-3, 0);
        assertEquals(4, p1.distanceTo(p0), PRECISION);

        p1 = new Point(3, 4);
        p1.move(0, -4);
        assertEquals(3, p1.distanceTo(p0), PRECISION);

        p1 = new Point(3, 4);
        p1.move(-3, -11);
        assertEquals(7, p1.distanceTo(p0), PRECISION);

        p1 = new Point(3, 4);
        p1.move(3, -4);
        assertEquals(6, p1.distanceTo(p0), PRECISION);

        p1 = new Point(3, 4);
        p1.move(-13, -4);
        assertEquals(10, p1.distanceTo(p0), PRECISION);
    }

    @Test
    @Grade(1)
    public void testCombinedOps() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(0, 4);
        Point p2 = new Point(3, 0);

        //test some properties of initial points: (distance, can form a right angled triangle)
        assertEquals(5, p1.distanceTo(p2), PRECISION);
        assertTrue(Point.canFormRightAngledTriangle(p0, p1, p2));

        //move them (with exact same amount)
        p0.move(-0.5, -1.5);
        p1.move(-0.5, -1.5);
        p2.move(-0.5, -1.5);

        //test new positions are the the expected ones
        //note: we have NO way to test a point is at some expected coordinates (as we didn't require to have getters),
        //      except by using its distanceTo() method!
        assertEquals(0, p0.distanceTo(new Point(-0.5, -1.5)), 0.0);
        assertEquals(0, p1.distanceTo(new Point(-0.5, 2.5)), 0.0);
        assertEquals(0, p2.distanceTo(new Point(2.5, -1.5)), 0.0);

        //also the initial properties based on distance should remain the same after they were moved in same direction/amount:
        assertEquals(5, p1.distanceTo(p2), PRECISION);
        assertTrue(Point.canFormRightAngledTriangle(p0, p1, p2));

        //further small movement of just 1 point should break the right angled triangle shape:
        p2.move(0, 0.01);
        assertFalse(Point.canFormRightAngledTriangle(p0, p1, p2));
    }
    */
}

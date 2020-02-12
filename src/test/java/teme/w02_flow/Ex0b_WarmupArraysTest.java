package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;
import static teme.w02_flow.Ex0b_WarmupArrays.*;

/**
 * MAX GRADE: 9p
 */
@RunWith(GradeRunner.class)
public class Ex0b_WarmupArraysTest {

    private final double DELTA = 0.0001; //precision using when comparing double values for tests

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(1)
    public void testSum() {
        assertEquals(0, sum(new double[]{}), DELTA);
        assertEquals(-4, sum(new double[]{-4}), DELTA);
        assertEquals(2, sum(new double[]{1, 2, 3, -4}), DELTA);
    }


    @Test
    @Grade(1)
    public void testAvg_emptyArray() {
        double avgEmpty = avg(new double[]{});
        assertTrue(Double.isNaN(avgEmpty) || avgEmpty == 0);
    }

    @Test
    @Grade(1)
    public void testAvg_nonEmptyArray() {
        assertEquals(2, avg(new double[]{2}), DELTA);
        assertEquals(2.75, avg(new double[]{1.1, 2.2, 3.3, 4.4}), DELTA);
    }


    @Test
    @Grade(1)
    public void testMax_emptyArray() {
        assertEquals(Double.NEGATIVE_INFINITY, max(new double[]{}), DELTA);
    }

    @Test
    @Grade(1)
    public void testMax_nonEmptyArray() {
        //one element
        assertEquals(5, max(new double[]{5}), DELTA);
        assertEquals(-4, max(new double[]{-4}), DELTA);
        assertEquals(0, max(new double[]{0}), DELTA);

        //multiple elements
        assertEquals(3, max(new double[]{1, 2, 3, -4}), DELTA);
        assertEquals(4, max(new double[]{1, 2, 3, 4}), DELTA);
        assertEquals(4, max(new double[]{4, 3, 2, 1}), DELTA);
        assertEquals(5, max(new double[]{4, 5, 1, 2, 3}), DELTA);
        assertEquals(6, max(new double[]{4, 3, 2, 6, 5, 1}), DELTA);
        assertEquals(0, max(new double[]{-3, -1, 0, -2}), DELTA);
        assertEquals(-1, max(new double[]{-2, -1, -3}), DELTA);
        assertEquals(-20, max(new double[]{-20, -30}), DELTA);
    }


    @Test
    @Grade(1)
    public void testSumPositives() {
        assertEquals(0, sumPositives(new double[]{}), DELTA);
        assertEquals(0, sumPositives(new double[]{-1, 2, 3}), DELTA);
        assertEquals(6, sumPositives(new double[]{1, 2, 3, -4, 15}), DELTA);
        assertEquals(0, sumPositives(new double[]{-1, 2, 3}), DELTA);
    }

    @Test
    @Grade(1)
    public void testSumPositives_shouldNotStopAtJustZero() {
        assertEquals(10, sumPositives(new double[]{1, 2, 0, 3, 4, -1, 5, 6}), DELTA);
    }


    @Test
    @Grade(1)
    public void testMultiply_emptyArray() {
        double[] arr = {};
        multiply(arr, 2.5);
        assertArrayEquals(new double[]{}, arr, DELTA);
    }

    @Test
    @Grade(1)
    public void testMultiply_nonEmptyArray() {
        double[] arr = {10, 20, 30, 40, 50};
        multiply(arr, 2);
        assertArrayEquals(new double[]{20, 40, 60, 80, 100}, arr, DELTA);
        multiply(arr, 0);
        assertArrayEquals(new double[]{0, 0, 0, 0, 0}, arr, DELTA);
    }
}

package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static teme.w03_recap.Ex7_MatrixIterator.*;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class Ex7_MatrixIteratorTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(3)
    public void testSumAll() {
        assertEquals(0, sumAll(new int[][]{}));
        assertEquals(1, sumAll(new int[][]{{1}}));
        assertEquals(9, sumAll(new int[][]{{9}}));

        assertEquals(10, sumAll(new int[][]{
                {1, 2},
                {3, 4}}));

        assertEquals(45, sumAll(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}));

        assertEquals(26, sumAll(new int[][]{
                {1, 1, 1, 1},
                {1, 2, 3, 1},
                {1, 4, 5, 1},
                {1, 1, 1, 1}}));

        assertEquals(136, sumAll(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}}));
    }

    @Test
    @Grade(3)
    public void testSumDiag1() {
        assertEquals(0, sumDiag1(new int[][]{}));
        assertEquals(1, sumDiag1(new int[][]{{1}}));
        assertEquals(9, sumDiag1(new int[][]{{9}}));

        assertEquals(5, sumDiag1(new int[][]{
                {1, 2},
                {3, 4}}));

        assertEquals(15, sumDiag1(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}));

        assertEquals(9, sumDiag1(new int[][]{
                {1, 1, 1, 1},
                {1, 2, 3, 1},
                {1, 4, 5, 1},
                {1, 1, 1, 1}}));

        assertEquals(34, sumDiag1(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}}));
    }

    @Test
    @Grade(4)
    public void testElementsDiag2() {
        assertArrayEquals(new int[]{}, elementsDiag2(new int[][]{}));
        assertArrayEquals(new int[]{1}, elementsDiag2(new int[][]{{1}}));
        assertArrayEquals(new int[]{9}, elementsDiag2(new int[][]{{9}}));

        assertArrayEquals(new int[]{2, 3}, elementsDiag2(new int[][]{
                {1, 2},
                {3, 4}}));

        assertArrayEquals(new int[]{3, 5, 7}, elementsDiag2(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}));

        assertArrayEquals(new int[]{1, 3, 4, 1}, elementsDiag2(new int[][]{
                {1, 1, 1, 1},
                {1, 2, 3, 1},
                {1, 4, 5, 1},
                {1, 1, 1, 1}}));

        assertArrayEquals(new int[]{4, 7, 10, 13}, elementsDiag2(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}}));
    }

    @Test
    @Grade(3)
    public void optional_testSumPerimeter() {
        assertEquals(0, sumPerimeter(new int[][]{}));
        assertEquals(1, sumPerimeter(new int[][]{{1}}));

        assertEquals(10, sumPerimeter(new int[][]{
                {1, 2},
                {3, 4}}));

        assertEquals(40, sumPerimeter(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}));

        assertEquals(12, sumPerimeter(new int[][]{
                {1, 1, 1, 1},
                {1, 2, 3, 1},
                {1, 4, 5, 1},
                {1, 1, 1, 1}}));

        assertEquals(102, sumPerimeter(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}}));
    }
}
package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;
import static teme.w03_recap.Ex1_ArrayOperations.*;

/**
 * MAX GRADE: 14p
 */
@RunWith(GradeRunner.class)
public class Ex1_ArrayOperationsTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(2)
    public void appendTest() {
        assertArrayEquals(new int[]{1}, append(new int[]{}, 1));
        assertArrayEquals(new int[]{1, 2, 3, 4}, append(new int[]{1, 2, 3}, 4));
    }

    @Test
    @Grade(2)
    public void removeLastTest() {
        assertArrayEquals(new int[]{1, 2, 3}, removeLast(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{}, removeLast(new int[]{1}));
    }

    @Test
    @Grade(2)
    public void removeLastTest_empty() {
        assertArrayEquals(new int[]{}, removeLast(new int[]{}));
    }

    @Test
    @Grade(2)
    public void concatTest() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, concat(new int[]{1, 2}, new int[]{3, 4}));
        assertArrayEquals(new int[]{1, 2}, concat(new int[]{1, 2}, new int[]{}));
        assertArrayEquals(new int[]{3, 4}, concat(new int[]{}, new int[]{3, 4}));
        assertArrayEquals(new int[]{1, 3}, concat(new int[]{1}, new int[]{3}));
        assertArrayEquals(new int[]{}, concat(new int[]{}, new int[]{}));
    }

    @Test
    @Grade(2)
    public void containsTest() {
        assertTrue(contains(new int[]{1}, 1));
        assertTrue(contains(new int[]{1, 2, 3}, 1));
        assertTrue(contains(new int[]{1, 2, 3}, 3));

        assertFalse(contains(new int[]{}, 1));
        assertFalse(contains(new int[]{1}, 7));
        assertFalse(contains(new int[]{1, 2, 3}, 7));
    }

    @Test
    @Grade(2)
    public void indexOfTest() {
        assertEquals(0, indexOf(new int[]{1}, 1));
        assertEquals(0, indexOf(new int[]{1, 2, 3}, 1));
        assertEquals(2, indexOf(new int[]{1, 2, 3}, 3));
        assertEquals(-1, indexOf(new int[]{}, 1));
        assertEquals(-1, indexOf(new int[]{1}, 7));
        assertEquals(-1, indexOf(new int[]{1, 2, 3}, 7));
    }

    @Test
    @Grade(2)
    public void optional_lastIndexOfTest() {
        assertEquals(0, lastIndexOf(new int[]{1}, 1));
        assertEquals(2, lastIndexOf(new int[]{1, 2, 1, 3}, 1));
        assertEquals(4, lastIndexOf(new int[]{1, 2, 3, 2, 3}, 3));
        assertEquals(-1, lastIndexOf(new int[]{}, 1));
        assertEquals(-1, lastIndexOf(new int[]{1}, 7));
        assertEquals(-1, lastIndexOf(new int[]{1, 2, 3, 1}, 7));
    }

    @Test
    @Grade(2)
    public void filterPositivesTest() {
        assertArrayEquals(new int[]{}, filterPositives(new int[]{}));
        assertArrayEquals(new int[]{}, filterPositives(new int[]{-10}));
        assertArrayEquals(new int[]{10}, filterPositives(new int[]{10}));
        assertArrayEquals(new int[]{30}, filterPositives(new int[]{-10, -20, 30}));
        assertArrayEquals(new int[]{10, 30, 50}, filterPositives(new int[]{10, -20, 30, -40, 50, -60}));
        assertArrayEquals(new int[]{10, 20, 30, 40, 50}, filterPositives(new int[]{10, 20, 30, 40, 50}));
    }
}
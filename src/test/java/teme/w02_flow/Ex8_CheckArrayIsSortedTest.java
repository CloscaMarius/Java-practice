package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w02_flow.Ex8_CheckArrayIsSorted.isSorted;

/**
 * MAX GRADE: 8p
 */
@RunWith(GradeRunner.class)
public class Ex8_CheckArrayIsSortedTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(2)
    public void testCheckSorted_basicArray() {
        assertTrue(isSorted(new int[]{}));
        assertTrue(isSorted(new int[]{1}));
    }

    @Test
    @Grade(2)
    public void testCheckSorted_sortedArray() {
        assertTrue(isSorted(new int[]{1, 2}));
        assertTrue(isSorted(new int[]{1, 4, 6}));
    }

    @Test
    @Grade(2)
    public void testCheckSorted_notSortedArray() {
        assertFalse(isSorted(new int[]{3, 2, 1}));
        assertFalse(isSorted(new int[]{1, 2, 4, 3}));
        assertFalse(isSorted(new int[]{1, 2, 4, 3, 5}));
    }

    @Test
    @Grade(2)
    public void testCheckSorted_someEqualElements() {
        assertTrue(isSorted(new int[]{1, 2, 2}));
        assertTrue(isSorted(new int[]{1, 2, 2, 3}));
        assertFalse(isSorted(new int[]{2, 3, 3, 1}));
        assertFalse(isSorted(new int[]{3, 3, 2}));
        assertFalse(isSorted(new int[]{3, 3, 2, 2}));
    }
}

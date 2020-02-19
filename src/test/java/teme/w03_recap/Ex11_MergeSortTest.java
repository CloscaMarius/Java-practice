package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * MAX GRADE: +15
 */
@RunWith(GradeRunner.class)
public class Ex11_MergeSortTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(2)
    public void testSort_basic() {
        assertEquals("[]", sorted(new int[]{}));
        assertEquals("[1]", sorted(new int[]{1}));
    }

    @Test
    @Grade(2)
    public void testSort_alreadySorted() {
        assertEquals("[1, 2]", sorted(new int[]{1, 2}));
        assertEquals("[1, 2, 3]", sorted(new int[]{1, 2, 3}));
    }

    @Test
    @Grade(2)
    public void testSort_reverseSorted() {
        assertEquals("[1, 2]", sorted(new int[]{2, 1}));
        assertEquals("[1, 2, 3]", sorted(new int[]{3, 2, 1}));
        assertEquals("[1, 5, 10, 15]", sorted(new int[]{15, 10, 5, 1}));
    }

    @Test
    @Grade(8)
    public void testSort_mixed() {
        assertEquals("[1, 2, 3]", sorted(new int[]{1, 3, 2}));
        assertEquals("[1, 2, 3, 4]", sorted(new int[]{1, 3, 2, 4}));
        assertEquals("[1, 2, 3, 4]", sorted(new int[]{3, 4, 1, 2}));
        assertEquals("[1, 2, 3, 4, 5]", sorted(new int[]{5, 4, 3, 2, 1}));
        assertEquals("[1, 2, 3, 4, 5]", sorted(new int[]{5, 2, 3, 1, 4}));
        assertEquals("[1, 2, 3, 4, 5, 6]", sorted(new int[]{5, 3, 4, 1, 2, 6}));
        assertEquals("[-237, -85, 3, 17, 29, 78, 834]", sorted(new int[]{3, 78, -85, -237, 834, 17, 29}));
    }

    @Test
    @Grade(1)
    public void testSort_duplicates() {
        assertEquals("[1, 1, 2, 2, 3, 3]", sorted(new int[]{2, 1, 3, 1, 3, 2}));
    }

    //helper function: sorts an array and returns it as String (easier to use in asserts)
    private static String sorted(int[] arr) {
        return Arrays.toString(Ex11_MergeSort.sort(arr));
    }
}
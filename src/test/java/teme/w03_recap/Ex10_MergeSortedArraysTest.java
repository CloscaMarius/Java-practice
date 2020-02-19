package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertArrayEquals;
import static teme.w03_recap.Ex10_MergeSortedArrays.merge;

/**
 * MAX GRADE: 15p
 */
@RunWith(GradeRunner.class)
public class Ex10_MergeSortedArraysTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(1)
    public void testMerge_bothEmpty() {
        assertArrayEquals(new int[]{}, merge(new int[]{}, new int[]{}));
    }

    @Test
    @Grade(2)
    public void testMerge_oneEmpty() {
        assertArrayEquals(new int[]{1}, merge(new int[]{}, new int[]{1}));
        assertArrayEquals(new int[]{1}, merge(new int[]{1}, new int[]{}));

        assertArrayEquals(new int[]{1, 2}, merge(new int[]{1, 2}, new int[]{}));
        assertArrayEquals(new int[]{1, 2}, merge(new int[]{}, new int[]{1, 2}));
    }

    @Test
    @Grade(2)
    public void testMerge_singleElement() {
        assertArrayEquals(new int[]{1, 2}, merge(new int[]{1}, new int[]{2}));
        assertArrayEquals(new int[]{1, 2}, merge(new int[]{2}, new int[]{1}));
    }

    @Test
    @Grade(2)
    public void testMerge_likeConcat() {
        assertArrayEquals(new int[]{1, 2, 3}, merge(new int[]{1}, new int[]{2, 3}));
        assertArrayEquals(new int[]{1, 2, 3}, merge(new int[]{1, 2}, new int[]{3}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, merge(new int[]{1, 2}, new int[]{3, 4}));
    }

    @Test
    @Grade(6)
    public void testMerge_mixed() {
        assertArrayEquals(new int[]{1, 2, 3}, merge(new int[]{3}, new int[]{1, 2}));
        assertArrayEquals(new int[]{1, 2, 3, 4}, merge(new int[]{1, 2, 4}, new int[]{3}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, merge(new int[]{1, 3, 5}, new int[]{2, 4}));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6}, merge(new int[]{1, 3, 5}, new int[]{0, 2, 4, 6}));
    }

    @Test
    @Grade(2)
    public void testMerge_duplicates() {
        assertArrayEquals(new int[]{1, 1, 2, 2, 3, 3}, merge(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }
}

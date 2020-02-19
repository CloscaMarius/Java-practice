package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w03_recap.Ex8_BinarySearch.contains;
import static teme.w03_recap.Ex8_BinarySearch.containsRecStart;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class Ex8_BinarySearchTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    private static final int[] BIG_TEST_ARRAY = new int[10_000_001];

    static {
        for (int i = 0; i < BIG_TEST_ARRAY.length; i++) {
            BIG_TEST_ARRAY[i] = i * 2;
        }
    }

    @Test
    @Grade(2)
    public void testFound() {
        assertTrue(contains(2, new int[]{2}));
        assertTrue(contains(2, new int[]{2, 3}));
        assertTrue(contains(3, new int[]{2, 3, 4}));
        assertTrue(contains(4, new int[]{2, 3, 4}));
        assertTrue(contains(4, new int[]{1, 2, 3, 4, 5}));

        assertTrue(contains(2, BIG_TEST_ARRAY));
        assertTrue(contains(2000, BIG_TEST_ARRAY));
        assertTrue(contains(2_000_000, BIG_TEST_ARRAY));
        assertTrue(contains(20_000_000, BIG_TEST_ARRAY));
    }

    @Test
    @Grade(3)
    public void testNotFound() {
        assertFalse(contains(1, new int[]{}));
        assertFalse(contains(1, new int[]{2}));
        assertFalse(contains(1, new int[]{2, 3}));
        assertFalse(contains(2, new int[]{1, 3}));
        assertFalse(contains(0, new int[]{1, 3, 5}));
        assertFalse(contains(7, new int[]{1, 2, 3, 4, 5}));

        assertFalse(contains(1, BIG_TEST_ARRAY));
        assertFalse(contains(1001, BIG_TEST_ARRAY));
        assertFalse(contains(2_000_001, BIG_TEST_ARRAY));
        assertFalse(contains(19_999_999, BIG_TEST_ARRAY));
        assertFalse(contains(20_000_001, BIG_TEST_ARRAY));
    }

    @Test
    @Grade(2)
    public void testRecFound() {
        assertTrue(containsRecStart(2, new int[]{2}));
        assertTrue(containsRecStart(2, new int[]{2, 3}));
        assertTrue(containsRecStart(3, new int[]{2, 3, 4}));
        assertTrue(containsRecStart(4, new int[]{2, 3, 4}));
        assertTrue(containsRecStart(4, new int[]{1, 2, 3, 4, 5}));

        assertTrue(contains(2, BIG_TEST_ARRAY));
        assertTrue(contains(2000, BIG_TEST_ARRAY));
        assertTrue(contains(2_000_000, BIG_TEST_ARRAY));
        assertTrue(contains(20_000_000, BIG_TEST_ARRAY));
    }

    @Test
    @Grade(3)
    public void testRecNotFound() {
        assertFalse(containsRecStart(1, new int[]{}));
        assertFalse(containsRecStart(1, new int[]{2}));
        assertFalse(containsRecStart(1, new int[]{2, 3}));
        assertFalse(containsRecStart(2, new int[]{1, 3}));
        assertFalse(containsRecStart(0, new int[]{1, 3, 5}));
        assertFalse(containsRecStart(7, new int[]{1, 2, 3, 4, 5}));

        assertFalse(contains(1, BIG_TEST_ARRAY));
        assertFalse(contains(1001, BIG_TEST_ARRAY));
        assertFalse(contains(2_000_001, BIG_TEST_ARRAY));
        assertFalse(contains(19_999_999, BIG_TEST_ARRAY));
        assertFalse(contains(20_000_001, BIG_TEST_ARRAY));
    }
}

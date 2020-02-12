package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w02_flow.Ex10_ConsecutiveRepeats.onlyConsecutiveRepeating;

/**
 * MAX GRADE: +15p
 */
@RunWith(GradeRunner.class)
public class Ex10_ConsecutiveRepeatsTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(3)
    public void testNoSequences() {
        assertEquals("", onlyConsecutiveRepeating(new int[]{}));
        assertEquals("", onlyConsecutiveRepeating(new int[]{1}));
        assertEquals("", onlyConsecutiveRepeating(new int[]{1, 2, 1}).trim());
    }

    @Test
    @Grade(3)
    public void testSimpleSequences() {
        assertEquals("-1", onlyConsecutiveRepeating(new int[]{-1, -1}).trim());
        assertEquals("0", onlyConsecutiveRepeating(new int[]{0, 0}).trim());
        assertEquals("1", onlyConsecutiveRepeating(new int[]{1, 1}).trim());
        assertEquals("1", onlyConsecutiveRepeating(new int[]{1, 1, 2, 3}).trim());
        assertEquals("2", onlyConsecutiveRepeating(new int[]{1, 2, 2, 3}).trim());
        assertEquals("3", onlyConsecutiveRepeating(new int[]{1, 2, 3, 3}).trim());
        assertEquals("1 3", onlyConsecutiveRepeating(new int[]{1, 1, 2, 3, 3}).trim());
        assertEquals("0 2 3", onlyConsecutiveRepeating(new int[]{0, 0, 1, 2, 2, 3, 3, 4}).trim());
    }

    @Test
    @Grade(3)
    public void testLongerSequences() {
        assertEquals("1", onlyConsecutiveRepeating(new int[]{1, 1, 1}).trim());
        assertEquals("1", onlyConsecutiveRepeating(new int[]{0, 1, 1, 1, 3}).trim());
        assertEquals("1", onlyConsecutiveRepeating(new int[]{1, 1, 1, 1, 2}).trim());
        assertEquals("1", onlyConsecutiveRepeating(new int[]{0, 1, 1, 1, 1}).trim());
        assertEquals("1", onlyConsecutiveRepeating(new int[]{0, 1, 1, 1, 1, 1, 3}).trim());
    }

    @Test
    @Grade(3)
    public void testTwoDifferentConsecutiveSequencesWithSameValue() {
        assertEquals("1 1", onlyConsecutiveRepeating(new int[]{1, 1, 2, 1, 1}).trim());
        assertEquals("1 1", onlyConsecutiveRepeating(new int[]{1, 0, 1, 1, 1, 2, 1, 1, 1, 1, 3, 1}).trim());
    }

    @Test
    @Grade(3)
    public void testMultipleSequences() {
        assertEquals("4 5 4", onlyConsecutiveRepeating(new int[]{1, 4, 4, 4, 3, 5, 5, 4, 4}).trim());
        assertEquals("4 2 9", onlyConsecutiveRepeating(new int[]{1, 4, 4, 4, 4, 4, 5, 7, 8, 7, 2, 2, 9, 9, 9}).trim());
    }
}

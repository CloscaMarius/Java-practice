package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;
import static teme.w01_intro.Ex0_WarmupIntro.*;

/*
 * Automatic (unit) tests for methods of Ex0 class.
 * <p>
 * - You can run all these tests by: right-click on class / 'Run..' option
 * - You should complete/fix your code (in Ex0 class) until all these tests pass with success! (are green on run)
 */

/**
 * MAX GRADE: 11p
 */
@RunWith(GradeRunner.class)
public class Ex0_WarmupIntroTest {

    private static final double DELTA = 0.0001; //precision used when comparing actual/expected values of type double

    @Test
    @Grade(1)
    public void testSum() {
        assertEquals(3, computeSum(1, 2));
        assertEquals(0, computeSum(10000, -10000));
    }

    @Test
    @Grade(1)
    public void testSquare() {
        assertEquals(9, squareValue(3), DELTA);
        assertEquals(25, squareValue(-5), DELTA);
        assertEquals(0.01, squareValue(-0.1), DELTA);
    }

    @Test
    @Grade(1)
    public void testJoin() {
        assertEquals("abcd", joinStrings("ab", "cd"));
        assertEquals("abc", joinStrings("abc", ""));
        assertEquals("abab", joinStrings("ab", "ab"));
    }

    @Test
    @Grade(1)
    public void testLengthOf() {
        assertEquals(0, lengthOf(""));
        assertEquals(3, lengthOf("abc"));
    }

    @Test
    @Grade(1)
    public void testTruncate() {
        assertEquals(3, truncate(3.123));
        assertEquals(2, truncate(2.999));
    }

    @Test
    @Grade(1)
    public void testIsInInterval() {
        assertTrue(isInInterval(3, 0, 3));
        assertTrue(isInInterval(0, 0, 3));
        assertTrue(isInInterval(1, 0, 3));
        assertFalse(isInInterval(3, 4, 5));
        assertFalse(isInInterval(3, 0, 2));
    }

    @Test
    @Grade(1)
    public void testSameLength() {
        assertTrue(sameLength("abc", "123"));
        assertFalse(sameLength("ab", "1234"));
    }

    @Test
    @Grade(1)
    public void testAtLeastOneTrue() {
        assertFalse(atLeastOneTrue(false, false, false));

        assertTrue(atLeastOneTrue(true, false, false));
        assertTrue(atLeastOneTrue(false, true, false));
        assertTrue(atLeastOneTrue(false, false, true));
        assertTrue(atLeastOneTrue(true, false, true));
        assertTrue(atLeastOneTrue(true, true, true));
    }

    @Test
    @Grade(1)
    public void testAllTrue() {
        assertFalse(allTrue(false, false, false));
        assertFalse(allTrue(true, false, false));
        assertFalse(allTrue(true, false, true));
        assertFalse(allTrue(true, true, false));

        assertTrue(allTrue(true, true, true));
    }

    @Test
    @Grade(1)
    public void testNoneTrue() {
        assertFalse(noneTrue(true, false, false));
        assertFalse(noneTrue(false, false, true));
        assertFalse(noneTrue(true, true, false));
        assertFalse(noneTrue(true, true, true));

        assertTrue(noneTrue(false, false, false));
    }

    @Test
    @Grade(1)
    public void testExactlyTwoTrue() {
        assertFalse(exactlyTwoTrue(false, false, false));
        assertFalse(exactlyTwoTrue(true, false, false));
        assertFalse(exactlyTwoTrue(false, false, true));
        assertFalse(exactlyTwoTrue(true, true, true));

        assertTrue(exactlyTwoTrue(true, true, false));
        assertTrue(exactlyTwoTrue(true, false, true));
        assertTrue(exactlyTwoTrue(false, true, true));
    }
}

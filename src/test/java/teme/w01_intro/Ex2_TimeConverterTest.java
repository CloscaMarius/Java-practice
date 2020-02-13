package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w01_intro.Ex2_TimeConverter.convertToMilliseconds;

/**
 * MAX GRADE: 8p
 */
@RunWith(GradeRunner.class)
public class Ex2_TimeConverterTest {

    @Test
    @Grade(2)
    public void testRangeValidations() {
        assertEquals(-1, convertToMilliseconds(-1, 0, 0));
        assertEquals(-1, convertToMilliseconds(24, 0, 0));
        assertEquals(-1, convertToMilliseconds(0, -1, 0));
        assertEquals(-1, convertToMilliseconds(0, 60, 0));
        assertEquals(-1, convertToMilliseconds(0, 0, -1));
        assertEquals(-1, convertToMilliseconds(0, 0, 60));
    }

    @Test
    @Grade(1)
    public void testZero() {
        assertEquals(0, convertToMilliseconds(0, 0, 0));
    }

    @Test
    @Grade(1)
    public void testJustSeconds() {
        assertEquals(1_000, convertToMilliseconds(0, 0, 1));
        assertEquals(30_000, convertToMilliseconds(0, 0, 30));
        assertEquals(59_000, convertToMilliseconds(0, 0, 59));
    }

    @Test
    @Grade(1)
    public void testJustMinutes() {
        assertEquals(60_000, convertToMilliseconds(0, 1, 0));
        assertEquals(300_000, convertToMilliseconds(0, 5, 0));
    }

    @Test
    @Grade(1)
    public void testJustHours() {
        assertEquals(3_600_000, convertToMilliseconds(1, 0, 0));
        assertEquals(7_200_000, convertToMilliseconds(2, 0, 0));
        assertEquals(82_800_000, convertToMilliseconds(23, 0, 0));
    }

    @Test
    @Grade(2)
    public void testCombined() {
        assertEquals(3_723_000, convertToMilliseconds(1, 2, 3));
        assertEquals(18_367_000, convertToMilliseconds(5, 6, 7));
        assertEquals(86_399_000, convertToMilliseconds(23, 59, 59));
    }
}

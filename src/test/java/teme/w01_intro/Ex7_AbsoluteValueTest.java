package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;

/**
 * MAX GRADE: 6p
 */
@RunWith(GradeRunner.class)
public class Ex7_AbsoluteValueTest {

    private static final double DELTA = 0.0001; //precision to use when comparing double values in asserts

    @Test
    @Grade(2)
    public void testAbs_positive() {
        assertEquals(7, Ex7_AbsoluteValue.abs(7), DELTA);
        assertEquals(0.5, Ex7_AbsoluteValue.abs(0.5), DELTA);
    }

    @Test
    @Grade(1)
    public void testAbs_zero() {
        assertEquals(0.0, Ex7_AbsoluteValue.abs(0.0), DELTA);
    }

    @Test
    @Grade(3)
    public void testAbs_negative() {
        assertEquals(12, Ex7_AbsoluteValue.abs(-12), DELTA);
        assertEquals(0.25, Ex7_AbsoluteValue.abs(-0.25), DELTA);
    }
}

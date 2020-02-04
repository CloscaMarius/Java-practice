package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w01_intro.Ex8_DigitRemover.removeMiddleDigit;

/**
 * MAX GRADE: 7p
 */
@RunWith(GradeRunner.class)
public class Ex8_DigitRemoverTest {

    @Test
    @Grade(3)
    public void testRemoveMiddleDigit_forInvalidValues() {
        assertEquals(-1, removeMiddleDigit(0));
        assertEquals(-1, removeMiddleDigit(9_999));
        assertEquals(-1, removeMiddleDigit(100_000));
        assertEquals(-1, removeMiddleDigit(-12_345));
    }

    @Test
    @Grade(4)
    public void testRemoveMiddleDigit_forValidValues() {
        assertEquals(1245, removeMiddleDigit(12345));
        assertEquals(1000, removeMiddleDigit(10000));
    }
}

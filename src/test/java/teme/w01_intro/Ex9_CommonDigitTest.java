package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w01_intro.Ex9_CommonDigit.haveACommonDigit;
import static teme.w01_intro.Ex9_CommonDigit.isValid;

/**
 * MAX GRADE: 7p
 */
@RunWith(GradeRunner.class)
public class Ex9_CommonDigitTest {

    @Test
    @Grade(3)
    public void testIsValid() {
        assertFalse(isValid(-90));
        assertFalse(isValid(12));
        assertTrue(isValid(13));
        assertTrue(isValid(89));
        assertFalse(isValid(90));
        assertFalse(isValid(999));
    }

    @Test
    @Grade(4)
    public void testCommonDigit() {
        assertFalse(haveACommonDigit(12, 22)); //x outside range
        assertFalse(haveACommonDigit(90, 29)); //x outside range
        assertFalse(haveACommonDigit(19, 90)); //y outside range
        assertFalse(haveACommonDigit(13, 89)); //no common digit

        assertTrue(haveACommonDigit(18, 28));
        assertTrue(haveACommonDigit(17, 72));
        assertTrue(haveACommonDigit(73, 47));
        assertTrue(haveACommonDigit(70, 71));
        assertTrue(haveACommonDigit(42, 24));
    }
}

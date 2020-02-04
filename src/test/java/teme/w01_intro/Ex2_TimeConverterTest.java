package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static teme.w01_intro.Ex2_TimeConverter.convertToMilliseconds;

/**
 * MAX GRADE: 8p
 */
@RunWith(GradeRunner.class)
public class Ex2_TimeConverterTest {

    @Test
    @Grade(2)
    public void testRangeValidation_invalidValuesReturnMinusOne() {
        assertEquals(-1, convertToMilliseconds(-1, 0, 0));
        assertEquals(-1, convertToMilliseconds(24, 0, 0));
        assertEquals(-1, convertToMilliseconds(0, -1, 0));
        assertEquals(-1, convertToMilliseconds(0, 60, 0));
        assertEquals(-1, convertToMilliseconds(0, 0, -1));
        assertEquals(-1, convertToMilliseconds(0, 0, 60));
    }

    @Test
    @Grade(1)
    public void testRangeValidation_validValuesDoNotReturnMinusOne() {
        assertNotEquals(-1, convertToMilliseconds(0, 0, 0));
        assertNotEquals(-1, convertToMilliseconds(23, 59, 59));
    }

    @Test
    @Grade(5)
    public void testConversionOfValidValues() {
        assertEquals(0, convertToMilliseconds(0, 0, 0));
        assertEquals(7_200_000, convertToMilliseconds(2, 0, 0));
        assertEquals(180_000, convertToMilliseconds(0, 3, 0));
        assertEquals(4_000, convertToMilliseconds(0, 0, 4));
        assertEquals(18_367_000, convertToMilliseconds(5, 6, 7));
        assertEquals(86_399_000, convertToMilliseconds(23, 59, 59));
    }
}

package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w01_intro.Ex3_HeightConverter.convertToCentimeters;
import static teme.w01_intro.Ex3_HeightConverter.convertToFeetAndInches;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class Ex3_HeightConverterTest {

    @Test
    @Grade(2)
    public void testConvertInchesToCentimeters() {
        assertEquals(0, convertToCentimeters(0, 0));
        assertEquals(254, convertToCentimeters(0, 100));
        assertEquals(7, convertToCentimeters(0, 3));
    }

    @Test
    @Grade(3)
    public void testConvertFeetAndInchesToCentimeters() {
        assertEquals(254, convertToCentimeters(8, 4));
        assertEquals(60, convertToCentimeters(2, 0));
        assertEquals(104, convertToCentimeters(3, 5));
    }

    @Test
    @Grade(2)
    public void testConvertCentimetersToInches() {
        assertEquals("0 feet, 0 inches", convertToFeetAndInches(0));
        assertEquals("0 feet, 10 inches", convertToFeetAndInches(26));
    }

    @Test
    @Grade(3)
    public void testConvertCentimetersToFeetAndInches() {
        assertEquals("2 feet, 0 inches", convertToFeetAndInches(61));
        assertEquals("3 feet, 8 inches", convertToFeetAndInches(112));
    }
}

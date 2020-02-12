package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w02_flow.Ex4_DecimalToBinary.decimalToBinary;

/**
 * MAX GRADE: +15p
 */
@RunWith(GradeRunner.class)
public class Ex4_DecimalToBinaryTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(4)
    public void testBinaryConversion_basicNumbers() {
        assertEquals("0", decimalToBinary(0));
        assertEquals("1", decimalToBinary(1));
    }

    @Test
    @Grade(4)
    public void testBinaryConversion_mediumNumbers() {
        assertEquals("10", decimalToBinary(2));
        assertEquals("11", decimalToBinary(3));
        assertEquals("100", decimalToBinary(4));
        assertEquals("1000", decimalToBinary(8));
        assertEquals("1010", decimalToBinary(10));
    }

    @Test
    @Grade(4)
    public void testBinaryConversion_longerNumbers() {
        assertEquals("1111111", decimalToBinary(127));
        assertEquals("101100101", decimalToBinary(357));
    }

    @Test
    @Grade(3)
    public void testBinaryConversion_longestNumber() {
        assertEquals("1111111111111111111111111111111", decimalToBinary(Integer.MAX_VALUE));
    }
}

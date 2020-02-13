package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w02_flow.Ex6_ArrayToString.arrayToString;

/**
 * MAX GRADE: 14p
 */
@RunWith(GradeRunner.class)
public class Ex6_ArrayToStringTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(3)
    public void testArrayToString_emptyArray() {
        assertEquals("[]", arrayToString(new double[]{}));
    }

    @Test
    @Grade(3)
    public void testArrayToString_singleElement() {
        assertEquals("[0.22]", arrayToString(new double[]{0.22}));
        assertEquals("[7.02]", arrayToString(new double[]{7.02}));
        assertEquals("[456.04]", arrayToString(new double[]{456.04}));
        assertEquals("[-1.12]", arrayToString(new double[]{-1.12}));
    }

    @Test
    @Grade(4)
    public void testArrayToString_multipleElements() {
        assertEquals("[1.01, 2.02]", arrayToString(new double[]{1.01, 2.02}));
        assertEquals("[1.11, 2.22, 3.33, 44.44]", arrayToString(new double[]{1.11, 2.22, 3.33, 44.44}));
    }

    @Test
    @Grade(2)
    public void testArrayToString_testRoundingTo2Digits() {
        assertEquals("[2.22]", arrayToString(new double[]{2.224}));
        assertEquals("[2.23]", arrayToString(new double[]{2.225}));
        assertEquals("[2.23]", arrayToString(new double[]{2.226}));
    }

    @Test
    @Grade(2)
    public void testArrayToString_testPaddingTo2Digits() {
        assertEquals("[2.00]", arrayToString(new double[]{2}));
        assertEquals("[2.10]", arrayToString(new double[]{2.1}));
        assertEquals("[-3.00]", arrayToString(new double[]{-3}));
    }
}

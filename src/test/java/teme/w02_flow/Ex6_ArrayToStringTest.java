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
 * MAX GRADE: +20p
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
        assertEquals("[0.00]", arrayToString(new double[]{0}));
        assertEquals("[7.00]", arrayToString(new double[]{7}));
        assertEquals("[456.00]", arrayToString(new double[]{456}));
        assertEquals("[-1.00]", arrayToString(new double[]{-1}));
    }

    @Test
    @Grade(4)
    public void testArrayToString_testRounding() {
        assertEquals("[2.22]", arrayToString(new double[]{2.224}));
        assertEquals("[2.23]", arrayToString(new double[]{2.225}));
        assertEquals("[2.23]", arrayToString(new double[]{2.226}));
    }

    @Test
    @Grade(4)
    public void testArrayToString_multipleElements() {
        assertEquals("[1.00, 2.00]", arrayToString(new double[]{1, 2}));
        assertEquals("[1.11, 2.22, 3.33, 44.44]", arrayToString(new double[]{1.11, 2.22, 3.33, 44.44}));
    }
}

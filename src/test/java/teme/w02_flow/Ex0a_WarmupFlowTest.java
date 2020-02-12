package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static teme.w02_flow.Ex0a_WarmupFlow.*;

/**
 * MAX GRADE: 8p+3p
 */
@RunWith(GradeRunner.class)
public class Ex0a_WarmupFlowTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(1)
    public void testXTimes() {
        assertEquals("", xTimes("", 0));
        assertEquals("", xTimes("abc", 0));
        assertEquals("abcabc", xTimes("abc", 2));
        assertEquals("AAA", xTimes("A", 3));
    }

    @Test
    @Grade(1)
    public void testSumSquares() {
        assertEquals(0, sumSquares(0));
        assertEquals(1, sumSquares(1));
        assertEquals(5, sumSquares(2));
        assertEquals(385, sumSquares(10));
    }


    @Test
    @Grade(1)
    public void testFactorial_valuesUpTo12_usingIntTypeIsEnough() {
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(120, factorial(5));
        assertEquals(3628800, factorial(10));
        assertEquals(479001600, factorial(12));
    }

    @Test
    @Grade(1)
    public void testFactorial_valuesUpTo_16_requireUseOfLongType() {
        assertEquals(6227020800L, factorial(13));
        assertEquals(87178291200L, factorial(14));
        assertEquals(20922789888000L, factorial(16)); //about the max value that still fits in the range for long!
    }

    @Test
    @Grade(1)
    public void testFactorial_shouldNotUseRecursion() {
        try {
            System.out.println(factorial(100_000));
        } catch (StackOverflowError ignore) {
            fail("For big numbers (like 100000), factorial() - the iterative version - is not expected to produce correct results, BUT it should NOT fail with StackOverflowError.\nYour version just fails in this way. Is it really iterative?... (seems recursive to me)\n");
        }
    }

    @Test
    @Grade(1)
    public void testFactorialRec_valuesUpTo12_usingIntTypeIsEnough() {
        assertEquals(1, factorialRec(1));
        assertEquals(2, factorialRec(2));
        assertEquals(120, factorialRec(5));
        assertEquals(3628800, factorialRec(10));
        assertEquals(479001600, factorialRec(12));
    }

    @Test
    @Grade(1)
    public void testFactorialRec_valuesUpTo_16_requireUseOfLongType() {
        assertEquals(6227020800L, factorialRec(13));
        assertEquals(87178291200L, factorialRec(14));
        assertEquals(20922789888000L, factorialRec(16)); //about the max value that still fits in the range for long!
    }

    @Test
    @Grade(1)
    public void testFactorialRec_shouldUseRecursion() {
        try {
            System.out.println(factorialRec(100_000));
            fail("For big numbers (like 100000), factorialRec() - the recursive version - is expected to just fail with StackOverflowError.\nYour version didn't fail like that! Is it really recursive?... (seems iterative to me)\n");
        } catch (StackOverflowError ignore) {
            //ok, expected
        }
    }


    @Test
    @Grade(1)
    public void testDayOfWeek_invalidValues() {
        assertEquals(-1, dayOfWeek("altceva"));
        assertEquals(-1, dayOfWeek(""));
    }

    @Test
    @Grade(1)
    public void testDayOfWeek_lowerCaseOnly() {
        assertEquals(1, dayOfWeek("luni"));
        assertEquals(2, dayOfWeek("marti"));
        assertEquals(3, dayOfWeek("miercuri"));
        assertEquals(4, dayOfWeek("joi"));
        assertEquals(5, dayOfWeek("vineri"));
        assertEquals(6, dayOfWeek("sambata"));
        assertEquals(7, dayOfWeek("duminica"));
    }

    @Test
    @Grade(1)
    public void testDayOfWeek_mixedCase() {
        assertEquals(1, dayOfWeek("LUNI"));
        assertEquals(2, dayOfWeek("Marti"));
        assertEquals(3, dayOfWeek("MiERCURi"));
        assertEquals(4, dayOfWeek("jOi"));
        assertEquals(5, dayOfWeek("VinerI"));
        assertEquals(6, dayOfWeek("SaMbAtA"));
        assertEquals(7, dayOfWeek("Duminica"));
    }
}

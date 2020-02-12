package teme.w02_flow;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.TestUtil;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w02_flow.Ex1_FizzBuzz.fizzBuzz;
import static teme.w02_flow.Ex1_FizzBuzz.printAllFizzBuzzUpTo;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class Ex1_FizzBuzzTest {

    @Test
    @Grade(1)
    public void testFizzBuzz_number() {
        assertEquals("1", fizzBuzz(1));
        assertEquals("2", fizzBuzz(2));
        assertEquals("8", fizzBuzz(8));
    }

    @Test
    @Grade(2)
    public void testFizzBuzz_fizz() {
        assertEquals("fizz", fizzBuzz(3));
        assertEquals("fizz", fizzBuzz(9));
        assertEquals("fizz", fizzBuzz(21));
    }

    @Test
    @Grade(2)
    public void testFizzBuzz_buzz() {
        assertEquals("buzz", fizzBuzz(5));
        assertEquals("buzz", fizzBuzz(10));
        assertEquals("buzz", fizzBuzz(40));
    }

    @Test
    @Grade(2)
    public void testFizzBuzz_fizzbuzz() {
        assertEquals("fizzbuzz", fizzBuzz(15));
        assertEquals("fizzbuzz", fizzBuzz(45));
    }

    @Test
    @Grade(3)
    public void testPrintAllFizzBuzzUpTo() {
        String out = TestUtil.runCapturingOutput(() -> printAllFizzBuzzUpTo(15))
                .trim().replace(System.lineSeparator(), ",").replace(" ", "");
        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", out);
    }
}
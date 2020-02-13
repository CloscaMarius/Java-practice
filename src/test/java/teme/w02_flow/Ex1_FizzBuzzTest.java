package teme.w02_flow;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.util.TestUtil.runCapturingOutput;
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
    @Grade(1)
    public void testPrintAllFizzBuzzUpTo_5() {
        assertEquals("1,2,fizz,4,buzz",
                trimIt(runCapturingOutput(() -> printAllFizzBuzzUpTo(5))));
    }

    @Test
    @Grade(2)
    public void testPrintAllFizzBuzzUpTo_32() {
        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,17,fizz,19,buzz,fizz,22,23,fizz,buzz,26,fizz,28,29,fizzbuzz,31,32",
                trimIt(runCapturingOutput(() -> printAllFizzBuzzUpTo(32))));
    }

    private String trimIt(String out) {
        return out.trim().replace(System.lineSeparator(), ",").replace(" ", "");
    }
}
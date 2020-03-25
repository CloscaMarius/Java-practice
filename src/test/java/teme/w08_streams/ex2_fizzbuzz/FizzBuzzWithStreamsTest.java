package teme.w08_streams.ex2_fizzbuzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.TestUtil;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class FizzBuzzWithStreamsTest {

    @Test
    @Grade(2)
    public void toFizzBuzz() {
        assertEquals("7", FizzBuzzWithStreams.toFizzBuzz(7));
        assertEquals("fizz", FizzBuzzWithStreams.toFizzBuzz(9));
        assertEquals("buzz", FizzBuzzWithStreams.toFizzBuzz(10));
        assertEquals("fizzbuzz", FizzBuzzWithStreams.toFizzBuzz(90));
    }

    @Test
    @Grade(3)
    public void fizzBuzzImperative() {
        String out = TestUtil.runCapturingOutput(() -> FizzBuzzWithStreams.fizzBuzzImperative(15))
                .trim().replace(System.lineSeparator(), ",").replace(" ", "");
        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", out);
    }

    @Test
    @Grade(5)
    public void fizzBuzzWithStreams() {
        String out = TestUtil.runCapturingOutput(() -> FizzBuzzWithStreams.fizzBuzzWithStreams(15))
                .trim().replace(System.lineSeparator(), ",").replace(" ", "");
        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", out);
    }
}

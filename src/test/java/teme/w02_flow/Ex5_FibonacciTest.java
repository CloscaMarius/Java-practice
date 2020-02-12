package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static teme.w02_flow.Ex5_Fibonacci.fibonacci;
import static teme.w02_flow.Ex5_Fibonacci.fibonacciSequence;

/**
 * MAX GRADE: +20p
 */
@RunWith(GradeRunner.class)
public class Ex5_FibonacciTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(4)
    public void fibonacciTest_basicCases() {
        assertEquals(0, fibonacci(0));
        assertEquals(1, fibonacci(1));
    }

    @Test
    @Grade(4)
    public void fibonacciTest_smallNumbers() {
        assertEquals(1, fibonacci(2));
        assertEquals(2, fibonacci(3));
        assertEquals(3, fibonacci(4));
        assertEquals(5, fibonacci(5));
        assertEquals(8, fibonacci(6));
        assertEquals(13, fibonacci(7));
    }

    @Test
    @Grade(4)
    public void fibonacciTest_longerNumbers() {
        assertEquals(89, fibonacci(11));
        assertEquals(10946, fibonacci(21));
        assertEquals(1346269, fibonacci(31));
    }


    @Test
    @Grade(4)
    public void fibonacciSequenceTest_basicCases() {
        assertArrayEquals(new int[]{}, fibonacciSequence(0));
        assertArrayEquals(new int[]{0}, fibonacciSequence(1));
        assertArrayEquals(new int[]{0, 1}, fibonacciSequence(2));
    }

    @Test
    @Grade(4)
    public void fibonacciSequenceTest() {
        assertArrayEquals(new int[]{0, 1, 1, 2}, fibonacciSequence(4));
        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5}, fibonacciSequence(6));

        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040},
                fibonacciSequence(31));
    }
}

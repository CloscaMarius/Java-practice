package teme.w07_comparable.ex4_half_print;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;
import static teme.util.TestUtil.runCapturingOutput;

/**
 * Unit tests for Compute and some Function implementations
 * <p>
 * MAX GRADE: +15p (optional)
 */
@SuppressWarnings({"ConstantConditions", "RedundantCast"})
@RunWith(GradeRunner.class)
public class ComputeTest {

    @Test
    @Grade(3)
    public void testPrintFunction() {
        Function f = (Function) new PrintFunction();
        assertEquals(72, f.evaluate(72));
        assertTrue(runCapturingOutput(() -> f.evaluate(37)).contains("37"));
    }

    @Test
    @Grade(4)
    public void testHalfFunction() {
        Function f = (Function) new HalfFunction();
        assertEquals(0, f.evaluate(0));
        assertEquals(3, f.evaluate(6));
        assertEquals(3, f.evaluate(7));
    }

    @Test
    @Grade(4)
    public void testComputeWithPrint() {
        Compute computer = new Compute();
        Function func = (Function) new PrintFunction();

        int[] values = {10, 20, 30, 40, 50};

        //test returned
        assertArrayEquals(values, computer.compute(values, func));

        //test printed
        String out = runCapturingOutput(() -> computer.compute(values, func));
        for (int i : values) {
            assertTrue(out.contains(String.valueOf(i)));
        }
    }

    @Test
    @Grade(4)
    public void testComputeWithHalf() {
        Compute computer = new Compute();
        Function func = (Function) new HalfFunction();

        int[] values = {10, 20, 30, 40, 50};
        assertArrayEquals(new int[]{5, 10, 15, 20, 25}, computer.compute(values, func));
    }
}

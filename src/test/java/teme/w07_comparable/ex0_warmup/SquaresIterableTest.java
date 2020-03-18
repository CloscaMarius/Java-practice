package teme.w07_comparable.ex0_warmup;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;

/**
 * MAX GRADE: 5p
 */
@RunWith(GradeRunner.class)
public class SquaresIterableTest {

    @Test
    @Grade(5)
    public void iterator() {
        long i = 1;
        for (long sq : new SquaresIterable()) {
            assertEquals(i * i, sq);
            if (sq > 10000) {
                break;
            }
            i++;
        }
    }
}

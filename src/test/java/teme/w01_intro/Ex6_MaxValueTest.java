package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;

/**
 * MAX GRADE: 5p
 */
@RunWith(GradeRunner.class)
public class Ex6_MaxValueTest {

    @Test
    @Grade(2)
    public void testMax_1st() {
        assertEquals(8, Ex6_MaxValue.max(8, 7));
        assertEquals(3, Ex6_MaxValue.max(3, -1));
    }

    @Test
    @Grade(2)
    public void testMax_2nd() {
        assertEquals(3, Ex6_MaxValue.max(2, 3));
        assertEquals(-3, Ex6_MaxValue.max(-5, -3));
    }

    @Test
    @Grade(1)
    public void testMax_equal() {
        assertEquals(7, Ex6_MaxValue.max(7, 7));
        assertEquals(0, Ex6_MaxValue.max(0, 0));
    }
}

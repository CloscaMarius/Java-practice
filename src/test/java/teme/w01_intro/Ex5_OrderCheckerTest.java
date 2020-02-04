package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w01_intro.Ex5_OrderChecker.*;

/**
 * MAX GRADE: 12p
 */
@RunWith(GradeRunner.class)
public class Ex5_OrderCheckerTest {

    @Test
    @Grade(4)
    public void testSortAscending3() {
        assertTrue(numbersAreSortedAscending3(-5, 7, 8));
        assertFalse(numbersAreSortedAscending3(10, 11, 11));
        assertFalse(numbersAreSortedAscending3(2, 8, 7));
    }

    @Test
    @Grade(4)
    public void testSortDescending3() {
        assertTrue(numbersAreSortedDescending3(-5, -7, -8));
        assertFalse(numbersAreSortedDescending3(10, 7, 7));
        assertFalse(numbersAreSortedDescending3(3, 1, 2));
    }

    @Test
    @Grade(4)
    public void testSortDescending9() {
        assertTrue(numbersAreSortedDescending9(9, 8, 7, 6, 5, 4, 3, 2, 1));
        assertFalse(numbersAreSortedDescending9(9, 8, 8, 7, 6, 5, 4, 3, 2));
        assertFalse(numbersAreSortedDescending9(9, 7, 8, 6, 5, 4, 3, 2, 1));
        assertFalse(numbersAreSortedDescending9(3, 2, 1, 9, 8, 7, 6, 5, 4));
        assertFalse(numbersAreSortedDescending9(9, 8, 7, 7, 6, 5, 4, 3, 2));
    }
}

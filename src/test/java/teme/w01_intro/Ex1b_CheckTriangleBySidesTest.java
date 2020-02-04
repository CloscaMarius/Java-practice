package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w01_intro.Ex1b_CheckTriangleBySides.canFormValidRightAngledTriangle;
import static teme.w01_intro.Ex1b_CheckTriangleBySides.canFormValidTriangle;

/**
 * MAX GRADE: 6p
 */
@RunWith(GradeRunner.class)
public class Ex1b_CheckTriangleBySidesTest {

    @Test
    @Grade(1)
    public void test_sides_1_2_4() {
        assertFalse("canFormValidTriangle(1,2,4) should return false", canFormValidTriangle(1, 2, 4));
        assertFalse("canFormValidRightAngledTriangle(1,2,4) should return false", canFormValidRightAngledTriangle(1, 2, 4));

        assertFalse("canFormValidTriangle(1,4,2) should return false", canFormValidTriangle(1, 4, 2));
        assertFalse("canFormValidRightAngledTriangle(1,4,2) should return false", canFormValidRightAngledTriangle(1, 4, 2));

        assertFalse("canFormValidTriangle(4,2,1) should return false", canFormValidTriangle(4, 2, 1));
        assertFalse("canFormValidRightAngledTriangle(4,2,1) should return false", canFormValidRightAngledTriangle(4, 2, 1));
    }

    @Test
    @Grade(1)
    public void test_sides_1_2_2() {
        assertTrue("canFormValidTriangle(1,2,2) should return true", canFormValidTriangle(1, 2, 2));
        assertFalse("canFormValidRightAngledTriangle(1,2,2) should return false", canFormValidRightAngledTriangle(1, 2, 2));

        assertTrue("canFormValidTriangle(2,1,2) should return true", canFormValidTriangle(2, 1, 2));
        assertFalse("canFormValidRightAngledTriangle(2,1,2) should return false", canFormValidRightAngledTriangle(2, 1, 2));

        assertTrue("canFormValidTriangle(2,2,1) should return true", canFormValidTriangle(2, 2, 1));
        assertFalse("canFormValidRightAngledTriangle(2,2,1) should return false", canFormValidRightAngledTriangle(2, 2, 1));
    }

    @Test
    @Grade(2)
    public void test_sides_3_4_5() {
        assertTrue("canFormValidTriangle(3,4,5) should return true", canFormValidTriangle(3, 4, 5));
        assertTrue("canFormValidRightAngledTriangle(3,4,5) should return true", canFormValidRightAngledTriangle(3, 4, 5));

        assertTrue("canFormValidTriangle(5,3,4) should return true", canFormValidTriangle(5, 3, 4));
        assertTrue("canFormValidRightAngledTriangle(5,3,4) should return true", canFormValidRightAngledTriangle(5, 3, 4));

        assertTrue("canFormValidTriangle(4,5,3) should return true", canFormValidTriangle(4, 5, 3));
        assertTrue("canFormValidRightAngledTriangle(4,5,3) should return true", canFormValidRightAngledTriangle(4, 5, 3));
    }

    @Test
    @Grade(1)
    public void test_zero_sides() {
        assertFalse("canFormValidTriangle(0,0,0) should return false", canFormValidTriangle(0, 0, 0));
        assertFalse("canFormValidTriangle(0,0,0) should return false", canFormValidTriangle(0, 0, 0));
    }

    @Test
    @Grade(1)
    public void test_negative_sides_3_4_5() {
        assertFalse("canFormValidTriangle(-3,4,5) should return false", canFormValidTriangle(-3, 4, 5));
        assertFalse("canFormValidTriangle(3,-4,5) should return false", canFormValidTriangle(3, -4, 5));
        assertFalse("canFormValidTriangle(3,4,-5) should return false", canFormValidTriangle(3, 4, -5));
        assertFalse("canFormValidTriangle(-3,-4,-5) should return false", canFormValidTriangle(-3, -4, -5));
        assertFalse("canFormValidRightAngledTriangle(-3,4,5) should return false", canFormValidRightAngledTriangle(-3, 4, 5));
        assertFalse("canFormValidRightAngledTriangle(3,-4,5) should return false", canFormValidRightAngledTriangle(-3, 4, 5));
        assertFalse("canFormValidRightAngledTriangle(3,4,-5) should return false", canFormValidRightAngledTriangle(-3, 4, 5));
        assertFalse("canFormValidRightAngledTriangle(-3,-4,-5) should return false", canFormValidRightAngledTriangle(-3, -4, -5));

        assertFalse("canFormValidTriangle(-5,3,4) should return false", canFormValidTriangle(-5, 3, 4));
        assertFalse("canFormValidTriangle(5,-3,4) should return false", canFormValidTriangle(5, -3, 4));
        assertFalse("canFormValidTriangle(5,3,-4) should return false", canFormValidTriangle(5, 3, -4));
        assertFalse("canFormValidTriangle(-5,-3,-4) should return false", canFormValidTriangle(-5, -3, -4));
        assertFalse("canFormValidRightAngledTriangle(-5,3,4) should return false", canFormValidRightAngledTriangle(-5, 3, 4));
        assertFalse("canFormValidRightAngledTriangle(5,-3,4) should return false", canFormValidRightAngledTriangle(5, -3, 4));
        assertFalse("canFormValidRightAngledTriangle(5,3,-4) should return false", canFormValidRightAngledTriangle(5, 3, -4));
        assertFalse("canFormValidRightAngledTriangle(-5,-3,-4) should return false", canFormValidRightAngledTriangle(-5, -3, -4));

        assertFalse("canFormValidTriangle(-4,5,3) should return false", canFormValidTriangle(-4, 5, 3));
        assertFalse("canFormValidTriangle(4,-5,3) should return false", canFormValidTriangle(4, -5, 3));
        assertFalse("canFormValidTriangle(4,5,-3) should return false", canFormValidTriangle(4, 5, -3));
        assertFalse("canFormValidTriangle(-4,-5,-3) should return false", canFormValidTriangle(-4, -5, -3));
        assertFalse("canFormValidRightAngledTriangle(-4,5,3) should return false", canFormValidRightAngledTriangle(-4, 5, 3));
        assertFalse("canFormValidRightAngledTriangle(4,-5,3) should return false", canFormValidRightAngledTriangle(4, -5, 3));
        assertFalse("canFormValidRightAngledTriangle(4,5,-3) should return false", canFormValidRightAngledTriangle(4, 5, -3));
        assertFalse("canFormValidRightAngledTriangle(-4,-5,-3) should return false", canFormValidRightAngledTriangle(-4, -5, -3));
    }
}

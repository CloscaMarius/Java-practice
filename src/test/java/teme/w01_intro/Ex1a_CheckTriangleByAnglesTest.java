package teme.w01_intro;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w01_intro.Ex1a_CheckTriangleByAngles.canFormValidRightAngledTriangle;
import static teme.w01_intro.Ex1a_CheckTriangleByAngles.canFormValidTriangle;

/**
 * MAX GRADE: 6p
 */
@RunWith(GradeRunner.class)
public class Ex1a_CheckTriangleByAnglesTest {

    @Test
    @Grade(1)
    public void test_angles_10_30_50() {
        assertFalse("canFormValidTriangle(10,30,50) should return false", canFormValidTriangle(10, 30, 50));
        assertFalse("canFormValidRightAngledTriangle(10,30,50) should return false", canFormValidRightAngledTriangle(10, 30, 50));
    }

    @Test
    @Grade(1)
    public void test_angles_90_30_30() {
        assertFalse("canFormValidTriangle(90,30,30) should return false", canFormValidTriangle(90, 30, 30));
        assertFalse("canFormValidRightAngledTriangle(90,30,30) should return false", canFormValidRightAngledTriangle(90, 30, 30));
    }

    @Test
    @Grade(1)
    public void test_angles_60_60_60() {
        assertTrue("canFormValidTriangle(60,60,60) should return true", canFormValidTriangle(60, 60, 60));
        assertFalse("canFormValidRightAngledTriangle(60,60,60) should return false", canFormValidRightAngledTriangle(60, 60, 60));
    }

    @Test
    @Grade(1)
    public void test_angles_30_60_90() {
        assertTrue("canFormValidTriangle(30,60,90) should return true", canFormValidTriangle(30, 60, 90));
        assertTrue("canFormValidRightAngledTriangle(30,60,90) should return true", canFormValidRightAngledTriangle(30, 60, 90));

        assertTrue("canFormValidTriangle(20,90,70) should return true", canFormValidTriangle(20, 90, 70));
        assertTrue("canFormValidRightAngledTriangle(20, 90, 70) should return true", canFormValidRightAngledTriangle(20, 90, 70));
    }

    @Test
    @Grade(1)
    public void test_tricky_cases_zero_angels() {
        assertFalse("canFormValidTriangle(0,90,90) should return false", canFormValidTriangle(0, 90, 90));
        assertFalse("canFormValidRightAngledTriangle(0,90,90) should return false", canFormValidRightAngledTriangle(0, 90, 90));
    }

    @Test
    @Grade(1)
    public void test_tricky_cases_negative_angels() {
        assertFalse("canFormValidTriangle(-30,60,90) should return false", canFormValidTriangle(-30, 60, 90));
        assertFalse("canFormValidTriangle(-30,120,90) should return false", canFormValidTriangle(-30, 120, 90));
        assertFalse("canFormValidRightAngledTriangle(-30,60,90) should return false", canFormValidRightAngledTriangle(-30, 60, 90));
        assertFalse("canFormValidRightAngledTriangle(-30,120,90) should return false", canFormValidRightAngledTriangle(-30, 120, 90));
    }
}

package teme.w04_oop1.ex0_time;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 28p
 */
@RunWith(GradeRunner.class)
public class TimeTest {

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        assertEquals("", "");
        assertTrue(true);
        //fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    @Test
    @Grade(2)
    public void testBuildTime() {

        Time t1 = new Time(0, 0, 0);
        assertEquals(0, t1.getHours());
        assertEquals(0, t1.getMinutes());
        assertEquals(0, t1.getSeconds());

        Time t2 = new Time(1, 2, 3);
        assertEquals(1, t2.getHours());
        assertEquals(2, t2.getMinutes());
        assertEquals(3, t2.getSeconds());
    }

    @Test
    @Grade(2)
    public void testToString() {
        assertEquals("1:2:3", new Time(1, 2, 3).toString());
    }

    @Test
    @Grade(3)
    public void testNegativeValues() {
        assertEquals("0:2:3", new Time(-1, 2, 3).toString());
        assertEquals("1:0:3", new Time(1, -2, 3).toString());
        assertEquals("1:2:0", new Time(1, 2, -3).toString());
    }

    @Test
    @Grade(2)
    public void testConstructorWithoutParams() {
        Time t3 = new Time();
        assertEquals(23, t3.getHours());
        assertEquals(59, t3.getMinutes());
        assertEquals(59, t3.getSeconds());
    }

    @Test
    @Grade(3)
    public void testSecondsSinceMidnight() {
        Time t1 = new Time(0, 0, 0);
        assertEquals(0, t1.secondsSinceMidnight());

        Time t2 = new Time(1, 2, 3);
        assertEquals(3723, t2.secondsSinceMidnight());
    }

    @Test
    @Grade(3)
    public void testSecondsSince() {
        Time t1 = new Time(1, 2, 3);
        Time t2 = new Time(2, 30, 45);
        assertEquals(5322, t2.secondsSince(t1));
        assertEquals(-5322, t1.secondsSince(t2));
    }

    @Test
    @Grade(3)
    public void testCreateInstancesCounter() {
        Time.createInstancesCounter = 0;

        new Time(0, 0, 0);
        assertEquals(1, Time.createInstancesCounter);

        new Time(1, 2, 3);
        assertEquals(2, Time.createInstancesCounter);

        new Time();
        assertEquals(3, Time.createInstancesCounter);
    }

    @Test
    @Grade(3)
    public void testIsAfter() {

        Time t0 = new Time(0, 0, 0);
        Time t1 = new Time(0, 0, 10);
        Time t2 = new Time(0, 29, 1);
        Time t3 = new Time(0, 59, 0);
        Time t4 = new Time(1, 0, 0);
        Time t5 = new Time(23, 0, 5);

        assertTrue(t1.isAfter(t0));
        assertTrue(t2.isAfter(t1));
        assertTrue(t3.isAfter(t2));
        assertTrue(t4.isAfter(t3));
        assertTrue(t5.isAfter(t4));

        assertFalse(t0.isAfter(t1));
        assertFalse(t1.isAfter(t2));
        assertFalse(t2.isAfter(t3));
        assertFalse(t3.isAfter(t4));
        assertFalse(t4.isAfter(t5));
    }

    @Test
    @Grade(4)
    public void testFindLatest() {
        Time t0 = new Time(0, 0, 0);
        Time t1 = new Time(0, 0, 10);
        Time t2 = new Time(0, 29, 1);
        Time t3 = new Time(0, 59, 0);
        Time t4 = new Time(1, 0, 0);
        Time t5 = new Time(23, 0, 5);

        assertEquals(t5, TimeUtils.findLatest(new Time[]{t0, t5, t3, t4, t1, t2}));
    }

    @Test
    @Grade(3)
    public void testDescriptionOf() {
        String desc = TimeUtils.descriptionOf(new Time(10, 11, 12));

        //description should contain all 3 fields, in the right order
        assertTrue(desc.contains("10"));
        assertTrue(desc.contains("11"));
        assertTrue(desc.contains("12"));
        assertTrue(desc.indexOf("10") < desc.indexOf("11"));
        assertTrue(desc.indexOf("11") < desc.indexOf("12"));

        //may optionally end with "AM"/"PM"
        assertTrue(desc.endsWith("12") || desc.endsWith("AM") || desc.endsWith("PM"));
    }
}

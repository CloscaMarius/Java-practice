package teme.w04_oop1.ex0_time;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 28+2p
 */
@RunWith(GradeRunner.class)
public class TimeTest {

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        List<?> list = Collections.EMPTY_LIST;
        assertEquals(0, list.size());
        assertTrue(Arrays.toString(new int[]{}).length() > 0);
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
    @Grade(3)
    public void testFindLatest() {
        Time[] t = {
                new Time(0, 0, 0),
                new Time(0, 0, 10),
                new Time(0, 29, 1),
                new Time(0, 59, 0),
                new Time(1, 5, 0),
                new Time(2, 0, 3),
                new Time(23, 0, 5)
        };

        assertEquals(t[0], TimeUtils.findLatest(new Time[]{t[0]}));

        for (int i = 0; i < t.length; i++) {
            Time[] arr = new Time[]{t[i]};
            Time exp = t[i];
            assertEquals("findLatest() of " + Arrays.toString(arr), exp.toString(), TimeUtils.findLatest(arr).toString());

            for (int j = 0; j < t.length; j++) {
                arr = new Time[]{t[i], t[j]};
                exp = t[Math.max(i, j)];
                assertEquals("findLatest() of " + Arrays.toString(arr), exp.toString(), TimeUtils.findLatest(arr).toString());

                for (int k = 0; k < t.length; k++) {
                    arr = new Time[]{t[i], t[j], t[k]};
                    exp = t[Math.max(i, Math.max(j, k))];
                    assertEquals("findLatest() of " + Arrays.toString(arr), exp.toString(), TimeUtils.findLatest(arr).toString());

                    for (int l = 0; l < t.length; l++) {
                        arr = new Time[]{t[i], t[j], t[k], t[l]};
                        exp = t[Math.max(Math.max(i, j), Math.max(k, l))];

                        //also shuffle them
                        List<Time> list = Arrays.asList(arr);
                        Collections.shuffle(list);
                        arr = list.toArray(new Time[]{});

                        assertEquals("findLatest() of " + Arrays.toString(arr), exp.toString(), TimeUtils.findLatest(arr).toString());
                    }
                }
            }
        }
    }

    @Test
    @Grade(1)
    public void testFindLatest_shouldNotChangeArray() {
        Time[] times = {new Time(0, 30, 0), new Time(1, 0, 0), new Time(0, 40, 5)};

        Time[] beforeCopy = Arrays.copyOf(times, times.length);
        assertArrayEquals(beforeCopy, times);

        TimeUtils.findLatest(times);
        assertArrayEquals(beforeCopy, times);
    }

    @Test
    @Grade(3)
    public void testDescriptionOf() {
        //test a few combinations
        for (int h : Arrays.asList(0, 3, 7, 11)) {
            for (int m : Arrays.asList(1, 15, 35, 59)) {
                for (int s : Arrays.asList(2, 4, 13, 44, 59)) {

                    Time t = new Time(h, m, s);
                    String desc = TimeUtils.descriptionOf(t);

                    //description should contain all 3 fields, in the right order
                    assertTrue("descriptionOf() for time " + t + " should contain '" + h + "', '" + m + "' and '" + s + "', in this order; actual value: '" + desc + "'",
                            desc.contains(String.valueOf(h)) &&
                                    desc.contains(String.valueOf(m)) &&
                                    desc.contains(String.valueOf(s)) &&
                                    desc.indexOf(String.valueOf(h)) <= desc.indexOf(String.valueOf(m)) &&
                                    desc.indexOf(String.valueOf(m)) <= desc.indexOf(String.valueOf(s)));
                }
            }
        }
    }

    @Test
    @Grade(1)
    public void testDescriptionOf_endsWithAMPM() {

        for (int h = 0; h <= 23; h++) {
            if (h != 12) {
                Time t = new Time(h, 1, 2);
                String desc = TimeUtils.descriptionOf(t).toUpperCase();
                String hs = String.valueOf(h <= 12 ? h : h - 12);
                String suf = h < 12 ? "AM" : "PM";
                //may end with the hour or optionally with "AM"/"PM"
                assertTrue("descriptionOf() for time " + t + " does not end with '" + suf + "': '" + desc + "'", desc.endsWith(suf));
                assertTrue("descriptionOf() for time " + t + " should contain '" + hs + "': '" + desc + "'", desc.contains(hs));
            }
        }
    }

    @Test
    @Grade(1)
    public void testDescriptionOf_endsWithAMPM_trickyCases() {

        //12:01 -> 12:01 PM  - see: https://www.timeanddate.com/time/am-and-pm.html
        Time t = new Time(12, 0, 1);
        String desc = TimeUtils.descriptionOf(t).toUpperCase();
        String hs = "12";
        String suf = "PM";
        assertTrue("descriptionOf() for time " + t + " does not end with '" + suf + "': '" + desc + "'", desc.endsWith(suf));
        assertTrue("descriptionOf() for time " + t + " should contain '" + hs + "': '" + desc + "'", desc.contains(hs));

        //13:01 -> 1:01 PM
        t = new Time(13, 0, 1);
        desc = TimeUtils.descriptionOf(t).toUpperCase();
        hs = "1";
        suf = "PM";
        assertTrue("descriptionOf() for time " + t + " does not end with '" + suf + "': '" + desc + "'", desc.endsWith(suf));
        assertTrue("descriptionOf() for time " + t + " should contain '" + hs + "': '" + desc + "'", desc.contains(hs));
    }
}

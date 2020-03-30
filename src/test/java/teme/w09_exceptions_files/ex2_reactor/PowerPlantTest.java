package teme.w09_exceptions_files.ex2_reactor;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 2p
 * (MAX TOTAL GRADE for all exercise: 20p)
 */
@RunWith(GradeRunner.class)
public class PowerPlantTest {

    @Test
    @Grade(2)
    public void powerPlant_constructor() {
        PowerPlant p = new PowerPlant(100);
        assertEquals(100, p.getTargetPower());
    }

    @Test
    @Grade(2)
    public void powerPlant_hasAlarmSounded() {
        PowerPlant p = new PowerPlant(100);
        assertFalse(p.hasAlarmSounded());

        p.soundAlarm();
        assertTrue(p.hasAlarmSounded());
    }
}
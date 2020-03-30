package teme.w09_exceptions_files.ex2_reactor;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 7p
 * (MAX TOTAL GRADE for all exercise: 20p)
 */
@RunWith(GradeRunner.class)
public class PlantControllerTest {

    @Test
    @Grade(1)
    public void needAdjustment() throws ReactorCriticalException {

        Reactor r = new Reactor(1000);
        for (int i = 0; i < 100 && r.getPower() <= 100; i++) {
            r.increase();
        }
        int reactorPower = r.getPower();

        assertFalse(new PlantController(new PowerPlant(reactorPower - 15), r).needAdjustment());
        assertFalse(new PlantController(new PowerPlant(reactorPower - 5), r).needAdjustment());
        assertFalse(new PlantController(new PowerPlant(reactorPower), r).needAdjustment());
        assertFalse(new PlantController(new PowerPlant(reactorPower + 1), r).needAdjustment());
        assertFalse(new PlantController(new PowerPlant(reactorPower + 9), r).needAdjustment());
        assertFalse(new PlantController(new PowerPlant(reactorPower + 10), r).needAdjustment());

        assertTrue(new PlantController(new PowerPlant(reactorPower + 11), r).needAdjustment());
    }

    @Test
    @Grade(1)
    public void shutdown_powerGetsCut() throws ReactorCriticalException {
        for (int test = 1; test < 100; test++) {

            Reactor r = new Reactor(1000);
            for (int i = 0; i < 10; i++) {
                r.increase();
            }
            assertTrue(r.getPower() > 100);

            PlantController c = new PlantController(new PowerPlant(1), r);
            c.shutdown();
            assertTrue("For critical test " + test + " failed to shutdown!", r.getPower() <= 0);
        }
    }

    @Test
    @Grade(1)
    public void shutdown_powerGoesDownToExactlyZero() throws ReactorCriticalException {
        for (int test = 1; test < 100; test++) {

            Reactor r = new Reactor(1000);
            for (int i = 0; i < 10; i++) {
                r.increase();
            }
            assertTrue(r.getPower() > 100);

            PlantController c = new PlantController(new PowerPlant(1), r);
            c.shutdown();
            assertEquals("For critical test " + test + " failed to shutdown power to exactly zero!", 0, r.getPower());
        }
    }

    @Test
    @Grade(1)
    public void run_allFinishInStableOrCritical() {
        long stableCount = Stream.generate(PlantControllerTest::testOneRun)
                .limit(100)
                .filter(wasStable -> wasStable)
                .count();
        System.out.println("Out of 100 runs, finished in stable state: " + stableCount);
    }

    @Test
    @Grade(1)
    public void run_finishState_bothStableAndCriticalAppearSometimes() {
        long stableCount = Stream.generate(PlantControllerTest::testOneRun)
                .limit(100)
                .filter(wasStable -> wasStable)
                .count();
        assertTrue("out of 100 runs, expected stable scenarios count to be between 10 and 90, but was: " + stableCount, stableCount >= 10 && stableCount <= 90);
    }

    @Test
    @Grade(1)
    public void run_whenCritical_soundAlarm() {
        Reactor r = new Reactor(10);
        PowerPlant p = new PowerPlant(200);

        PlantController c = new PlantController(p, r);
        c.run();

        assertTrue("For critical test alarm failed to sound!", p.hasAlarmSounded());
    }

    @Test
    @Grade(1)
    public void run_whenCritical_shutDown() {
        Reactor r = new Reactor(10);
        PowerPlant p = new PowerPlant(200);

        PlantController c = new PlantController(p, r);
        c.run();

        assertEquals("For critical test, failed to shutdown reactor!", 0, r.getPower());
    }


    private static boolean testOneRun() {
        Reactor r = new Reactor(520);
        PowerPlant p = new PowerPlant(500);
        PlantController c = new PlantController(p, r);

        c.run();

        boolean reachedTarget = r.getPower() >= p.getTargetPower() - 10 && !p.hasAlarmSounded();
        boolean wentCritical = p.hasAlarmSounded();

        System.out.println("Status: reactor power: " + r.getPower() + ", plant target: " + p.getTargetPower() + ", alarm has sounded: " + p.hasAlarmSounded() +
                " => reachedTarget: " + reachedTarget + ", wentCritical: " + wentCritical);

        assertTrue("reactor should have reached target power OR should have went critical (with alarm), but neither happened!",
                reachedTarget || wentCritical);

        return reachedTarget;
    }
}
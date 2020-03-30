package teme.w09_exceptions_files.ex2_reactor;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 8p
 * (MAX TOTAL GRADE for all exercise: 20p)
 */
@RunWith(GradeRunner.class)
public class ReactorTest {

    @Test
    @Grade(1)
    public void defaultPower() {
        Reactor r = new Reactor(1000);
        assertEquals(0, r.getPower());
    }

    @Test
    @Grade(1)
    public void increase_increasesPower() throws ReactorCriticalException {
        buildAndStartReactor();
    }

    private Reactor buildAndStartReactor() throws ReactorCriticalException {
        final int incSteps = 100;
        Reactor r = new Reactor(incSteps * 100); //to avoid getting critical
        for (int i = 0; i < incSteps; i++) {
            r.increase();
        }
        System.out.println("current power: " + r.getPower() + " (after " + incSteps + " increases)");
        assertTrue("power should have increased after some calls to increase()", r.getPower() > 0);
        return r;
    }

    @Test
    @Grade(1)
    public void decrease_decreasesPower() throws ReactorCriticalException {
        Reactor r = buildAndStartReactor();
        int power = r.getPower();
        for (int i = 0; i < 10; i++) {
            r.decrease();
        }
        assertTrue("power should have decreased after 10 calls to decrease()", r.getPower() < power);
    }


    @Test
    @Grade(1)
    public void increase_deltaIsBetween1And100() throws ReactorCriticalException {
        Set<Integer> deltas = getDeltasForCallingIncreaseRepeatedlyWithoutGoingCritical(200);
        int minDelta = deltas.stream().mapToInt(i -> i).min().orElse(-999);
        int maxDelta = deltas.stream().mapToInt(i -> i).max().orElse(999);
        assertTrue("for increase, delta should be between 1 and 100, but was between " + minDelta + " and " + maxDelta, minDelta >= 1 && maxDelta <= 100);
    }

    @Test
    @Grade(1)
    public void increase_deltaIsRandom() throws ReactorCriticalException {
        Set<Integer> deltas = getDeltasForCallingIncreaseRepeatedlyWithoutGoingCritical(200);
        assertTrue("deltas not random: after 200 increases, should have at least 20 distinct deltas, but had only: " + deltas.size(), deltas.size() >= 20);
    }

    private Set<Integer> getDeltasForCallingIncreaseRepeatedlyWithoutGoingCritical(int steps) throws ReactorCriticalException {
        Reactor r = new Reactor(steps * 100); //to avoid getting critical

        Set<Integer> deltas = new HashSet<>();
        int prevPow = r.getPower();
        for (int i = 0; i < steps; i++) {
            r.increase();
            deltas.add(r.getPower() - prevPow);
            prevPow = r.getPower();
        }
        System.out.println("increased power from 0 to " + r.getPower() + " after " + steps + " steps");
        return deltas;
    }

    private Set<Integer> getDeltasForCallingDecreaseRepeatedlyUntilStopped(Reactor r) {
        final int initialPow = r.getPower();
        final int decSteps = r.getPower() * 2; //should decrease at least 1 per step, but give it extra room anyway

        Set<Integer> deltas = new HashSet<>();
        int prevPow = r.getPower();
        int i;
        for (i = 0; i < decSteps && r.getPower() > 0; i++) {
            r.decrease();
            deltas.add(r.getPower() - prevPow);
            prevPow = r.getPower();
        }
        System.out.println("decreased power from " + initialPow + " to " + r.getPower() + " after " + i + " steps");
        return deltas;
    }

    @Test
    @Grade(1)
    public void decrease_deltaIsBetween1And100() throws ReactorCriticalException {
        Set<Integer> deltas = getDeltasForCallingDecreaseRepeatedlyUntilStopped(buildAndStartReactor());
        int minDelta = deltas.stream().mapToInt(i -> i).min().orElse(-999);
        int maxDelta = deltas.stream().mapToInt(i -> i).max().orElse(999);
        assertTrue("for decrease, delta should be between -100 and -1, but was between " + minDelta + " and " + maxDelta, minDelta >= -100 && maxDelta <= -1);
    }

    @Test
    @Grade(1)
    public void decrease_deltaIsRandom() throws ReactorCriticalException {
        Set<Integer> deltas = getDeltasForCallingDecreaseRepeatedlyUntilStopped(buildAndStartReactor());
        assertTrue("deltas not random: after 200 decreases, should have at least 20 distinct deltas, but had only: " + deltas.size(), deltas.size() >= 20);
    }

    @Test
    @Grade(1)
    public void decrease_shouldStopAtZero() throws ReactorCriticalException {
        Reactor r = buildAndStartReactor();
        getDeltasForCallingDecreaseRepeatedlyUntilStopped(r);
        assertEquals("power after lots of decreases should stop at 0, but went lower, to: " + r.getPower(), 0, r.getPower());
    }

    @Test
    @Grade(1)
    public void goCritical_afterLotsOfAbuse() {
        Reactor r = new Reactor(50);
        try {
            for (int i = 0; i < 500; i++) {
                r.increase();
            }
            fail("reactor with limit 50 should have gone critical after 500 increases!");
        } catch (ReactorCriticalException e) {
            //ok
        }
    }
}
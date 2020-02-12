package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w02_flow.Ex3_FinancialSimulation.simulate;

/**
 * MAX GRADE: 14p
 */
@RunWith(GradeRunner.class)
public class Ex3_FinancialSimulationTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(3)
    public void simulate_targetAlreadyReached() {
        assertEquals(0, simulate(1000, 10, 900));
        assertEquals(0, simulate(1000, 10, 1000));
    }

    @Test
    @Grade(4)
    public void simulate_targetPreciselyReachedInOneYear() {
        assertEquals(1, simulate(1000, 5, 1050));
        assertEquals(1, simulate(1000, 10, 1100));
        assertEquals(1, simulate(1000, 100, 2000));
    }

    @Test
    @Grade(4)
    public void simulate_targetReachedInFewYears_withSomeSafetyMargin() {
        assertEquals(5, simulate(1000, 10, 1600));
        assertEquals(7, simulate(1000, 10, 1900));
        assertEquals(17, simulate(1000, 2.5, 1500));
    }

    @Test
    @Grade(3)
    public void simulate_targetReachedInManyYears_preciseComputationsNeeded() {
        assertEquals(17, simulate(1000, 2.5, 1521));  //=> should reach: 1521.62
        assertEquals(406, simulate(1000, 0.1, 1500)); //=> should reach: 1500.50
    }
}

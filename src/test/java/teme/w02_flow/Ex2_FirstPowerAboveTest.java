package teme.w02_flow;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w02_flow.Ex2_FirstPowerAbove.firstPowerAbove;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class Ex2_FirstPowerAboveTest {

    private final double DELTA = 0.001; //precision using when comparing double values for tests

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(3)
    public void firstPowerAbove_intBase() {
        assertEquals(25, firstPowerAbove(5.0, 20), DELTA);     //5^2 = 25 >20
        assertEquals(32, firstPowerAbove(2.0, 31.9), DELTA);   //2^5 = 32 >31.9
        assertEquals(64, firstPowerAbove(2.0, 32), DELTA);     //2^6 = 64 >32
        assertEquals(1024, firstPowerAbove(2.0, 1000), DELTA); //2^10 = 1024 >1000
    }

    @Test
    @Grade(3)
    public void firstPowerAbove_floatBase() {
        assertEquals(2.25, firstPowerAbove(1.5, 2.2), DELTA);      //1.5^2 = 2.25 >2
        assertEquals(15.625, firstPowerAbove(2.5, 15.5), DELTA);   //2.5^3 = 15.625 >12
    }

    @Test
    @Grade(2)
    public void firstPowerAbove_floatBase_withRoundingErrors() {
        //some rounding errors occur here, amount depends on computing method!!
        //(Math.pow() may be more precise than manual multiplications?)
        //so we use a more relaxed precision (0.1) when checking expected vs actual result
        assertEquals(1.5286306776106358, firstPowerAbove(1.0625, 1.5), 0.1); //1.5286306776106358 = 1.0625^7
        assertEquals(2.0698899917795224, firstPowerAbove(1.0625, 2), 0.1);    //2.0698899917795224 = 1.0525^12
    }

    @Test
    @Grade(2)
    public void firstPowerAbove_smallLimit() {
        assertEquals(1, firstPowerAbove(1.0, 0.1), DELTA); //1^0 = 1 >0.1
        assertEquals(1, firstPowerAbove(3.0, 0.1), DELTA); //3^0 = 1 >0.1
        assertEquals(1, firstPowerAbove(7.0, 0.1), DELTA); //7^0 = 1 >0.1
    }
}
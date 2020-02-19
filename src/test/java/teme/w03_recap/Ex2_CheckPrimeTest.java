package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w03_recap.Ex2_CheckPrime.isPrime;

/**
 * MAX GRADE: 8p
 */
@RunWith(GradeRunner.class)
public class Ex2_CheckPrimeTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(30); // max running time allowed per each test method

    @Test
    @Grade(3)
    public void isPrime_testSomePrimeNumbers() {
        //from: https://www.mathsisfun.com/numbers/prime-numbers-to-10k.html
        assertTrue(isPrime(2));
        assertTrue(isPrime(3));
        assertTrue(isPrime(7));
        assertTrue(isPrime(11));
        assertTrue(isPrime(13));
        assertTrue(isPrime(47));
        assertTrue(isPrime(53));
        assertTrue(isPrime(127));
        assertTrue(isPrime(283));
        assertTrue(isPrime(467));
        assertTrue(isPrime(577));
        assertTrue(isPrime(769));
        assertTrue(isPrime(877));
        assertTrue(isPrime(983));
        assertTrue(isPrime(1_087));
        assertTrue(isPrime(9_857));
        assertTrue(isPrime(10_007));
        assertTrue(isPrime(21_503));
        assertTrue(isPrime(31_271));
        assertTrue(isPrime(58_109));
        assertTrue(isPrime(89_867));
        assertTrue(isPrime(99_991));
    }

    @Test
    @Grade(1)
    public void isPrime_testSomeHugePrimeNumbers() {
        assertTrue(isPrime(953_567));
        assertTrue(isPrime(999_983));
        assertTrue(isPrime(100_000_007));
        assertTrue(isPrime(999_999_937));
        assertTrue(isPrime(2_147_483_647)); //Integer.MAX_VALUE
    }

    @Test
    @Grade(3)
    public void isPrime_testSomeNonPrimeNumbers() {

        //simple ones
        assertFalse(isPrime(1));
        assertFalse(isPrime(4));
        assertFalse(isPrime(12));

        //bigger ones
        assertFalse(isPrime(10003));
        assertFalse(isPrime(46311));

        //some with prime factors
        assertFalse(isPrime(13 * 47));
        assertFalse(isPrime(383 * 1087));
        assertFalse(isPrime(10007 * 10007));
        assertFalse(isPrime(769 * 99991));
        assertFalse(isPrime(127 * 89867));

        assertFalse(isPrime(108389));
    }

    @Test
    @Grade(1)
    public void isPrime_testSomeHugeNonPrimeNumbers() {
        assertFalse(isPrime(21503 * 21503));
        assertFalse(isPrime(31271 * 58109));
        assertFalse(isPrime(46337 * 46327));

        assertFalse(isPrime(215_180_521));
        assertFalse(isPrime(977_875_441));
        assertFalse(isPrime(999_999_939));
        assertFalse(isPrime(1_817_126_539));
        assertFalse(isPrime(2_147_117_569));
    }
}

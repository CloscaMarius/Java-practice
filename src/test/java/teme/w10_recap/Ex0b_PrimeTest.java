package teme.w10_recap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import teme.w10_recap.ex0_warmup.Ex0b_Prime;
import teme.w10_recap.ex0_warmup.InvalidNegativeNumberException;

public class Ex0b_PrimeTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5); // max running time allowed per each test method

    @Test
    public void worksForPrimeNumbers() {
        Assert.assertTrue(Ex0b_Prime.isPrime(2));
        Assert.assertTrue(Ex0b_Prime.isPrime(3));
        Assert.assertTrue(Ex0b_Prime.isPrime(7));
    }

    @Test
    public void worksForNonPrimeNumbers() {
        Assert.assertFalse(Ex0b_Prime.isPrime(10));
        Assert.assertFalse(Ex0b_Prime.isPrime(28));
    }

    @Test
    public void worksForEdgeCases_1() {
        Assert.assertFalse(Ex0b_Prime.isPrime(1));
    }

    @Test
    public void worksForPrimeNumbers_VeryBig() {
        Assert.assertTrue(Ex0b_Prime.isPrime(884267));
        Assert.assertTrue(Ex0b_Prime.isPrime(Integer.MAX_VALUE));
        //Assert.assertTrue(Ex0b_Prime.isPrime(Long.MAX_VALUE - 24));
    }

    @Test
    public void worksForNonPrimeNumbers_VeryBig() {
        Assert.assertFalse(Ex0b_Prime.isPrime(884267L * 884267L));
    }

    @Test
    public void failsForNegativeNumbers() {
        try {
            Ex0b_Prime.isPrime(-3);
            Assert.fail("Calling isPrime() with a negative number should have failed by now");
        } catch (InvalidNegativeNumberException e) {
            //ok, expected
        }

        try {
            Ex0b_Prime.isPrime(0);
            Assert.fail("Calling isPrime() with a negative number should have failed by now");
        } catch (InvalidNegativeNumberException e) {
            //ok, expected
        }
    }
}

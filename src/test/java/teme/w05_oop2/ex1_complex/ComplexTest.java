package teme.w05_oop2.ex1_complex;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 23p
 */
@RunWith(GradeRunner.class)
public class ComplexTest {

    @Test
    @Grade(1)
    public void test_hasOnlyOneConstructor() {
        assertEquals("Complex should have only 1 constructor", 1, Complex.class.getDeclaredConstructors().length);
    }

    @Test
    @Grade(1)
    public void testConstructor() {
        newComplex(33, 44);
    }

    @Test
    @Grade(2)
    public void testConstructorAndEquals() {
        Complex c1 = newComplex(-2, 3);
        assertEquals(c1, c1);

        assertEquals("calling constructor with same params should produce equal objects", newComplex(1, -2), newComplex(1, -2));
        assertEquals(newComplex(-2, 3), newComplex(-2, 3));

        assertNotEquals(1, newComplex(1, 1));
        assertNotEquals(newComplex(1, 1), newComplex(1, 3));
        assertNotEquals(newComplex(1, 1), newComplex(3, 1));
        assertNotEquals(newComplex(1, 3), newComplex(3, 1));
        assertNotEquals(newComplex(-1, 0), newComplex(1, 0));
    }

    @Test
    @Grade(2)
    public void testToString() {
        Complex c1 = newComplex(33, 44);
        assertTrue("toString should contain imaginary part", c1.toString().contains("33"));
        assertTrue("toString should contain real part", c1.toString().contains("44"));
    }

    @Test
    @Grade(2)
    public void testComplexMethod() {
        Complex c1 = newComplex(-2, 3);
        Complex c2 = complex(-2, 3);
        Complex c3 = complex(-2, 3);
        Complex c4 = complex(2, -3);

        assertEquals("complex() and constructor should produce equal objects, for equal input params", c1, c2);
        assertNotSame("complex() should produce new separate objects each time is called", c2, c3);
        assertNotEquals("complex() should produce non-equal objects, for non-equal input params", c3, c4);
    }

    @Test
    @Grade(4)
    public void testNegateOperation() {
        assertEquals(
                newComplex(-1, -2),
                negate(newComplex(1, 2)));

        assertEquals(
                newComplex(-4, 7),
                negate(newComplex(4, -7)));

        assertEquals(
                newComplex(33, -5),
                negate(newComplex(-33, 5)));
    }

    @Test
    @Grade(4)
    public void testAddOperation() {
        Complex c1 = newComplex(1, 2);
        Complex c2 = newComplex(3, 4);

        assertEquals(newComplex(4, 6), add(c1, c2));
    }

    @Test
    @Grade(4)
    public void testMultiplyOperation() {
        Complex c1 = newComplex(1, 2);
        Complex c2 = newComplex(3, 4);

        assertEquals(newComplex(-5, 10), multiply(c1, c2));
    }

    @Test
    @Grade(1)
    public void testGeneralRules_addIsCommutative() {
        Complex zero = newComplex(0, 0);
        Complex c1 = newComplex(1, 2);
        Complex c2 = newComplex(3, 4);
        assertEquals("add should be commutative", add(c1, c2), add(c2, c1));
        assertEquals("add zero to anything should't count ", c1, add(c1, zero));
    }

    @Test
    @Grade(1)
    public void testGeneralRules_negate() {
        Complex c1 = newComplex(1, -2);
        Complex c2 = newComplex(3, 4);
        assertEquals("double negation cancels out", c1, negate(negate(c1)));
        assertEquals("adding a number then adding its negate should cancel out", c1, add(add(c1, c2), negate(c2)));
    }

    @Test
    @Grade(1)
    public void testGeneralRules_multiply() {
        Complex zero = newComplex(0, 0);
        Complex one = newComplex(1, 0);
        Complex c1 = newComplex(1, 2);
        Complex c2 = newComplex(3, 4);

        //check some generic arithmetic rules
        assertEquals(multiply(c1, c2), multiply(c2, c1)); //multiply is commutative
        assertEquals("multiply anything by zero results in zero", zero, multiply(c1, zero));
        assertEquals("multiply anything by one shouldn't count", c1, multiply(c1, one));
    }


    private Complex newComplex(double i, double r) {
        try {
            return Complex.class.getDeclaredConstructor(double.class, double.class).newInstance(i, r);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Failed to call constructor of Complex class, with 2 double params");
            return null;
        }
    }

    private Complex invoke(Object owner, String methodName, Class<?>[] paramTypes, Object... paramValues) {
        try {
            Method m = Complex.class.getDeclaredMethod(methodName, paramTypes);
            boolean shouldBeStatic = (owner instanceof Class);
            assertEquals(methodName + "() method is static?", shouldBeStatic, Modifier.isStatic(m.getModifiers()));
            assertEquals(methodName + "() method should return an instance of Complex", Complex.class, m.getReturnType());

            return (Complex) m.invoke(owner, paramValues);
        } catch (NoSuchMethodException e) {
            fail("Complex should have a " + methodName + "() method, with param types " + Arrays.toString(paramTypes));
        } catch (IllegalAccessException | InvocationTargetException e) {
            fail("Complex." + methodName + "() should be accessible/usable");
        }
        return null;
    }

    private Complex complex(double i, double r) {
        return invoke(Complex.class, "complex", new Class[]{double.class, double.class}, i, r);
    }

    private Complex negate(Complex c) {
        return invoke(c, "negate", new Class[]{});
    }

    private Complex add(Complex c1, Complex c2) {
        return invoke(c1, "add", new Class[]{Complex.class}, c2);
    }

    private Complex multiply(Complex c1, Complex c2) {
        return invoke(c1, "multiply", new Class[]{Complex.class}, c2);
    }
}

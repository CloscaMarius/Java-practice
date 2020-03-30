package teme.w09_exceptions_files.ex0_string_to_int;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class StringToIntTest {

    @Test
    @Grade(1)
    public void toPositiveInt_forNotANumber_throwsException() {
        try {
            StringToInt.toPositiveInt("lucian");
            fail("Test failed: 'lucian' is not a number");
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    @Grade(1)
    public void toPositiveInt_forNotANumber_throwsExpectedTypeOfException() {
        try {
            StringToInt.toPositiveInt("lucian");
            fail("Test failed: 'lucian' is not a number");
        } catch (Exception e) {
            assertEquals("Got wrong exception for 'lucian':", "NotANumberException", e.getClass().getSimpleName());
        }
    }

    @Test
    @Grade(1)
    public void toPositiveInt_forNegativeValue_throwsException() {
        try {
            StringToInt.toPositiveInt("-1");
            fail("Test failed: '-1' is not a positive number");
        } catch (Exception e) {
            //ok
        }
    }

    @Test
    @Grade(1)
    public void toPositiveInt_forNegativeValue_throwsExpectedTypeOfException() {
        try {
            StringToInt.toPositiveInt("-1");
            fail("Test failed: '-1' is not a positive number");
        } catch (Exception e) {
            assertEquals("Got wrong exception for '-1':", "NegativeNumberException", e.getClass().getSimpleName());
        }
    }

    @Test
    @Grade(2)
    public void testValidNumber() {
        try {
            assertEquals(1, StringToInt.toPositiveInt("1"));
            assertEquals(100, StringToInt.toPositiveInt("100"));
            assertEquals(42, StringToInt.toPositiveInt("+42"));
        } catch (Exception e) {
            fail("toPositiveInt() should not throw exceptions, but it did: " + e);
        }
    }

    @Test
    @Grade(1)
    public void testNumbersList_emptyInputList() {
        try {
            assertEquals(
                    emptyList(),
                    StringToInt.toPositiveInt(emptyList()));
        } catch (Exception e) {
            fail("toPositiveInt() should not throw exceptions, but it did: " + e);
        }
    }

    @Test
    @Grade(2)
    public void testNumbersList() {
        try {
            assertEquals(
                    emptyList(),
                    StringToInt.toPositiveInt(Arrays.asList("3, really", "?", " ", "")));

            assertEquals(
                    Arrays.asList(1, 2, 3),
                    StringToInt.toPositiveInt(Arrays.asList("lucian", "-1", "1", "", "+2", "?", "3", "-4")));
        } catch (Exception e) {
            fail("toPositiveInt() should not throw exceptions, but it did: " + e);
        }
    }

    @Test
    @Grade(1)
    public void testNumbersList_shouldNotThrowCheckedExceptions() {
        try {
            Class<?>[] exTypes = StringToInt.class.getDeclaredMethod("toPositiveInt", List.class).getExceptionTypes();
            for (Class<?> e : exTypes) {
                assertTrue("toPositiveInt(List) should not throw any checked exceptions, but throws: " + e, e.isInstance(RuntimeException.class));
            }
        } catch (NoSuchMethodException e) {
            fail("method StringToInt.toPositiveInt() not found!");
        }
    }
}
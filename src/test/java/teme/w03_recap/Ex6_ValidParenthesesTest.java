package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w03_recap.Ex6_ValidParentheses.isValid;

/**
 * MAX GRADE: 6p
 */
@RunWith(GradeRunner.class)
public class Ex6_ValidParenthesesTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(1)
    public void testValidExpressions_simple() {
        assertTrue(isValid(""));
        assertTrue(isValid("Abc 123"));
        assertTrue(isValid("()"));
        assertTrue(isValid("ab ()"));
    }

    @Test
    @Grade(1)
    public void testValidExpressions_multiplePairs() {
        assertTrue(isValid("()()"));
        assertTrue(isValid("x*(y+z), (2+3)"));
    }

    @Test
    @Grade(1)
    public void testValidExpressions_multipleNestedPairs() {
        assertTrue(isValid("(())"));
        assertTrue(isValid("(()())"));
        assertTrue(isValid("(())()"));
        assertTrue(isValid("(1+(2+3))-((4))"));
        assertTrue(isValid("(.()..((?))..).."));
    }

    @Test
    @Grade(1)
    public void testInvalidExpressions_incompletePairs() {
        assertFalse(isValid("("));
        assertFalse(isValid("(()"));
        assertFalse(isValid(")"));
        assertFalse(isValid("())"));
        assertFalse(isValid("().(."));
        assertFalse(isValid("..()())"));
        assertFalse(isValid("..(()"));
    }

    @Test
    @Grade(2)
    public void testInvalidExpressions_wronglyNestedPairs() {
        assertFalse(isValid(")("));
        assertFalse(isValid("() )( ()"));
        assertFalse(isValid(")( abc ()"));
        assertFalse(isValid("(( ))) ((( ))"));
    }
}
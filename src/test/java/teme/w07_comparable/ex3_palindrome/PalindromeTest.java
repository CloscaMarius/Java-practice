package teme.w07_comparable.ex3_palindrome;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 20+5p
 */
@RunWith(GradeRunner.class)
public class PalindromeTest {

    @Test
    @Grade(10)
    public void isSymmetrical() {
        assertFalse(Palindrome.isSymmetrical(new int[]{1, 2}));
        assertFalse(Palindrome.isSymmetrical(new int[]{1, 2, 1, 2}));
        assertFalse(Palindrome.isSymmetrical(new int[]{1, 2, 3, 4, 1}));

        assertTrue(Palindrome.isSymmetrical(new int[]{}));
        assertTrue(Palindrome.isSymmetrical(new int[]{1}));
        assertTrue(Palindrome.isSymmetrical(new int[]{1, 2, 2, 1}));
        assertTrue(Palindrome.isSymmetrical(new int[]{10, 20, 30, 20, 10}));
    }

    @Test
    @Grade(5)
    public void isSymmetrical_generic() {
        assertFalse(isSymmetrical_generic(new String[]{"ab", "cd"}));
        assertFalse(isSymmetrical_generic(new String[]{"ab", "cd", "ab", "cd"}));
        assertFalse(isSymmetrical_generic(new String[]{"ab", "cd", "cd", "ef", "ab"}));
        assertFalse(isSymmetrical_generic(new Boolean[]{true, false}));

        assertTrue(isSymmetrical_generic(new String[]{}));
        assertTrue(isSymmetrical_generic(new String[]{"abc"}));
        assertTrue(isSymmetrical_generic(new String[]{"ab", "cd", "cd", "ab"}));
        assertTrue(isSymmetrical_generic(new Boolean[]{true, false, true}));
    }

    boolean isSymmetrical_generic(Object[] arr) {
        try {
            Method m = Palindrome.class.getDeclaredMethod("isSymmetrical_generic", Object[].class);
            assertEquals("isSymmetrical_generic() should return a boolean", boolean.class, m.getReturnType());
            assertTrue("isSymmetrical_generic() should be static", Modifier.isStatic(m.getModifiers()));
            return (boolean) m.invoke(null, new Object[]{arr});
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("method Palindrome.isSymmetrical_generic(), with 1 param of type array, was not found or cannot be used: " + e.getMessage());
            return false; //doesn't happen
        }
    }

    @Test
    @Grade(6)
    public void isPalindrome() {
        assertFalse(Palindrome.isPalindrome("abb"));
        assertFalse(Palindrome.isPalindrome("abbXa"));
        assertFalse(Palindrome.isPalindrome("not a palindrome"));

        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("aba"));
        assertTrue(Palindrome.isPalindrome("abba"));
        assertTrue(Palindrome.isPalindrome("aerisirea"));
        assertTrue(Palindrome.isPalindrome("calabalac"));
    }

    @Test
    @Grade(4)
    public void isPalindrome_withSpacesAndDifferentCase() {
        assertTrue(Palindrome.isPalindrome("step on no pets"));
        assertTrue(Palindrome.isPalindrome("Never odd or even"));
        assertTrue(Palindrome.isPalindrome("Ene purta patru pene"));
        assertTrue(Palindrome.isPalindrome("Ion a luat luni vinul tau la noi"));
    }
}
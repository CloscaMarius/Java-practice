package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;
import static teme.w03_recap.Ex0_WarmupRecap.*;

/**
 * MAX GRADE: 16p
 */
@RunWith(GradeRunner.class)
public class Ex0_WarmupRecapTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(2)
    public void endsTest() {
        assertEquals("", ends(""));
        assertEquals("a", ends("a"));
        assertEquals("ab", ends("ab"));
        assertEquals("ad", ends("abcd"));
        assertEquals("af", ends("abcdef"));
    }

    @Test
    @Grade(2)
    public void middleTest() {
        assertEquals("", middle(""));
        assertEquals("a", middle("a"));
        assertEquals("ab", middle("ab"));
        assertEquals("b", middle("abc"));
        assertEquals("bc", middle("abcd"));
        assertEquals("c", middle("abcde"));
        assertEquals("cd", middle("abcdef"));
    }

    @Test
    @Grade(2)
    public void onlyUpperTest() {
        assertEquals("", onlyUpper(""));
        assertEquals("", onlyUpper("?"));
        assertEquals("", onlyUpper("no caps here...123"));
        assertEquals("F", onlyUpper("First cap"));
        assertEquals("AFOT", onlyUpper("A Fost OdaTa.."));
        assertEquals("ONLYCAPS", onlyUpper("ONLYCAPS"));
    }

    @Test
    @Grade(2)
    public void containsTest() {
        assertFalse(contains("", 'x'));
        assertFalse(contains("a", 'x'));
        assertFalse(contains("ab", 'x'));
        assertFalse(contains("abcde", 'x'));
        assertTrue(contains("abcdef", 'a'));
        assertTrue(contains("abcdef", 'd'));
        assertTrue(contains("abcdef", 'f'));
    }

    @Test
    @Grade(2)
    public void countTest() {
        assertEquals(0, count("", 'x'));
        assertEquals(0, count("abcde", 'x'));
        assertEquals(1, count("abcde", 'a'));
        assertEquals(1, count("abcde", 'e'));
        assertEquals(3, count("eaebcdfe", 'e'));
    }

    @Test
    @Grade(2)
    public void countVowelsTest() {
        assertEquals(4, countVowels("Run, Forest, run!"));
        assertEquals(2, countVowels("I will.."));
        assertEquals(0, countVowels("n.v.w.ls"));
        assertEquals(0, countVowels(""));
    }

    @Test
    @Grade(2)
    public void isSortedTest() {
        assertFalse(isSorted("ba"));
        assertFalse(isSorted("aba"));
        assertFalse(isSorted("bbac"));
        assertFalse(isSorted("abcdea"));
        assertTrue(isSorted(""));
        assertTrue(isSorted("x"));
        assertTrue(isSorted("abcz"));
        assertTrue(isSorted("aabbcc"));
    }

    @Test
    @Grade(2)
    public void sortedTest() {
        assertEquals("", sorted(""));
        assertEquals("a", sorted("a"));
        assertEquals("ab", sorted("ba"));
        assertEquals("abc", sorted("cba"));
        assertEquals("aab", sorted("aab"));
        assertEquals("abdde", sorted("eddab"));
    }
}
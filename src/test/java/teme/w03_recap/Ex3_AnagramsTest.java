package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static teme.w03_recap.Ex3_Anagrams.anagrams;

/**
 * MAX GRADE: 8p
 */
@RunWith(GradeRunner.class)
public class Ex3_AnagramsTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(2)
    public void anagramsTest_true() {
        assertTrue(anagrams("", ""));
        assertTrue(anagrams("binary", "brainy"));
        assertTrue(anagrams("listen", "silent"));
    }

    @Test
    @Grade(1)
    public void anagramsTest_false() {
        assertFalse(anagrams("a", ""));
        assertFalse(anagrams("abc", "ac"));
        assertFalse(anagrams("ac", "dac"));
        assertFalse(anagrams("ac", "dac"));
    }

    @Test
    @Grade(2)
    public void anagramsTest_repeatingLetters() {
        assertTrue(anagrams("baac", "abac"));

        assertFalse(anagrams("Aa", "a"));
        assertFalse(anagrams("anagram", "angrm"));
        assertFalse(anagrams("baac", "cabb"));
    }

    @Test
    @Grade(1)
    public void anagramsTest_mixedCase() {
        assertTrue(anagrams("A", "a"));
        assertTrue(anagrams("aAa", "AaA"));
        assertTrue(anagrams("Binary", "brainY"));
        assertTrue(anagrams("Listen", "Silent"));

        assertFalse(anagrams("aA", "a"));
    }

    @Test
    @Grade(1)
    public void anagramsTest_withSpacesAndSpecialChars() {
        assertTrue(anagrams(" ab ", "b  a"));
        assertTrue(anagrams("a1 b+!", "! b1+a"));

        assertFalse(anagrams("ac ", "ac"));
        assertFalse(anagrams("ac", " ac"));
    }

    @SuppressWarnings("StringOperationCanBeSimplified")
    @Test
    @Grade(1)
    public void anagramsTest_stringsOutsidePool() {
        assertTrue(anagrams(new String(""), new String("")));
        assertTrue(anagrams(new String("abc"), new String("abc")));
        assertTrue(anagrams(
                new String(new char[]{0, 'b', 'a'}),
                new String(new char[]{'a', 0, 'b'})));

        assertFalse(anagrams(
                new String(new char[]{0, 0, 'b'}),
                new String(new char[]{'a', 0, 'b'})));
    }
}
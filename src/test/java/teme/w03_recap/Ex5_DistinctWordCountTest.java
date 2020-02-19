package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.*;
import static teme.w03_recap.Ex5_DistinctWordCount.*;

/**
 * MAX GRADE: 10p
 */
@RunWith(GradeRunner.class)
public class Ex5_DistinctWordCountTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(1)
    public void testSplitToWords() {
        assertArrayEquals(new String[]{}, splitToWords(""));
        assertArrayEquals(new String[]{"abc"}, splitToWords("abc"));
        assertArrayEquals(new String[]{"ab", "cd"}, splitToWords("ab cd"));
        assertArrayEquals(new String[]{"ab", "cd", "ab"}, splitToWords("ab cd ab"));
    }

    @Test
    @Grade(1)
    public void testSplitToWords_extraSpaces() {
        assertArrayEquals(new String[]{}, splitToWords("  "));
        assertArrayEquals(new String[]{"abc"}, splitToWords("  abc "));
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, splitToWords(" ab  cd ef  "));
    }

    @Test
    @Grade(1)
    public void testContains() {
        assertFalse(contains(new String[]{}, ""));
        assertFalse(contains(new String[]{}, "x"));
        assertFalse(contains(new String[]{"ab", "cd"}, "x"));
        assertTrue(contains(new String[]{"ab", "cd", "ef"}, "cd"));
        assertTrue(contains(new String[]{"ab", "cd", "ef"}, "ef"));
    }

    @SuppressWarnings("StringOperationCanBeSimplified")
    @Test
    @Grade(1)
    public void testContains_stringsOutsidePool() {
        //Using here explicit constructor new String() to force Java to build new String instances, instead of reusing the ones from String pool
        //Will cause problems if strings are improperly compared using '==' (instead of .equals())
        assertTrue(contains(new String[]{new String("ab"), "cd", "ef"}, "ab"));
        assertTrue(contains(new String[]{"ab", "cd", "ef"}, new String("ab")));
    }

    @Test
    @Grade(1)
    public void testCount_emptyCase() {
        assertEquals(0, distinctWordCount(""));
    }

    @Test
    @Grade(2)
    public void testCount_simpleCases_noDuplicates() {
        assertEquals(1, distinctWordCount("abc"));
        assertEquals(3, distinctWordCount("aa bb cc"));
    }

    @Test
    @Grade(2)
    public void testCount_simpleCases_someDuplicates() {
        assertEquals(1, distinctWordCount("aa aa"));
        assertEquals(3, distinctWordCount("aa bb aa cc"));
    }

    @Test
    @Grade(1)
    public void testCount_trickyCases() {
        assertEquals(0, distinctWordCount(" "));
        assertEquals(0, distinctWordCount("  "));
        assertEquals(1, distinctWordCount(" abc "));
        assertEquals(3, distinctWordCount("  aa   bb cc  AA  aA "));
    }
}

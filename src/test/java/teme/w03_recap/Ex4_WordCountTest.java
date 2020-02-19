package teme.w03_recap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import static org.junit.Assert.assertEquals;
import static teme.w03_recap.Ex4_WordCount.wordCount;

/**
 * MAX GRADE: 6p
 */
@RunWith(GradeRunner.class)
public class Ex4_WordCountTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // max running time allowed per each test method

    @Test
    @Grade(2)
    public void testSimpleCases() {
        assertEquals(1, wordCount("abc"));
        assertEquals(2, wordCount("aa bb"));
    }

    @Test
    @Grade(2)
    public void testEmptyCase() {
        assertEquals(0, wordCount(""));
    }

    @Test
    @Grade(2)
    public void testTrickyCases() {
        assertEquals(0, wordCount(" "));
        assertEquals(0, wordCount("  "));
        assertEquals(1, wordCount(" abc "));
        assertEquals(4, wordCount("  aa   bb cc  aa "));
    }
}

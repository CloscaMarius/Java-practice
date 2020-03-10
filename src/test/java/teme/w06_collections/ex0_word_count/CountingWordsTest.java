package teme.w06_collections.ex0_word_count;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 25p
 */
@RunWith(GradeRunner.class)
public class CountingWordsTest {

    @Test
    @Grade(1)
    public void words_emptyCases() {
        assertTrue(CountingWords.words("").isEmpty());
        assertTrue(CountingWords.words("   ").isEmpty());
    }

    @Test
    @Grade(1)
    public void allOthers_emptyCases() {
        assertEquals(0, CountingWords.wordsCount(""));
        assertTrue(CountingWords.sortedWords("").isEmpty());
        assertTrue(CountingWords.distinctWords("").isEmpty());
        assertTrue(CountingWords.distinctSortedWords("").isEmpty());
        assertTrue(CountingWords.wordsUsageCount("").isEmpty());
        assertTrue(CountingWords.wordsUsageCountSortedByWord("").isEmpty());
        assertTrue(CountingWords.wordsUsageCountSortedByCountThenWord("").isEmpty());
    }

    @Test
    @Grade(1)
    public void words_separatedByOneSpace() {
        assertArrayEquals(new String[]{"abc"}, CountingWords.words("abc").toArray());
        assertArrayEquals(new String[]{"ab", "cd", "ef", "ab"}, CountingWords.words("ab cd ef ab").toArray());
    }

    @Test
    @Grade(1)
    public void words_paddedAndSeparatedByMultipleSpaces() {
        assertArrayEquals(new String[]{"ab", "cd"}, CountingWords.words("ab   cd").toArray());
        assertArrayEquals(new String[]{"ab", "cd", "ef", "ab"}, CountingWords.words(" ab   cd ef  ab ").toArray());
    }

    @Test
    @Grade(1)
    public void wordsCount() {
        assertEquals(1, CountingWords.wordsCount("abc"));
        assertEquals(4, CountingWords.wordsCount("ab cd ef ab"));
    }

    @Test
    @Grade(2)
    public void sortedWords() {
        assertArrayEquals(new String[]{"abc"}, CountingWords.sortedWords("abc").toArray());
        assertArrayEquals(new String[]{"ab", "ab", "cd", "ef"}, CountingWords.sortedWords("ef ab cd ab").toArray());
    }

    @Test
    @Grade(2)
    public void distinctWords() {
        assertArrayEquals(new String[]{"abc"}, CountingWords.distinctWords("abc").toArray());
        assertArrayEquals(new String[]{"ef", "ab", "cd"}, CountingWords.distinctWords("ef ab cd ab ef").toArray());
    }

    @Test
    @Grade(3)
    public void distinctSortedWords() {
        assertArrayEquals(new String[]{"abc"}, CountingWords.distinctSortedWords("abc").toArray());
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, CountingWords.distinctSortedWords("ef ab cd ab ef").toArray());
    }

    @Test
    @Grade(4)
    public void wordsUsageCount() {
        assertEquals(1, CountingWords.wordsUsageCount("abc").size());
        assertEquals(1, (long) CountingWords.wordsUsageCount("abc").get("abc"));

        Map<String, Long> usage = CountingWords.wordsUsageCount("ef ab cd ab ef gh ab");
        assertEquals(4, usage.size());
        assertEquals(3, (long) usage.get("ab"));
        assertEquals(1, (long) usage.get("cd"));
        assertEquals(2, (long) usage.get("ef"));
        assertEquals(1, (long) usage.get("gh"));
    }

    @Test
    @Grade(4)
    public void wordsUsageCountSortedByWord() {
        assertEquals(1, CountingWords.wordsUsageCountSortedByWord("abc").size());
        assertEquals(1, (long) CountingWords.wordsUsageCountSortedByWord("abc").get("abc"));

        Map<String, Long> usage = CountingWords.wordsUsageCountSortedByWord("ef ab cd ab ef gh ab");
        assertArrayEquals(new String[]{"ab", "cd", "ef", "gh"}, usage.keySet().toArray());
        assertArrayEquals(new Long[]{3L, 1L, 2L, 1L}, usage.values().toArray());
    }

    @Test
    @Grade(5)
    public void optional_wordsUsageCountSortedByCountThenWord() {
        assertEquals(1, CountingWords.wordsUsageCountSortedByCountThenWord("abc").size());
        assertEquals("abc", CountingWords.wordsUsageCountSortedByCountThenWord("abc").get(0).getKey());
        assertEquals(1, (long) CountingWords.wordsUsageCountSortedByCountThenWord("abc").get(0).getValue());

        List<Map.Entry<String, Long>> usage = CountingWords.wordsUsageCountSortedByCountThenWord("ef cd cd cd ab ab ab gh ef ef ef ef");
        assertArrayEquals(new String[]{"ef", "ab", "cd", "gh"}, usage.stream().map(Map.Entry::getKey).toArray());
        assertArrayEquals(new Long[]{5L, 3L, 3L, 1L}, usage.stream().map(Map.Entry::getValue).toArray());
    }
}

package teme.w08_streams.ex6_word_count;

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
public class CountingWordsWithStreamsTest {

    @Test
    @Grade(1)
    public void words_emptyCases() {
        assertTrue(CountingWordsWithStreams.words("").isEmpty());
        assertTrue(CountingWordsWithStreams.words("   ").isEmpty());
    }

    @Test
    @Grade(1)
    public void words_separatedByOneSpace() {
        assertArrayEquals(new String[]{"abc"}, CountingWordsWithStreams.words("abc").toArray());
        assertArrayEquals(new String[]{"ab", "cd", "ef", "ab"}, CountingWordsWithStreams.words("ab cd ef ab").toArray());
    }

    @Test
    @Grade(1)
    public void words_paddedAndSeparatedByMultipleSpaces() {
        assertArrayEquals(new String[]{"ab", "cd"}, CountingWordsWithStreams.words("ab   cd").toArray());
        assertArrayEquals(new String[]{"ab", "cd", "ef", "ab"}, CountingWordsWithStreams.words(" ab   cd ef  ab ").toArray());
    }

    @Test
    @Grade(1)
    public void wordsCount_emptyCase() {
        assertEquals(0, CountingWordsWithStreams.wordsCount(""));
    }

    @Test
    @Grade(1)
    public void wordsCount_someWords() {
        assertEquals(1, CountingWordsWithStreams.wordsCount("abc"));
        assertEquals(4, CountingWordsWithStreams.wordsCount("ab cd ef ab"));
    }

    @Test
    @Grade(2)
    public void sortedWords() {
        assertTrue(CountingWordsWithStreams.sortedWords("").isEmpty());
        assertArrayEquals(new String[]{"abc"}, CountingWordsWithStreams.sortedWords("abc").toArray());
        assertArrayEquals(new String[]{"ab", "ab", "cd", "ef"}, CountingWordsWithStreams.sortedWords("ef ab cd ab").toArray());
    }

    @Test
    @Grade(2)
    public void distinctWords() {
        assertTrue(CountingWordsWithStreams.distinctWords("").isEmpty());
        assertArrayEquals(new String[]{"abc"}, CountingWordsWithStreams.distinctWords("abc").toArray());
        assertArrayEquals(new String[]{"ef", "ab", "cd"}, CountingWordsWithStreams.distinctWords("ef ab cd ab ef").toArray());
    }

    @Test
    @Grade(3)
    public void distinctSortedWords() {
        assertTrue(CountingWordsWithStreams.distinctSortedWords("").isEmpty());
        assertArrayEquals(new String[]{"abc"}, CountingWordsWithStreams.distinctSortedWords("abc").toArray());
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, CountingWordsWithStreams.distinctSortedWords("ef ab cd ab ef").toArray());
    }

    @Test
    @Grade(4)
    public void wordsUsageCount() {
        assertTrue(CountingWordsWithStreams.wordsUsageCount("").isEmpty());

        assertEquals(1, CountingWordsWithStreams.wordsUsageCount("abc").size());
        assertEquals(1, (long) CountingWordsWithStreams.wordsUsageCount("abc").get("abc"));


        Map<String, Long> usage = CountingWordsWithStreams.wordsUsageCount("ef ab cd ab ef gh ab");
        assertEquals(4, usage.size());
        assertEquals(3, (long) usage.get("ab"));
        assertEquals(1, (long) usage.get("cd"));
        assertEquals(2, (long) usage.get("ef"));
        assertEquals(1, (long) usage.get("gh"));
    }

    @Test
    @Grade(4)
    public void wordsUsageCountSortedByWord() {
        assertTrue(CountingWordsWithStreams.wordsUsageCountSortedByWord("").isEmpty());

        assertEquals(1, CountingWordsWithStreams.wordsUsageCountSortedByWord("abc").size());
        assertEquals(1, (long) CountingWordsWithStreams.wordsUsageCountSortedByWord("abc").get("abc"));

        Map<String, Long> usage = CountingWordsWithStreams.wordsUsageCountSortedByWord("ef ab cd ab ef gh ab");
        assertArrayEquals(new String[]{"ab", "cd", "ef", "gh"}, usage.keySet().toArray());
        assertArrayEquals(new Long[]{3L, 1L, 2L, 1L}, usage.values().toArray());
    }

    @Test
    @Grade(5)
    public void optional_wordsUsageCountSortedByCountThenWord() {
        assertTrue(CountingWordsWithStreams.wordsUsageCountSortedByCountThenWord("").isEmpty());

        assertEquals(1, CountingWordsWithStreams.wordsUsageCountSortedByCountThenWord("abc").size());
        assertEquals("abc", CountingWordsWithStreams.wordsUsageCountSortedByCountThenWord("abc").get(0).getKey());
        assertEquals(1, (long) CountingWordsWithStreams.wordsUsageCountSortedByCountThenWord("abc").get(0).getValue());

        List<Map.Entry<String, Long>> usage = CountingWordsWithStreams.wordsUsageCountSortedByCountThenWord("ef cd cd cd ab ab ab gh ef ef ef ef");
        assertArrayEquals(new String[]{"ef", "ab", "cd", "gh"}, usage.stream().map(Map.Entry::getKey).toArray());
        assertArrayEquals(new Long[]{5L, 3L, 3L, 1L}, usage.stream().map(Map.Entry::getValue).toArray());
    }
}
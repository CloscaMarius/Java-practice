package teme.w08_streams.ex6_word_count;

import java.util.*;

class CountingWordsWithStreams {

    /**
     * Given working implementation for this one.
     */
    static List<String> words(String text) {
        return text.trim().length() == 0 ?
                new ArrayList<>() :
                Arrays.asList(text.trim().split("\\s+"));
    }

    /**
     * Ok not to use streams for this one
     */
    static int wordsCount(String text) {
        //TODO
        return -1;
    }


    //--- These should be done using streams operations! ---//

    static Collection<String> sortedWords(String text) {
        //TODO
        return null;
    }

    static Collection<String> distinctWords(String text) {
        //TODO
        return null;
    }

    static Collection<String> distinctSortedWords(String text) {
        //TODO
        return null;
    }


    /**
     * Hint: more advanced, read more about grouping collectors:
     * https://dzone.com/articles/the-ultimate-guide-to-the-java-stream-api-grouping
     */
    static Map<String, Long> wordsUsageCount(String text) {
        //TODO
        return null;
    }

    /**
     * Hint: you may solve it similar to previous one, read about how you can tell the
     * grouping collectors to use a custom implementation of Map (instead of the default HashMap)
     */
    static Map<String, Long> wordsUsageCountSortedByWord(String text) {
        //TODO
        return null;
    }

    /**
     * Hint: start from result of wordsUsageCount(), which is a Map,
     * then build a stream() based on its entrySet(), and sort it in a custom way...
     */
    static List<Map.Entry<String, Long>> wordsUsageCountSortedByCountThenWord(String text) {
        //TODO
        return null;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        String text = "Once upon a time in a land far far away there lived a great king whose name was a great mystery";
        System.out.println("initial text: " + text);

        System.out.println("\nall words (initial order): " + words(text));
        System.out.println("word count: " + wordsCount(text));
        System.out.println("all words (sorted): " + sortedWords(text));
        System.out.println("distinct words (initial order): " + distinctWords(text));
        System.out.println("distinct words (sorted): " + distinctSortedWords(text));

        System.out.println("\nword counts (initial order): " + wordsUsageCount(text));
        System.out.println("word counts (sorted by word): " + wordsUsageCountSortedByWord(text));
        System.out.println("word counts (sorted by count, then word): " + wordsUsageCountSortedByCountThenWord(text));
    }
}

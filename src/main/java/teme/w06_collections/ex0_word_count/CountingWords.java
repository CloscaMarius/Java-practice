package teme.w06_collections.ex0_word_count;

import java.util.Collection;
import java.util.List;
import java.util.Map;

class CountingWords {

    //some manual tests
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

    static List<String> words(String text) {
        return null; //TODO
    }

    static int wordsCount(String text) {
        return -1; //TODO
    }

    static Collection<String> sortedWords(String text) {
        return null; //TODO
    }

    static Collection<String> distinctWords(String text) {
        return null; //TODO
    }

    static Collection<String> distinctSortedWords(String text) {
        return null; //TODO
    }

    static Map<String, Long> wordsUsageCount(String text) {
        return null; //TODO
    }

    static Map<String, Long> wordsUsageCountSortedByWord(String text) {
        return null; //TODO
    }

    static List<Map.Entry<String, Long>> wordsUsageCountSortedByCountThenWord(String text) {
        return null; //TODO
    }
}

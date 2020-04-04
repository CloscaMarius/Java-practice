package teme.w08_streams.ex6_word_count;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

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
        return words(text).size();
    }


    //--- These should be done using streams operations! ---//

    static Collection<String> sortedWords(String text) {
        //List<String> words = words(text);
        //        Collections.sort(words);
        //        return words;

        return words(text).stream().sorted().collect(Collectors.toList());
    }

    static Collection<String> distinctWords(String text) {
        //List<String> words = words(text);
        //        return new LinkedHashSet<>(words);

        //return words(text).stream().distinct().collect(Collectors.toList());
        return words(text).stream().collect(Collectors.toSet());
    }

    static Collection<String> distinctSortedWords(String text) {
        //List<String> words = words(text);
        //        return new TreeSet<>(words);

        return words(text).stream().distinct().sorted().collect(Collectors.toList());
    }


    /**
     * Hint: more advanced, read more about grouping collectors:
     * https://dzone.com/articles/the-ultimate-guide-to-the-java-stream-api-grouping
     */
    static Map<String, Long> wordsUsageCount(String text) {
        //Map<String, Long> result = new HashMap<>();
        //        for (String word : words(text)) {
        //            Long value = result.getOrDefault(word, 0L);
        //            result.put(word, value + 1);
        //        }
        //        return result;


        return words(text)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), counting()));
    }

    /**
     * Hint: you may solve it similar to previous one, read about how you can tell the
     * grouping collectors to use a custom implementation of Map (instead of the default HashMap)
     */
    static Map<String, Long> wordsUsageCountSortedByWord(String text) {
        //return new TreeMap<>(wordsUsageCount(text));

        return wordsUsageCount(text)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue,
                        TreeMap::new));

    }

    /**
     * Hint: start from result of wordsUsageCount(), which is a Map,
     * then build a stream() based on its entrySet(), and sort it in a custom way...
     */
    static List<Map.Entry<String, Long>> wordsUsageCountSortedByCountThenWord(String text) {
        //Map<String, Long> anotherMap = new LinkedHashMap<>(wordsUsageCount(text));
        //        List<Map.Entry<String, Long>> resultList = new LinkedList<>(anotherMap.entrySet());
        //
        //        resultList.sort(new SortDescByCountAndThenAlpha());
        //        return resultList;

        return wordsUsageCount(text)
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
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

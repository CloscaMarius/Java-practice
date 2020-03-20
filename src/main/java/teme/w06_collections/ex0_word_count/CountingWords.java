package teme.w06_collections.ex0_word_count;

import java.util.*;

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
        if (text.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.asList(text.trim().split("\\s+"));
    }

    static int wordsCount(String text) {
        return words(text).size();
    }

    static Collection<String> sortedWords(String text) {
        List<String> words = words(text);
        Collections.sort(words);
        return words;
    }

    static Collection<String> distinctWords(String text) {
        List<String> words = words(text);
        return new LinkedHashSet<>(words);
    }

    static Collection<String> distinctSortedWords(String text) {
        List<String> words = words(text);
        return new TreeSet<>(words);
    }

    static Map<String, Long> wordsUsageCount(String text) {
        Map<String, Long> result = new HashMap<>();
        for (String word : words(text)) {
            Long value = result.getOrDefault(word, 0L);
            result.put(word, value + 1);
        }
        return result;
    }

    static Map<String, Long> wordsUsageCountSortedByWord(String text) {
        return new TreeMap<>(wordsUsageCount(text));
    }

    static List<Map.Entry<String, Long>> wordsUsageCountSortedByCountThenWord(String text) {
        Map<String, Long> anotherMap = new LinkedHashMap<>(wordsUsageCount(text));
        List<Map.Entry<String, Long>> resultList = new LinkedList<>(anotherMap.entrySet());

        resultList.sort(new SortDescByCountAndThenAlpha());
        return resultList;
    }
}

class SortDescByCountAndThenAlpha implements Comparator<Map.Entry<String, Long>> {

    @Override
    public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
        int result = -o1.getValue().compareTo(o2.getValue());
        return result != 0 ? result :
                o1.getKey().compareTo(o2.getKey());
    }
}



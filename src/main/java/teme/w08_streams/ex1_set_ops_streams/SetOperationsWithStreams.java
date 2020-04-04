package teme.w08_streams.ex1_set_ops_streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SetOperationsWithStreams {

    /**
     * Should use only streams operations (no looping or addAll() methods)
     * Hint: read about stream concat() and/or flatMap()
     */
    static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        return Stream.concat(set1.stream(), set2.stream())
                .collect(Collectors.toSet());

    }

    /**
     * Should use stream operations here (no looping or retainAll() methods)
     * Hint: remember the filter() operation
     */
    static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        return set1.stream()
                .filter(set2::contains)
                .collect(Collectors.toSet());
    }

    /**
     * Should use stream operations here (no looping or removeAll() methods)
     */
    static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        return set1.stream()
                .filter(x -> !set2.contains(x))
                .collect(Collectors.toSet());
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        Set<String> set1 = new HashSet<>(Arrays.asList("aa", "bb", "cc"));
        Set<String> set2 = new HashSet<>(Arrays.asList("bb", "cc", "dd"));

        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);

        System.out.println("union: " + union(set1, set2));
        System.out.println("intersection: " + intersection(set1, set2));
        System.out.println("diff(set1-set2): " + difference(set1, set2));
        System.out.println("diff(set2-set1): " + difference(set2, set1));
    }
}

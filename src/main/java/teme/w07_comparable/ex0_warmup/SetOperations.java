package teme.w07_comparable.ex0_warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Collections.singletonList;

class SetOperations {

    static <E> Set<E> union(Set<E> set1, Set<E> set2) {
        Set<E> all = new HashSet<>(set1);
        all.addAll(set2);
        return all;
    }

    static <E> Set<E> intersection(Set<E> set1, Set<E> set2) {
        Set<E> intersection = new LinkedHashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    static <E> Set<E> difference(Set<E> set1, Set<E> set2) {
        Set<E> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        return differenceSet;
    }


    public static void main(String[] args) {

        Set<String> set1 = new HashSet<>(Arrays.asList("aa", "bb", "cc"));
        Set<String> set2 = new HashSet<>(Arrays.asList("bb", "cc", "dd"));
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);

        System.out.println("union: " + union(set1, set2));
        System.out.println("intersection: " + intersection(set1, set2));
        System.out.println("set1-set2: " + difference(set1, set2));
        System.out.println("set2-set1: " + difference(set2, set1));

        System.out.println(union(new HashSet<>(Arrays.asList(1, 3, 5)), new HashSet<>(Arrays.asList(3, 7, 8))));
        System.out.println(union(new HashSet<>(singletonList(true)), new HashSet<>(singletonList(false))));
    }
}


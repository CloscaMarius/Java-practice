package teme.w07_comparable.ex0_warmup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SetOperations {

    static Set<String> union(Set<String> set1, Set<String> set2) {
        //TODO
        return null;
    }

    static Set<String> intersection(Set<String> set1, Set<String> set2) {
        //TODO
        return null;
    }

    static Set<String> difference(Set<String> set1, Set<String> set2) {
        //TODO
        return null;
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

        //TODO: uncomment after making the method more generic
        /*
        System.out.println(union(new HashSet<>(Arrays.asList(1, 3, 5)), new HashSet<>(Arrays.asList(3, 7, 8))));
        System.out.println(union(new HashSet<>(singletonList(true)), new HashSet<>(singletonList(false))));
        */
    }
}


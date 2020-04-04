package teme.w08_streams.ex0_warmup;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;

class StreamsWarmup {

    //--- a) Common intermediary operations ---//
    static List<Integer> onlyBetween10And100(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 10 && n < 100)
                .collect(Collectors.toList());
    }

    static List<String> startWithLetterAndHaveLength(char letter, int wordLength, List<String> words) {
        return words.stream()
                .filter(s -> s.length() == wordLength
                        && s.startsWith(String.valueOf(letter)))
                .collect(Collectors.toList());
    }

    static List<String> withoutEmptyStringsAndChangedToUpperAndSorted(String[] arrayOfStrings) {
        return Arrays.stream(arrayOfStrings)
                .filter(s -> !s.trim().isEmpty())
                .map(s -> s.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }

    static String addLetterForEvenOdd(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> {
                    if (n % 2 == 0) {
                        return "e" + n;
                    } else {
                        return "o" + n;
                    }
                })
                .collect(Collectors.joining(","));
    }


    //--- b) Other intermediary operations ---//
    static List<Integer> only3Smallest(Integer[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }

    static List<Integer> only3SmallestNoDuplicates(Integer[] numbers) {
        return Arrays.stream(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }

    static List<Integer> only3BiggestNoDuplicates(Integer[] numbers) {
        return Arrays.stream(numbers)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
    }


    //--- c) Terminal operations ---//
    static long countOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).count();
    }

    static void printPositives(double[] numbers) {
        Arrays.stream(numbers)
                .filter(n -> n > 0)
                .forEach(System.out::println);
    }

    static boolean checkIfAllEven(List<Long> numbers) {
        return numbers.stream().allMatch(n -> n % 2 == 0);
    }

    static String findNameOfFirstPersonWithHairColor(List<Person> persons, HairColor color) {
        return persons.stream()
                .filter(p -> p.getHairColor() == color)
                .map(p -> p.getName())
                .findFirst()
                .orElse("NONE");
    }


    //--- d) Streams of primitives ---//
    static double averageAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }

    static String nameOfOldest(List<Person> persons) {
        Optional<Person> maybeOldest = persons.stream()
                .max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        Optional<String> maybeName = maybeOldest.map(Person::getName);
        return maybeName.orElse("NONE");
    }


    //--- e) Generate/Iterate ---//
    static List<Integer> powGreaterThan(int base, int minValue, int count) {
        return IntStream
                .iterate(1, i -> i * base)
                .filter(i -> i >= minValue)
                .limit(count)
                .boxed()
                .collect(Collectors.toList());
    }

    static List<Integer> allSquareNumbersBetween(int minValue, int maxValue) {
        return IntStream
                .range((int) Math.ceil(Math.sqrt(minValue)), (int) Math.sqrt(maxValue) + 1)
                .map(i -> i * i)
                .boxed()
                .collect(Collectors.toList());
    }


    //--- f) Grouping collectors ---//
    static Map<HairColor, List<Person>> groupedByHairColor(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getHairColor));
    }

    //OPTIONAL
    static Map<String, Long> countChars(String text) {
        String[] chars = text.trim().split("");
        return Arrays.stream(chars)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }


    //--- g) Flat map ---//
    //OPTIONAL
    static List<Integer> toFlatList(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(s -> Arrays.stream(s))
                .boxed()
                .collect(Collectors.toList());
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        Integer[] numbersArr = {-7, 1, 3, 7, 12, -30, 19, 55, 84, 120, 180, 5, 25, -30, 0, 120};
        List<Integer> numbers = Arrays.asList(numbersArr);

        System.out.println("numbers: " + numbers);
        System.out.println("onlyBetween10And100: " + onlyBetween10And100(numbers));
        System.out.println("only3Smallest: " + only3Smallest(numbersArr));
        System.out.println("only3SmallestNoDuplicates: " + only3SmallestNoDuplicates(numbersArr));
        System.out.println("only3BiggestNoDuplicates: " + only3BiggestNoDuplicates(numbersArr));

        System.out.println("\nprintPositives():");
        printPositives(new double[]{3, -5, 7.5, -2.3, 0, 99.9});

        System.out.println("\ncheckIfAllEven(0, 2, 8, -6, 12): " + checkIfAllEven(Arrays.asList(0L, 2L, 8L, -6L, 12L)));
        System.out.println("checkIfAllEven(0, 2, 8, -6, 12, 13): " + checkIfAllEven(Arrays.asList(0L, 2L, 8L, -6L, 12L, 13L)));

        System.out.println("\naddLetterForEvenOdd: " + addLetterForEvenOdd(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        System.out.println("startWithLetterAndHaveLength('a', 3, [\"aaabbccccd\", \"aaa\", \"bcd\"]: " +
                startWithLetterAndHaveLength('a', 3, Arrays.asList("aaabbccccd", "aaa", "bcd")));
        System.out.println("withoutEmptyStringsAndChangedToUpperAndSorted([\"\", \"zz\", \"aabb\", \"\", \"dd\", \"cc\", \"bcd\"]): " +
                withoutEmptyStringsAndChangedToUpperAndSorted(new String[]{"", "zz", "aabb", "", "dd", "cc", "bcd"}));

        List<Person> persons = Arrays.asList(
                new Person("Andrei", HairColor.BLACK, 20),
                new Person("Bogdan", HairColor.BROWN, 25),
                new Person("Codrin", HairColor.BROWN, 22),
                new Person("Diana", HairColor.BLONDE, 21));
        System.out.println("\nall persons: " + persons);
        System.out.println("findNameOfFirstPersonWithHairColor(BROWN): " + findNameOfFirstPersonWithHairColor(persons, HairColor.BROWN));
        System.out.println("findNameOfFirstPersonWithHairColor(RED): " + findNameOfFirstPersonWithHairColor(persons, HairColor.RED));

        System.out.println("averageAge: " + averageAge(persons));
        System.out.println("averageAge(empty list): " + averageAge(emptyList()));

        System.out.println("nameOfOldest: " + nameOfOldest(persons));
        System.out.println("nameOfOldest(empty list): " + nameOfOldest(emptyList()));

        System.out.println("groupedByHairColor: " + groupedByHairColor(persons));

        System.out.println("\npowGreaterThan(3, 1000, 10): " + powGreaterThan(3, 1000, 10));
        System.out.println("allSquareNumbersBetween(1000, 2500) :" + allSquareNumbersBetween(1000, 2500));

        System.out.println("\ncountChars('eeaaabbccccdaaxxyyy'): " + countChars("eeaaabbccccdaaxxyyy"));
        System.out.println("\ntoFlatList({{1, 2}, {3}, {4, 5, 6}, {7, 8}}): " + toFlatList(new int[][]{{1, 2}, {3}, {4, 5, 6}, {7, 8}}));
    }
}

package teme.w08_streams.ex2_fizzbuzz;

import java.util.stream.IntStream;

class FizzBuzzWithStreams {

    /**
     * Helper method translating ONE number to a single fizzbuzz value.
     * Ok to use regular code here (if-else..)
     * Then use this method in both imperative and stream methods below.
     */
    static String toFizzBuzz(int i) {
        if ((i % 3) == 0 && (i % 5) == 0) {
            return "fizzbuzz";
        } else if ((i % 3) == 0) {
            return "fizz";
        } else if (i % 5 == 0) {
            return "buzz";
        } else {
            return String.valueOf(i);
        }
    }

    /**
     * Method going over numbers 1..n and printing the fizzbuzz value for each.
     * <p>
     * Iterative version, may use loops, etc..
     */
    static void fizzBuzzImperative(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(toFizzBuzz(i));
        }
    }

    /**
     * Method going over numbers 1..n and printing the fizzbuzz value for each.
     * <p>
     * Functional version, should not use any explicit loops, but only streams operations.
     * <p>
     * Hint: read about IntStream.rangeClosed() method, and streams of primitives..
     */
    static void fizzBuzzWithStreams(int n) {
        IntStream.rangeClosed(1, n)
                .mapToObj(FizzBuzzWithStreams::toFizzBuzz)
                .forEach(System.out::println);
    }

    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        System.out.println("fizzbuzz(6) = " + toFizzBuzz(6));
        System.out.println("fizzbuzz(7) = " + toFizzBuzz(7));
        System.out.println("fizzbuzz(20) = " + toFizzBuzz(20));
        System.out.println("fizzbuzz(30) = " + toFizzBuzz(30));

        System.out.println("\nFizzBuzz up to 30 (imperative):");
        fizzBuzzImperative(30);

        System.out.println("\nFizzBuzz up to 30 (streams):");
        fizzBuzzWithStreams(30);
    }
}

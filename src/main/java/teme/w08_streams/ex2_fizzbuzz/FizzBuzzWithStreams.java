package teme.w08_streams.ex2_fizzbuzz;

class FizzBuzzWithStreams {

    /**
     * Helper method translating ONE number to a single fizzbuzz value.
     * Ok to use regular code here (if-else..)
     * Then use this method in both imperative and stream methods below.
     */
    static String toFizzBuzz(int i) {
        //TODO
        return "bzzz?";
    }

    /**
     * Method going over numbers 1..n and printing the fizzbuzz value for each.
     * <p>
     * Iterative version, may use loops, etc..
     */
    static void fizzBuzzImperative(int n) {
        //TODO
    }

    /**
     * Method going over numbers 1..n and printing the fizzbuzz value for each.
     * <p>
     * Functional version, should not use any explicit loops, but only streams operations.
     * <p>
     * Hint: read about IntStream.rangeClosed() method, and streams of primitives..
     */
    static void fizzBuzzWithStreams(int n) {
        //TODO
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

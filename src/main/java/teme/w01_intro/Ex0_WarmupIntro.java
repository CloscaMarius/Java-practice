package teme.w01_intro;

class Ex0_WarmupIntro {

    static int computeSum(int a, int b) {
        return a + b;
    }

    static double squareValue(double x) {
        return -1; //TODO: replace it with your code!
    }

    static String joinStrings(String s1, String s2) {
        return null; //TODO: replace it with your code!
    }

    static int lengthOf(String s) {
        return 0; //TODO: replace it with your code!
    }

    static int truncate(double x) {
        return -1; //TODO: replace it with your code!
    }

    static boolean isInInterval(int x, int min, int max) {
        return false; //TODO: replace it with your code!
    }

    static boolean sameLength(String s1, String s2) {
        return false; //TODO: replace it with your code!
    }

    static boolean atLeastOneTrue(boolean a, boolean b, boolean c) {
        return false; //TODO: replace it with your code!
    }

    static boolean allTrue(boolean a, boolean b, boolean c) {
        return false; //TODO: replace it with your code!
    }

    static boolean noneTrue(boolean a, boolean b, boolean c) {
        return false; //TODO: replace it with your code!
    }

    static boolean exactlyTwoTrue(boolean a, boolean b, boolean c) {
        return false; //TODO: replace it with your code!
    }

    /**
     * Main method, we use here just for easy manual testing of our methods above.
     * NOTE: after manual test run ok, don't forget to also run the automatic tests, see Ex0_Tests class!
     */
    public static void main(String[] args) {

        System.out.println("sum(2,3) = " + computeSum(2, 3));
        System.out.println("square(3) = " + squareValue(3));

        System.out.println();
        System.out.println("joinStrings('ab', 'cd') = '" + joinStrings("ab", "cd") + "'");
        System.out.println("lengthOf('abc') = " + lengthOf("abc"));
        System.out.println("truncate(3.21) = " + truncate(3.21));

        System.out.println();
        System.out.println("isInInterval(3, 0, 5) = " + isInInterval(3, 0, 5));
        System.out.println("isInInterval(3, 5, 10) = " + isInInterval(3, 5, 10));

        System.out.println();
        System.out.println("sameLength('abc', '123') = " + sameLength("abc", "123"));
        System.out.println("sameLength('ab', '1234') = " + sameLength("ab", "1234"));

        System.out.println();
        System.out.println("atLeastOneTrue(false, false, false) = " + atLeastOneTrue(false, false, false));
        System.out.println("atLeastOneTrue(true, false, false) = " + atLeastOneTrue(true, false, false));
        System.out.println("atLeastOneTrue(false, true, true) = " + atLeastOneTrue(false, true, true));

        System.out.println();
        System.out.println("allTrue(false, false, false) = " + allTrue(false, false, false));
        System.out.println("allTrue(false, true, true) = " + allTrue(false, true, true));
        System.out.println("allTrue(true, true, true) = " + allTrue(true, true, true));

        System.out.println();
        System.out.println("noneTrue(true, true, false) = " + noneTrue(true, true, false));
        System.out.println("noneTrue(false, false, true) = " + noneTrue(false, false, true));
        System.out.println("noneTrue(false, false, false) = " + noneTrue(false, false, false));

        System.out.println();
        System.out.println("exactlyTwoTrue(false, true, false) = " + exactlyTwoTrue(false, true, false));
        System.out.println("exactlyTwoTrue(true, true, true) = " + exactlyTwoTrue(true, true, true));
        System.out.println("exactlyTwoTrue(true, false, true) = " + exactlyTwoTrue(true, false, true));
    }
}

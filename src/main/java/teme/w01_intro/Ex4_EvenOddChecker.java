package teme.w01_intro;

class Ex4_EvenOddChecker {

    /**
     * Checks a given integer number if is even or odd
     *
     * @param n number to check, valid interval 1..1000
     * @return 0 if number is even, 1 if it's odd, or -1 if outside valid interval
     */
    static int convertEvenOddToZeroOne(int n) {
        //todo: write your code here
        return -2;
    }

    /**
     * Checks a given integer number if is even or odd
     *
     * @param n a number to check, valid interval 1..1000
     * @return "even" if number is even, "odd" if it's odd, or "invalid" if outside valid interval
     */
    static String convertEvenOddToString(int n) {
        //todo: write your code here
        return "?";
    }

    //manual tests
    public static void main(String[] args) {
        System.out.println("convertEvenOddToZeroOne(3): " + convertEvenOddToZeroOne(3));
        System.out.println("convertEvenOddToZeroOne(4): " + convertEvenOddToZeroOne(4));
        System.out.println("convertEvenOddToZeroOne(-9_999): " + convertEvenOddToZeroOne(-9_999));

        System.out.println("convertEvenOddToString(3): " + convertEvenOddToString(3));
        System.out.println("convertEvenOddToString(4): " + convertEvenOddToString(4));
        System.out.println("convertEvenOddToString(100_000): " + convertEvenOddToString(100_000));
    }
}

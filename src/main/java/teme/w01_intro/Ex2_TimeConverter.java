package teme.w01_intro;

class Ex2_TimeConverter {

    /**
     * Given a time duration expressed in a number of hours + some minutes + some seconds,
     * it converts it to a total number of milliseconds
     *
     * @param h number of hours (valid range: 0..23)
     * @param m number of minutes (valid range: 0..59)
     * @param s number of seconds (valid range: 0..59)
     * @return the total number of milliseconds, or -1 if any of the input parameters has invalid value
     */
    static int convertToMilliseconds(int h, int m, int s) {

        //TODO: fill in your code here!

        return -1;
    }

    /**
     * Main method added just to easily run some manual tests (for automatic tests see separate class)
     */
    public static void main(String[] args) {
        testConvert(0, 0, 0);
        testConvert(0, 0, 2);
        testConvert(0, 2, 0);
        testConvert(2, 0, 0);
        testConvert(1, 2, 3); //1h + 2min + 3sec => should result in: 3 723 000 ms
        testConvert(1, 62, 0); //1h + 61min + 0 sec => invalid range (for min), should return: -1
        testConvert(25, 0, 0); //1h + 61min + 0 sec => invalid range (for min), should return: -1
    }

    private static void testConvert(int h, int m, int s) {
        System.out.println(h + "h + " + m + "m + " + s + "s => " + convertToMilliseconds(h, m, s) + " ms");
    }
}

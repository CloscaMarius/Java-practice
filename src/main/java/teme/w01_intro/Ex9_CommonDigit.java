package teme.w01_intro;

class Ex9_CommonDigit {

    /**
     * Helper method, which just checks if a number is in expected range (13..89)
     *
     * @param n the number to check
     * @return true if number is valid (is between 13 and 89), false otherwise
     */
    static boolean isValid(int n) {
        return n >= 13 && n <= 89;
    }

    /**
     * Checks if 2 numbers have at least 1 common digit
     *
     * @param x 1st number (valid range: 13..89)
     * @param y 2nd number (valid range: 13..89)
     * @return true if both numbers are in valid range and have at least 1 common digit, false otherwise
     */
    static boolean haveACommonDigit(int x, int y) {
        //Hint: for easier working, you may first extract the 2 digits of x,y to 4 separate int variables..
        return digitExtraction(x, y);
    }

    static boolean digitExtraction(int x, int y) {
        int x1 = x / 10;
        int x2 = x % 10;
        int y1 = y / 10;
        int y2 = y % 10;
        return verifyingNumbers(x, y) && (x1 == y1 || x1 == y2 || x2 == y1 || x2 == y2);
    }

    static boolean verifyingNumbers(int x, int y) {
        return isValid(x) ? isValid(y) ? true : false : false;
    }

    //manual tests
    public static void main(String[] args) {
        System.out.println("12 is valid?: " + isValid(12));
        System.out.println("90 is valid?: " + isValid(90));
        System.out.println("14 is valid?: " + isValid(14));

        System.out.println("30 and 10 have common digit?: " + haveACommonDigit(30, 10)); //invalid
        System.out.println("34 and 48 have common digit?: " + haveACommonDigit(34, 48)); //yes
        System.out.println("34 and 43 have common digit?: " + haveACommonDigit(34, 43)); //yes (double)
        System.out.println("34 and 81 have common digit?: " + haveACommonDigit(34, 81)); //no
    }
}

package teme.w01_intro;

class Ex9_CommonDigit {

    /**
     * Helper method, which just checks if a number is in expected range (13..89)
     *
     * @param n the number to check
     * @return true if number is valid (is between 13 and 89), false otherwise
     */
    static boolean isValid(int n) {
        //TODO: your code here!
        return false;
    }

    /**
     * Checks if 2 numbers have at least 1 common digit
     *
     * @param x 1st number (valid range: 13..89)
     * @param y 2nd number (valid range: 13..89)
     * @return true if both numbers are in valid range and have at least 1 common digit, false otherwise
     */
    static boolean haveACommonDigit(int x, int y) {
        //TODO: your code here
        //Hint: for easier working, you may first extract the 2 digits of x,y to 4 separate int variables..
        return false;
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

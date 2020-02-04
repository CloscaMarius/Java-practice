package teme.w01_intro;

class Ex3_HeightConverter {

    //helper constants showing the relation between foot/inch and cm
    static final double CM_IN_ONE_FOOT = 30.48;
    static final double CM_IN_ONE_INCH = 2.54;

    /**
     * Convert a length value of X feet + Y inches to equivalent Z centimeters (rounded down to an integer value)
     *
     * @param feet   number of feet
     * @param inches number of inches
     * @return equivalent length in centimeters
     */
    static int convertToCentimeters(int feet, int inches) {

        //TODO: write your code here!
        return -1;
    }

    static String convertToFeetAndInches(int centimeters) {

        //todo: write your code here, to convert cm to a String value like: 'X feet, Y inches'
        int feet = -1; //??
        int inches = -1; //??

        return feet + " feet, " + inches + " inches";
    }

    /**
     * Main method, just for running manual tests
     */
    public static void main(String[] args) {
        //0feet + 3inches = 7.62 cm => should return 7 cm
        System.out.println("convertToCentimeters( 0 feet + 3 inches) = " + convertToCentimeters(0, 3));

        //2feet + 3inches => should return 68 cm
        System.out.println("convertToCentimeters( 2 feet + 3 inches) = " + convertToCentimeters(2, 3));

        //convert 69cm to feet+inches => should return: "2 feet, 3 inches"
        System.out.println("convertToFeetAndInches(68 cm) = '" + convertToFeetAndInches(69) + "'");
    }
}

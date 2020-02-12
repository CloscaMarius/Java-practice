package teme.w01_intro;

class Ex1a_CheckTriangleByAngles {


    //========== THE 2 METHODS YOU NEED TO COMPLETE/FIX! ==========//
    //You should:
    // - complete missing code/fix these methods...
    // - ...then run tests from Ex1a_Tests class
    // - repeat until all tests pass successfully :)
    //-------------------------------------------------------------//

    /**
     * Method which computes if 3 given ANGLE values (in degrees) can be the angles of a valid triangle
     *
     * @return true if they can form a triangle, false otherwise
     */
    static boolean canFormValidTriangle(int angle1, int angle2, int angle3) {

        return anglesPositive(angle1, angle2, angle3) && (angle1 + angle2 + angle3 == 180); //<--- REPLACE THIS WITH YOUR CODE!
    }

    static boolean anglesPositive(int angle1, int angle2, int angle3) {
        return angle1 > 0 && angle2 > 0 && angle3 > 0;
    }

    /**
     * Method which computes if 3 given ANGLE values (in degrees):
     * - can form a valid triangle
     * - AND that triangle is also right-angled
     *
     * @return true if they can form a right-angled triangle, false otherwise
     */
    static boolean canFormValidRightAngledTriangle(int angle1, int angle2, int angle3) {

        //HINT: you may also reuse/call here the method 'canFormValidTriangle' (if you fixed that one) to first check the triangle is valid..

        return canFormValidTriangle(angle1, angle2, angle3) && (angle1 == 90 || angle2 == 90 || angle3 == 90); //<--- REPLACE THIS WITH YOUR CODE!
    }

    //========== METHOD FOR MANUAL TESTING ==========//

    /**
     * MAIN method, you can use it to easily run some manual tests (before running all automatic tests from separate test class)
     */
    public static void main(String[] args) {
        testIt(-10, -100, 90);
        testIt(0, 0, 0);
        testIt(0, 0, 180);
        testIt(0, 90, 90);
        testIt(90, 90, 90);
        testIt(10, 10, 10);
        testIt(10, 30, 50);
        testIt(60, 60, 60);
        testIt(120, 30, 30);
        testIt(30, 60, 90);
        testIt(90, 20, 70);
    }

    //helper method, for manual tests
    private static void testIt(int angle1, int angle2, int angle3) {
        System.out.println("\nAngles (" + angle1 + "," + angle2 + "," + angle3 + ") -> " +
                "valid triangle? : " + canFormValidTriangle(angle1, angle2, angle3));
        System.out.println("Angles (" + angle1 + "," + angle2 + "," + angle3 + ") -> " +
                "right-angle triangle? : " + canFormValidRightAngledTriangle(angle1, angle2, angle3));
    }
}

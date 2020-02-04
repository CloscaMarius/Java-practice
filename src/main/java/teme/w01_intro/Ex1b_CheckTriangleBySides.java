package teme.w01_intro;

class Ex1b_CheckTriangleBySides {

    //========== THE 2 METHODS YOU NEED TO COMPLETE/FIX! ==========//
    //You should:
    // - complete missing code/fix these methods...
    // - ...then run tests from Ex1b_Tests class
    // - repeat until all tests pass successfully :)
    //=============================================================//

    /**
     * Method which computes if 3 given LENGTH values can be the sides of a valid triangle
     *
     * @return true if they can form a triangle, false otherwise
     */
    static boolean canFormValidTriangle(int side1, int side2, int side3) {

        //TODO: write your logic here, so it returns true/false as needed

        return false; //<--- REPLACE THIS WITH YOUR CODE!
    }

    /**
     * Method which computes if 3 given LENGTH values:
     * - can be the sides of a valid triangle
     * - AND that triangle is also right-angled
     *
     * @return true if they can form a right-angled triangle, false otherwise
     */
    static boolean canFormValidRightAngledTriangle(int side1, int side2, int side3) {

        //TODO: write your logic here, so it returns true/false as needed
        //HINT: you may also reuse/call here the method 'canFormValidTriangle' (if you fixed that one) to first check the triangle is valid..

        return false; //<--- REPLACE THIS WITH YOUR CODE!
    }

    //========== METHOD FOR MANUAL TESTING ==========//

    /**
     * MAIN method, you can use it to easily run some manual tests (before running all automatic tests from separate test class)
     */
    public static void main(String[] args) {
        testIt(1, 2, 4);
        testIt(4, 1, 3);
        testIt(1, 2, 2);
        testIt(3, 4, 5);
        testIt(-1, -2, -2);
        testIt(0, 0, 0);
    }

    //helper method, for manual tests
    private static void testIt(int side1, int side2, int side3) {
        System.out.println("\nSides (" + side1 + "," + side2 + "," + side3 + ") -> " +
                "valid triangle? : " + canFormValidTriangle(side1, side2, side3));
        System.out.println("Sides (" + side1 + "," + side2 + "," + side3 + ") -> " +
                "right-angle triangle? : " + canFormValidRightAngledTriangle(side1, side2, side3));
    }
}

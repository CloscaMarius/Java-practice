package teme.w03_recap;

import java.util.Arrays;

class Ex8_BinarySearch {

    //--- a) FOR ITERATIVE VERSION ---//

    /**
     * Iterative version.
     * Searches for value x in whole given array, returns true if found
     */
    static boolean contains(int x, int[] array) {
        int beginIdx = 0, endIdx = array.length - 1;
        while (beginIdx <= endIdx) {
            int m = beginIdx + (endIdx - beginIdx) / 2;

            if (array[m] == x)
                return true;

            if (array[m] < x)
                beginIdx = m + 1;


            else
                endIdx = m - 1;
        }

        return false;
    }


    //--- b) FOR RECURSIVE VERSION ---//

    /**
     * Recursive version.
     * Searches for value x in given array, but only in specified range (between beginIdx and endIdx, inclusive)
     * May call itself as needed (but with other params - different begin/end idx values)
     */
    private static boolean containsRec(int x, int[] array, int beginIdx, int endIdx) {
        if (endIdx >= beginIdx) {
            int mid = beginIdx + (endIdx - beginIdx) / 2;

            if (array[mid] == x)
                return true;


            if (array[mid] > x)
                return containsRec(x, array, beginIdx, mid - 1);


            return containsRec(x, array, mid + 1, endIdx);
        }

        return false;
    }

    /**
     * Just a helper function for the recursive version, for easier calling by clients/tests
     * (without needing to specify begin/end idx values)
     */
    static boolean containsRecStart(int x, int[] array) {
        return containsRec(x, array, 0, array.length - 1);
    }


    //--- FOR MANUAL TESTS ---//
    public static void main(String[] args) {
        System.out.println("\nITERATIVE - TRUE cases:");
        testContains(2, new int[]{2, 3, 4});
        testContains(2, new int[]{2, 3, 4});
        testContains(3, new int[]{2, 3, 4});
        testContains(4, new int[]{2, 3, 4});
        testContains(3, new int[]{1, 2, 3, 4, 5});
        System.out.println("\nITERATIVE - FALSE cases:");
        testContains(1, new int[]{});
        testContains(1, new int[]{2});
        testContains(1, new int[]{2, 3});
        testContains(7, new int[]{1, 2, 3, 4, 5});
        testContains(2, new int[]{1, 3, 5});

        System.out.println("\nRECURSIVE - TRUE cases:");
        testContainsRec(2, new int[]{2, 3, 4});
        testContainsRec(3, new int[]{2, 3, 4});
        testContainsRec(4, new int[]{2, 3, 4});
        testContainsRec(3, new int[]{1, 2, 3, 4, 5});
        System.out.println("\nRECURSIVE - FALSE cases:");
        testContainsRec(1, new int[]{});
        testContainsRec(1, new int[]{2});
        testContainsRec(1, new int[]{2, 3});
        testContainsRec(7, new int[]{1, 2, 3, 4, 5});
        testContainsRec(2, new int[]{1, 3, 5});
    }

    private static void testContains(int x, int[] array) {
        System.out.println(Arrays.toString(array) + " contains " + x + " ? : " + contains(x, array));
    }

    private static void testContainsRec(int x, int[] array) {
        System.out.println("recursive version: " + Arrays.toString(array) + " contains " + x + " ? : " + containsRecStart(x, array));
    }
}

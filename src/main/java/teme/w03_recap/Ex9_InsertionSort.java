package teme.w03_recap;

import java.util.Arrays;

class Ex9_InsertionSort {

    /**
     * Receives an array and sorts it in place, using Insertion sort algorithm
     */
    static void sort(int[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        testSort(new int[]{});
        testSort(new int[]{1});
        testSort(new int[]{2, 1});
        testSort(new int[]{1, 2, 3});
        testSort(new int[]{1, 3, 2});
        testSort(new int[]{5, 2, 3, 1, 4});
        testSort(new int[]{6, 5, 4, 3, 2, 1});
    }

    //helper function for main
    private static void testSort(int[] arr) {
        String contentBeforeSort = Arrays.toString(arr);
        sort(arr);
        System.out.println("Sorting " + contentBeforeSort + " => " + Arrays.toString(arr));
    }
}

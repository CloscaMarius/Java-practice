package teme.w03_recap;

import java.util.Arrays;

class Ex11_MergeSort {

    static int[] sort(int[] array) {

        if (array.length > 1) {
            int mid = array.length / 2;
            int[] first = Arrays.copyOfRange(array, 0, mid);
            Ex9_InsertionSort.sort(first);

            int[] second = Arrays.copyOfRange(array, mid, array.length);
            Ex9_InsertionSort.sort(second);

            array = Ex10_MergeSortedArrays.merge(first, second);

        }
        return array;
    }


    public static void main(String[] args) {
        testSort(new int[]{});
        testSort(new int[]{1});
        testSort(new int[]{1, 2});
        testSort(new int[]{2, 1});
        testSort(new int[]{1, 3, 2});
        testSort(new int[]{1, 3, 2, 4});
        testSort(new int[]{3, 4, 1, 2});
        testSort(new int[]{4, 3, 2, 1});
        testSort(new int[]{5, 3, 4, 1, 2, 6});
        testSort(new int[]{2, 1, 3, 1, 3, 2});
    }

    private static void testSort(int[] arr) {
        System.out.println("Sorting " + Arrays.toString(arr) + " => " + Arrays.toString(sort(arr)));
    }
}

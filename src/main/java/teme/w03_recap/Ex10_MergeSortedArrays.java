package teme.w03_recap;

import java.util.Arrays;

class Ex10_MergeSortedArrays {

    static int[] merge(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        int[] merged = new int[arr1Length + arr2Length];

        int arr1Position, arr2Position, mergedPosition;
        arr1Position = arr2Position = mergedPosition = 0;

        while (arr1Position < arr1Length && arr2Position < arr2Length) {
            if (arr1[arr1Position] < arr2[arr2Position]) {
                merged[mergedPosition++] = arr1[arr1Position++];
            } else {
                merged[mergedPosition++] = arr2[arr2Position++];
            }
        }

        while (arr1Position < arr1Length) {
            merged[mergedPosition++] = arr1[arr1Position++];
        }

        while (arr2Position < arr2Length) {
            merged[mergedPosition++] = arr2[arr2Position++];
        }

        return merged;
    }

    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        testMerge(new int[]{}, new int[]{});

        testMerge(new int[]{}, new int[]{1});
        testMerge(new int[]{1}, new int[]{});

        testMerge(new int[]{1, 2}, new int[]{});
        testMerge(new int[]{}, new int[]{1, 2});

        testMerge(new int[]{1}, new int[]{2});
        testMerge(new int[]{2}, new int[]{1});

        testMerge(new int[]{3}, new int[]{1, 2});
        testMerge(new int[]{1, 2, 4}, new int[]{3});

        testMerge(new int[]{1, 3, 5}, new int[]{2, 4});
        testMerge(new int[]{1, 3, 5}, new int[]{0, 2, 4, 6});

        testMerge(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    private static void testMerge(int[] arr1, int[] arr2) {
        System.out.println("merging: " + Arrays.toString(arr1) + " + " + Arrays.toString(arr2) +
                " => " + Arrays.toString(merge(arr1, arr2)));
    }
}

package teme.w02_flow;

import java.util.Arrays;

class Ex9_ReverseArray {

    static String[] reversedCopy(String[] arr) {

        String[] reversedArr = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < reversedArr.length / 2; i++) {
            String temp = reversedArr[i];
            reversedArr[i] = reversedArr[reversedArr.length - i - 1];
            reversedArr[reversedArr.length - i - 1] = temp;
        }

        System.out.println("array after reverse: " + Arrays.toString(reversedArr));
        return reversedArr;
    }

    static void reverse(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        System.out.println("array after reverse: " + Arrays.toString(arr));
    }

    //helper method - swaps the elements at 2 given indices, in an array
    static void swapPositions(String[] arr, int i, int j) {

    }

    public static void main(String[] args) {
        String[] arr = {"aa", "bb", "cc", "dd", "ee"};
        System.out.println("initial:  " + Arrays.toString(arr));

        System.out.println("a reversed copy: " + Arrays.toString(reversedCopy(arr)));

        System.out.println("initial after making the copy (should be unchanged): " + Arrays.toString(arr));

        reverse(arr);
        System.out.println("initial after reverse(): " + Arrays.toString(arr));
    }
}

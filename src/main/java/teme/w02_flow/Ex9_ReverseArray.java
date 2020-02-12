package teme.w02_flow;

import java.util.Arrays;

class Ex9_ReverseArray {

    static String[] reversedCopy(String[] arr) {
        //TODO
        return arr;
    }

    static void reverse(String[] arr) {
        //TODO
    }

    //helper method - swaps the elements at 2 given indices, in an array
    static void swapPositions(String[] arr, int i, int j) {
        //TODO
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

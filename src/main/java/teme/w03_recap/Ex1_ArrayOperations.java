package teme.w03_recap;

import java.util.Arrays;

class Ex1_ArrayOperations {

    static int[] append(int[] array, int elem) {
        //TODO!
        return null;
    }

    static int[] removeLast(int[] array) {
        //TODO
        return null;
    }

    static int[] concat(int[] array1, int[] array2) {
        //TODO
        return null;
    }

    static boolean contains(int[] array, int elem) {
        //TODO
        return false;
    }

    static int indexOf(int[] array, int elem) {
        //TODO
        return -1;
    }

    static int lastIndexOf(int[] array, int elem) {
        //TODO
        return -1;
    }

    static int[] filterPositives(int[] array) {
        //TODO
        return null;
    }


    //some manual tests
    public static void main(String[] args) {
        System.out.println(Arrays.toString(append(new int[]{1, 2, 3}, 4)));
        System.out.println(Arrays.toString(removeLast(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(concat(new int[]{1, 2, 3}, new int[]{4, 5, 6})));

        System.out.println(contains(new int[]{1, 2, 3}, 7));
        System.out.println(contains(new int[]{1, 2, 3}, 2));

        System.out.println(indexOf(new int[]{10, 20, 30, 20}, 20));
        System.out.println(indexOf(new int[]{10, 20, 30, 20}, 70));

        System.out.println(lastIndexOf(new int[]{10, 20, 30, 20}, 20));
        System.out.println(lastIndexOf(new int[]{10, 20, 30, 20}, 70));

        System.out.println(Arrays.toString(filterPositives(new int[]{10, -20, 30, -40, 50})));
    }
}

package teme.w03_recap;

import java.util.Arrays;

class Ex1_ArrayOperations {

    static int[] append(int[] array, int elem) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = elem;
        return newArray;
    }

    static int[] removeLast(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int[] result = new int[array.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    static int[] concat(int[] array1, int[] array2) {
        int[] concatArray = new int[array1.length + array2.length];
        int i = 0;
        for (int element1 : array1) {
            concatArray[i] = element1;
            i++;
        }
        for (int element2 : array2) {
            concatArray[i] = element2;
            i++;
        }
        return concatArray;
    }

    static boolean contains(int[] array, int elem) {
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) {
                return true;
            }
        }
        return false;
    }

    static int indexOf(int[] array, int elem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    static int lastIndexOf(int[] array, int elem) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) {
                index = i;
            }
        }
        return index;
    }

    static int[] filterPositives(int[] array) {
        int count = 0;
        for (int element1 : array) {
            if (element1 < 0) {
                count++;
            }
        }
        int[] newArray = new int[array.length - count];
        int i = 0;
        for (int element2 : array) {
            if (element2 >= 0) {
                newArray[i] = element2;
                i++;
            }
        }
        return newArray;
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

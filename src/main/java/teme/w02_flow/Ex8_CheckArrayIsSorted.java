package teme.w02_flow;

class Ex8_CheckArrayIsSorted {

    /**
     * @param arr - array of numbers to be sorted (given as varargs here, for easier testing)
     * @return true if array is sorted in ascending order, false otherwise
     */
    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    return false;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{}));
        System.out.println(isSorted(new int[]{1}));
        System.out.println(isSorted(new int[]{1, 1, 2}));
        System.out.println(isSorted(new int[]{1, 2, 3, 5}));
        System.out.println(isSorted(new int[]{1, 2, 4, 3, 5}));
    }
}

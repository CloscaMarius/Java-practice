package teme.w02_flow;

import java.util.Arrays;

class Ex7_FilterArray {

    static int[] onlyOdd(int[] array) {

        int numberOfOdds = 0;
        int[] oddNumbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                oddNumbers[numberOfOdds] += array[i];
                numberOfOdds++;
            }
        }
        int[] result = Arrays.copyOf(oddNumbers, numberOfOdds);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        onlyOdd(new int[]{1, 2, 3, 4, 5})));
    }
}

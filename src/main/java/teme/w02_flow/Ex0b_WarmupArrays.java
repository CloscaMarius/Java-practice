package teme.w02_flow;

import java.util.Arrays;

class Ex0b_WarmupArrays {

    static double sum(double[] arr) {
        double sumArr = 0;
        for (double i : arr) {
            sumArr += i;
        }
        return sumArr;
    }

    static double avg(double[] arr) {
        return sum(arr) / arr.length;
    }

    static double max(double[] arr) {
        double max = Double.NEGATIVE_INFINITY;
        for (double value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    static double sumPositives(double[] arr) {
        double sum = 0;
        for (double i : arr) {
            if (i < 0) {
                break;
            }
            sum += i;
        }
        return sum;
    }

    static void multiply(double[] arr, double x) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= x;
        }
    }


    public static void main(String[] args) {

        double[] values1 = {1.1, 2.2, 3.3, 4.4};
        System.out.println("\nsum(" + Arrays.toString(values1) + ") = " + sum(values1));
        System.out.println("avg(" + Arrays.toString(values1) + ") = " + avg(values1));
        System.out.println("max(" + Arrays.toString(values1) + ") = " + max(values1));

        double[] values2 = {}; //an empty array
        System.out.println("\nsum(" + Arrays.toString(values2) + ") = " + sum(values2));
        System.out.println("avg(" + Arrays.toString(values2) + ") = " + avg(values2));
        System.out.println("max(" + Arrays.toString(values2) + ") = " + max(values2));

        double[] values3 = {1, 2, 3, -4, 5, 6};
        System.out.println("\nsumPositives(" + Arrays.toString(values3) + ") = " + sumPositives(values3));

        System.out.println("\ninitial array: " + Arrays.toString(values3));
        multiply(values3, 10);
        System.out.println("array after calling multiply() with factor 10: " + Arrays.toString(values3));
    }
}

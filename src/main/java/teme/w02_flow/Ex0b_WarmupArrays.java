package teme.w02_flow;

import java.util.Arrays;

class Ex0b_WarmupArrays {

    static double sum(double[] arr) {
        //TODO
        return -1;
    }

    static double avg(double[] arr) {
        //TODO
        return -1;
    }

    static double max(double[] arr) {
        //TODO
        return -1;
    }


    static double sumPositives(double[] arr) {
        //TODO
        return -1;
    }

    static void multiply(double[] arr, double x) {
        //TODO
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

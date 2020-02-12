package teme.w02_flow;

import java.util.Arrays;

class Ex5_Fibonacci {

    static int fibonacci(int n) {
        //TODO
        return -1;
    }

    static int[] fibonacciSequence(int n) {
        //TODO
        return null;
    }

    public static void main(String[] args) {
        System.out.println("fibonacci(0) = " + fibonacci(0));
        System.out.println("fibonacci(1) = " + fibonacci(1));
        System.out.println("fibonacci(2) = " + fibonacci(2));
        System.out.println("fibonacci(3) = " + fibonacci(3));
        System.out.println("fibonacci(4) = " + fibonacci(4));
        System.out.println("fibonacci(10) = " + fibonacci(10));
        System.out.println("fibonacci(20) = " + fibonacci(20));

        System.out.println("\nfibonacciSequence(0): " + Arrays.toString(fibonacciSequence(0)));
        System.out.println("fibonacciSequence(1): " + Arrays.toString(fibonacciSequence(1)));
        System.out.println("fibonacciSequence(5): " + Arrays.toString(fibonacciSequence(5)));
        System.out.println("fibonacciSequence(25): " + Arrays.toString(fibonacciSequence(25)));
    }
}

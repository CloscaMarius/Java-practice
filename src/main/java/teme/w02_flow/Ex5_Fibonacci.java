package teme.w02_flow;

import java.util.Arrays;

class Ex5_Fibonacci {

    static int fibonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int fib = 0;
        if (n > 2) {
            for (int i = 1; i < n; i++) {

                fib = f0 + f1;
                f0 = f1;
                f1 = fib;
            }
        } else if (n == 0) {
            fib = f0;
        } else if (n == 1) {
            fib = f0 + f1;
        } else if (n == 2) {
            fib = f0 + f1;
        }
        return fib;
    }

    static int[] fibonacciSequence(int n) {
        int[] fibonacciNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            fibonacciNumbers[i] += fibonacci(i);
        }


        return fibonacciNumbers;
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

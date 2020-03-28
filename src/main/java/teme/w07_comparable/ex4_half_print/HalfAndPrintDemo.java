package teme.w07_comparable.ex4_half_print;

import java.util.Arrays;


public class HalfAndPrintDemo {

    public static void main(String[] args) {

        Compute computer = new Compute();
        Function halfFunc = (Function) new HalfFunction();
        Function printFunc = (Function) new PrintFunction();

        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Input values: " + Arrays.toString(values));

        System.out.println("\nApplying just printFunc to input values:");
        computer.compute(values, printFunc);

        System.out.println("\nApplying halfFunc then printFunc to input values:");
        computer.compute(
                computer.compute(values, halfFunc),
                printFunc);
    }
}

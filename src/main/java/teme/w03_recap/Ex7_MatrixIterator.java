package teme.w03_recap;

import java.util.Arrays;

class Ex7_MatrixIterator {

    static int sumAll(int[][] matrix) {
        //TODO
        return -1;
    }

    static int sumDiag1(int[][] matrix) {
        //TODO
        return -1;
    }

    static int[] elementsDiag2(int[][] matrix) {
        //TODO
        return null;
    }

    static int sumPerimeter(int[][] matrix) {
        //TODO
        return -1;
    }


    //Helper function, jus for displaying the matrix
    private static void display(int[][] matrix) {
        String s = "";
        for (int[] row : matrix) {
            for (int elem : row) {
                s += elem + " ";
            }
            s += "\n";
        }
        System.out.println("\nThe matrix:\n" + s);
    }

    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        printInfo(new int[][]{});

        printInfo(new int[][]{
                {1}});

        printInfo(new int[][]{
                {1, 2},
                {3, 4}});

        printInfo(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});

        printInfo(new int[][]{
                {1, 1, 1, 1},
                {1, 2, 3, 1},
                {1, 4, 5, 1},
                {1, 1, 1, 1}});

        printInfo(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}});
    }

    private static void printInfo(int[][] m) {
        display(m);
        System.out.println("sumAll: " + sumAll(m));
        System.out.println("sumDiag1: " + sumDiag1(m));
        System.out.println("elementsDiag2: " + Arrays.toString(elementsDiag2(m)));
        System.out.println("sumPerimeter: " + sumPerimeter(m));
    }
}

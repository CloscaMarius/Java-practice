package teme.w03_recap;

import java.util.Arrays;

class Ex7_MatrixIterator {

    static int sumAll(int[][] matrix) {
        int result = 0;
        for (int row[] : matrix) {
            for (int number : row) {
                result += number;
            }
        }
        return result;
    }

    static int sumDiag1(int[][] matrix) {
        int result = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    result += matrix[row][col];
                }
            }
        }
        return result;
    }

    static int[] elementsDiag2(int[][] matrix) {
        int[] result = new int[matrix.length];
        int index = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = matrix.length - 1; col >= 0; col--) {
                if (row + col == matrix.length - 1) {
                    result[index] += matrix[row][col];
                    index++;
                }
            }
        }
        return result;
    }

    static int sumPerimeter(int[][] matrix) {
        int sum = 0;
        if (matrix.length == 1) {
            sum = matrix[0][0];
        } else {
            for (int row = 0; row <= matrix.length - 1; row++) {
                for (int col = 0; col <= matrix.length - 1; col++) {
                    if (row == 0) {
                        sum += matrix[row][col];
                    }
                    if (row == matrix.length - 1) {
                        sum += matrix[row][col];
                    }
                }
            }
            for (int row = 1; row < matrix.length - 1; row++) {
                for (int col = 0; col <= matrix.length - 1; col++) {
                    if (col == 0) {
                        sum += matrix[row][col];
                    }
                    if (col == matrix.length - 1) {
                        sum += matrix[row][col];
                    }
                }
            }
        }
        return sum;
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

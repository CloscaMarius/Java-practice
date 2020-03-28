package teme.w07_comparable.ex4_half_print;

class Compute {

    int[] compute(int[] values, Function function) {

        int[] intArray = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            intArray[i] = function.evaluate(values[i]);
        }

        return intArray;
    }
}

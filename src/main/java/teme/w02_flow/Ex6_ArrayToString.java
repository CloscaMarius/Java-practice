package teme.w02_flow;

class Ex6_ArrayToString {

    static String arrayToString(double[] array) {

        String result = "";

        for (int s = 0; s < array.length; s++) {

            result += String.valueOf(String.format("%.2f", array[s]));
            if (s < array.length - 1) {
                result += ", ";
            }
        }
        result = String.format("[%s]", result);
        return result;


    }


    public static void main(String[] args) {
        System.out.println(arrayToString(new double[]{}));
        System.out.println(arrayToString(new double[]{1.1, 2.345, 3.0}));
    }
}

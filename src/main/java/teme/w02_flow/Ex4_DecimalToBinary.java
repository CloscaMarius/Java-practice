package teme.w02_flow;

class Ex4_DecimalToBinary {

    static String decimalToBinary(int n) {

        if (n == 0) {
            return "0";
        }
        String binaryNumber = "";
        for (; n > 0; ) {
            int i = n % 2;
            binaryNumber = i + binaryNumber;
            n = n / 2;
        }
        return binaryNumber;
    }


    /**
     * Just for manual testing
     */
    public static void main(String[] args) {
        System.out.println(decimalToBinary(0));
        System.out.println(decimalToBinary(1));
        System.out.println(decimalToBinary(2));
        System.out.println(decimalToBinary(3));
        System.out.println(decimalToBinary(4));
        System.out.println(decimalToBinary(10));
    }
}

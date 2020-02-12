package teme.w02_flow;

class Ex0a_WarmupFlow {

    static String xTimes(String s, int n) {
        //TODO
        return "?";
    }

    static int sumSquares(int n) {
        //TODO
        return -1;
    }

    
    static long factorial(int n) {
        //TODO
        return -1;
    }

    static long factorialRec(int n) {
        //TODO
        return -1;
    }


    static byte dayOfWeek(String s) {
        //TODO
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("xTimes('abc',2)= '" + xTimes("abc", 2) + "'");
        System.out.println("sumSquares(4)= " + sumSquares(4));

        System.out.println("\ndayOfWeek('luni') = " + dayOfWeek("luni"));
        System.out.println("dayOfWeek('DUMINICA') = " + dayOfWeek("DUMINICA"));
        System.out.println("dayOfWeek('invalid') = " + dayOfWeek("invalid"));

        System.out.println("\nfactorial(1) = " + factorial(1));
        System.out.println("factorial(5) = " + factorial(5));
        System.out.println("factorial(13) = " + factorial(13));
        System.out.println("factorialRec(1) = " + factorialRec(1));
        System.out.println("factorialRec(5) = " + factorialRec(5));
        System.out.println("factorialRec(13) = " + factorialRec(13));
    }
}

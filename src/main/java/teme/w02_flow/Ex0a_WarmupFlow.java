package teme.w02_flow;

class Ex0a_WarmupFlow {

    static void whichIsBigger(int a, int b) {
        if (a > b) {
            System.out.println("First number is bigger: " + a);
        } else if (b > a) {
            System.out.println("Second number is bigger: " + b);
        } else {
            System.out.println("Numbers are equal: " + a);
        }
    }

    static double max(double a, double b, double c) {
        if (a >= b && a >= c) {
            return a;
        }
        if (b >= a && b >= c) {
            return b;
        }
        return c;
    }

    static String xTimes(String s, int n) {
        String times = "";
        for (int i = 0; i < n; i++) {
            times += s;
        }
        return times;
    }

    static int sumSquares(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i * i;
        }
        return sum;
    }


    static long factorial(int n) {
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static long factorialRec(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialRec(n - 1);
    }


    static byte dayOfWeek(String s) {
        switch (s.toUpperCase()) {
            case "LUNI":
                return 1;
            case "MARTI":
                return 2;
            case "MIERCURI":
                return 3;
            case "JOI":
                return 4;
            case "VINERI":
                return 5;
            case "SAMBATA":
                return 6;
            case "DUMINICA":
                return 7;
            default:
                return -1;
        }
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

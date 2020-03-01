package teme.w03_recap;

class Ex2_CheckPrime {

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //test some primes
        testIt(2);
        testIt(13);
        testIt(997);
        testIt(10007);

        //also some non-primes
        testIt(0);
        testIt(1);
        testIt(6);
        testIt(10003);
    }

    //helper method for manual tests
    private static void testIt(int n) {
        System.out.println(n + " is prime?: " + isPrime(n));
    }
}

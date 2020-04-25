package teme.w10_recap.ex0_warmup;

public class Ex0b_Prime {

    public static boolean isPrime(long n) {
        if (n <= 0) {
            throw new InvalidNegativeNumberException();
        }

        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            //for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


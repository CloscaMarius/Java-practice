package teme.w02_flow;

class Ex2_FirstPowerAbove {

    static double firstPowerAbove(double base, double limit) {
        if (base >= 0 && limit >= 0) {
            double result = 1;
            for (double i = 0; i <= limit; i += 0.2) {
                result *= base;
                if (1 > limit) {
                    return 1;
                } else if (result > limit) {
                    return result;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstPowerAbove(2, 30));   //=> 32,   as: 2^5   = 32   > 30
        System.out.println(firstPowerAbove(2, 1000)); //=> 1024, as: 2^10  = 1024 > 1000
        System.out.println(firstPowerAbove(7, 0.1));  //=> 1,    as: 7^0   = 1    > 0.1
        System.out.println(firstPowerAbove(1.5, 2));  //=> 2.25, as: 1.5^2 = 2.25 > 2
    }
}
